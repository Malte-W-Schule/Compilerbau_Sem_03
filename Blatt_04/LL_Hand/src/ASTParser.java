import Nodes.*;

import java.util.ArrayList;
import java.util.List;

public class ASTParser {

    public Lexer lexer;
    public Token lookahead; // Das aktuelle Token

    public ASTParser(String input) {
        lexer = new Lexer(input);
        lookahead = lexer.nextToken();
    }

    // ====================================================================
    // HILFSMETHODEN
    // ====================================================================

    /**
     * Prüft, ob das Lookahead-Token vom erwarteten Typ ist.
     * Wenn ja, konsumiert es das Token. Wenn nein, wirft es einen Syntaxfehler.
     */
    public void match(TokenType expectedType) {
        if (this.lookahead.getType() == expectedType) {
            consume();
        } else {
            String errorMsg = String.format(
                    "Syntax Error: Expected %s but found %s ('%s') at Row: %d, Column: %d",
                    expectedType, lookahead.getType(), lookahead.getValue(), lookahead.getRow(), lookahead.getColum()
            );
            throw new RuntimeException(errorMsg);
        }
    }

    /**
     * Lädt das nächste Token vom Lexer.
     */
    public void consume() {
        lookahead = lexer.nextToken();
    }

    private boolean isOperator(TokenType type) {
        return type == TokenType.PLUS || type == TokenType.MINUS || type == TokenType.MULT ||
                type == TokenType.DIV || type == TokenType.EQ || type == TokenType.GT || type == TokenType.LT;
    }

    private boolean isBuiltIn(TokenType type) {
        return type == TokenType.PRINT || type == TokenType.STR || type == TokenType.NTH ||
                type == TokenType.HEAD || type == TokenType.TAIL;
    }

    // ====================================================================
    // 1. OBERSTE REGEL: Programm
    // ====================================================================

    /**
     * Startet den Parservorgang und gibt die Liste aller AST-Wurzelknoten zurück.
     */
    public List<ASTNode> parse() {
        List<ASTNode> ast = program();
        System.out.println("Parsing erfolgreich abgeschlossen.");
        return ast;
    }

    public List<ASTNode> program() {
        List<ASTNode> nodes = new ArrayList<>();
        // Ein Programm besteht aus einer oder mehreren Expressions bis zum EOF
        while (lookahead.getType() != TokenType.EOF) {
            nodes.add(expression());
        }
        match(TokenType.EOF);
        return nodes;
    }

    // ====================================================================
    // 2. AUSDRÜCKE: Expression (die zentrale rekursive Regel)
    // ====================================================================

    public ASTNode expression() {
        TokenType type = lookahead.getType();
        Token token = lookahead;

        if (type == TokenType.INTEGER || type == TokenType.STRING ||
                type == TokenType.BOOLEAN_TRUE || type == TokenType.BOOLEAN_FALSE) {
            // LiteralNode wird in literal() erstellt
            return literal();

        } else if (type == TokenType.IDENTIFIER) {
            // IdentifierNode wird hier direkt erstellt
            match(TokenType.IDENTIFIER);
            return new IdentifierNode(token.getValue(), token.getRow(), token.getColum());

        } else if (type == TokenType.LPAREN) {
            // SExpression wird in sExpression() erstellt
            return sExpression();

        } else {
            throw new RuntimeException("Syntax Error: Expected Expression (Literal, Identifier, or List), found " + type);
        }
    }

    public LiteralNode literal() {
        Token token = lookahead;
        TokenType type = token.getType(); // Typ vor Konsumierung speichern

        // Match/Consume wird HIER ausgeführt, da dies die End-Regel für Literale ist
        match(type);

        if (type == TokenType.INTEGER) {
            int val = Integer.parseInt(token.getValue());
            return new IntegerLiteralNode(val, token.getRow(), token.getColum());
        } else if (type == TokenType.STRING) {
            String val = token.getValue();
            return new StringLiteralNode(val, token.getRow(), token.getColum());
        } else if (type == TokenType.BOOLEAN_TRUE) {
            boolean val = true; // Wert ist immer true
            return new BooleanLiteralNode(val, token.getRow(), token.getColum());
        } else if (type == TokenType.BOOLEAN_FALSE) {
            boolean val = false; // Wert ist immer false
            return new BooleanLiteralNode(val, token.getRow(), token.getColum());
        }
        // Sollte nie erreicht werden, dank expression()
        return null;
    }

    // ====================================================================
    // 3. LISTENSTRUKTUR: SExpression
    // ====================================================================

    public ASTNode sExpression() {
        Token lParen = lookahead;
        match(TokenType.LPAREN);

        // 1. Head-Knoten abrufen (enthält entweder Spezialstruktur oder leeren CallNode)
        ASTNode headNode = sExprHead(lParen);

        // --- Spezialform-Check ---
        // Wir prüfen, ob der Knoten eine Spezialform (Kontrollstruktur oder Definition) ist.
        if (headNode instanceof IfNode ||
                headNode instanceof DefNode ||
                headNode instanceof DefnNode ||
                headNode instanceof LetNode ||
                headNode instanceof DoNode)
        {
            // Da die parseIf/parseDef-Methoden in sExprHead() die Argumente
            // bereits intern konsumiert haben (z.B. (if COND THEN ELSE)),
            // muss sExpression() nur noch das abschließende RPAREN matchen.

            // HINWEIS: Dies setzt voraus, dass parseIf, parseDef, etc. alle
            // benötigten Argumente parsen, aber NICHT das abschließende RPAREN.

            // Die Argumente wurden bereits in den parse...-Methoden konsumiert.
            // Das nächste erwartete Token ist das RPAREN.
            match(TokenType.RPAREN);
            return headNode;
        }

        // --- Generischer CallNode-Aufbau (Operatoren, Built-ins, Funktionen) ---

        // Wenn es keine Spezialform ist, muss es ein CallNode sein.
        if (!(headNode instanceof CallNode)) {
            throw new RuntimeException("Internal Error: S-Expression head returned unhandled node type.");
        }

        CallNode callNode = (CallNode) headNode;

        // Die restlichen Expressionen sind die Argumente/Operanden
        while (lookahead.getType() != TokenType.RPAREN) {
            callNode.arguments.add(expression());
        }

        match(TokenType.RPAREN);
        return callNode;
    }

    // ====================================================================
    // 4. SPEZIFISCHE REGELN (Head der S-Expression)
    // ====================================================================

    /**
     * Parsed den Head einer S-Expression. Gibt den erzeugten AST-Knoten zurück,
     * der entweder eine CallNode (für Operatoren/Built-ins) oder eine spezielle
     * Kontrollstruktur (IfNode, DefNode) sein kann.
     */
    public ASTNode sExprHead(Token lParen) {
        TokenType type = lookahead.getType();

        // --- Kontrollstrukturen/Definitionen (Spezialformen) ---
        if (type == TokenType.IF) {
            return parseIf(lParen);
        } else if (type == TokenType.DO) {
            match(TokenType.DO); // DO ist nur ein Token, die Argumente folgen
            return new DoNode(lParen.getRow(), lParen.getColum());
        } else if (type == TokenType.DEF) {
            return parseDef(lParen);
        } else if (type == TokenType.DEFN) {
            return parseDefn(lParen);
        } else if (type == TokenType.LET) {
            return parseLet(lParen);

            // --- Operatoren/Built-ins/Funktionsaufrufe (Generische Aufrufe) ---
        } else if (isOperator(type) || isBuiltIn(type) || type == TokenType.LIST || type == TokenType.IDENTIFIER) {
            Token headToken = lookahead;
            // Das Head-Token konsumieren und einen leeren CallNode zurückgeben
            match(type);
            // Die Argumente werden in sExpression() gesammelt
            return new CallNode(headToken.getValue(), new ArrayList<>(), headToken.getRow(), headToken.getColum());

        } else {
            throw new RuntimeException("Syntax Error: Invalid S-Expression head: " + type);
        }
    }

    // (if boolean-form then-form optional-else-form)
    public IfNode parseIf(Token lParen) {
        match(TokenType.IF);

        // boolean-form (Expression)
        ASTNode cond = expression();
        // then-form (Expression)
        ASTNode thenBranch = expression();

        // optional-else-form
        ASTNode elseBranch = null;
        if (lookahead.getType() != TokenType.RPAREN) {
            elseBranch = expression();
        }

        // Verwende die Position des '(' Tokens
        return new IfNode(cond, thenBranch, elseBranch, lParen.getRow(), lParen.getColum());
    }

    // (def name value)
    public DefNode parseDef(Token lParen) {
        match(TokenType.DEF);

        Token nameToken = lookahead;
        match(TokenType.IDENTIFIER); // name

        ASTNode value = expression(); // value

        return new DefNode(nameToken.getValue(), value, lParen.getRow(), lParen.getColum());
    }

    // (defn name (params*) body)
    public DefnNode parseDefn(Token lParen) {
        match(TokenType.DEFN);

        Token nameToken = lookahead;
        match(TokenType.IDENTIFIER); // name

        // (params*)
        match(TokenType.LPAREN);
        List<String> parameters = new ArrayList<>();
        while (lookahead.getType() == TokenType.IDENTIFIER) {
            parameters.add(lookahead.getValue());
            match(TokenType.IDENTIFIER);
        }
        match(TokenType.RPAREN);

        // body (Expression)
        ASTNode body = expression();

        return new DefnNode(nameToken.getValue(), parameters, body, lParen.getRow(), lParen.getColum());
    }

    // (let (bindings*) body)
    // bindings* : (IDENTIFIER Expression)*
    public LetNode parseLet(Token lParen) {
        match(TokenType.LET);

        // (bindings*)
        match(TokenType.LPAREN);
        List<LetBinding> bindings = new ArrayList<>();

        // Bindungen kommen paarweise: Name, Wert
        while (lookahead.getType() == TokenType.IDENTIFIER) {
            Token nameToken = lookahead;
            match(TokenType.IDENTIFIER); // Name
            ASTNode value = expression();               // Wert

            bindings.add(new LetBinding(nameToken.getValue(), value));
        }
        match(TokenType.RPAREN);

        // body (Expression)
        ASTNode body = expression();

        return new LetNode(bindings, body, lParen.getRow(), lParen.getColum());
    }
}