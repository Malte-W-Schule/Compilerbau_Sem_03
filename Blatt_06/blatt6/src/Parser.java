import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int position;
    private Token currentToken;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.position = 0;
        this.currentToken = tokens.size() > 0 ? tokens.get(0) : null;
    }

    private void advance() {
        position++;
        if (position < tokens.size()) {
            currentToken = tokens.get(position);
        } else {
            currentToken = null;
        }
    }

    // Hilfsmethode zum Voraussschauen (Lookahead) ohne zu konsumieren
    private Token peek(int offset) {
        if (position + offset < tokens.size()) {
            return tokens.get(position + offset);
        }
        return null;
    }

    private void expect(Token.TokenType type) {
        if (currentToken == null || currentToken.getType() != type) {
            throw new ParserException(
                    String.format("Expected %s but got %s at %d:%d",
                            type,
                            currentToken != null ? currentToken.getType() : "EOF",
                            currentToken != null ? currentToken.getLine() : -1,
                            currentToken != null ? currentToken.getColumn() : -1));
        }
        advance();
    }

    public ProgramNode parse() {
        List<ASTNode> nodes = new ArrayList<>();

        while (currentToken != null && currentToken.getType() != Token.TokenType.EOF) {
            nodes.add(parseTopLevel());
        }

        return new ProgramNode(nodes);
    }

    // Neue Methode: Unterscheidet zwischen Statements (def) und Expressions (1, if, add)
    private ASTNode parseTopLevel() {
        if (currentToken.getType() == Token.TokenType.LPAREN) {
            Token next = peek(1);
            if (next != null && next.getType() == Token.TokenType.IDENTIFIER) {
                if (next.getValue().equals("def")) {
                    return parseDef();
                }
                if (next.getValue().equals("defn")) {
                    return parseDefn();
                }
            }
        }
        return parseExpression();
    }

    // Gibt jetzt strikt 'Expression' zurück
    private Expression parseExpression() {
        if (currentToken == null) {
            throw new ParserException("Unexpected end of input");
        }

        switch (currentToken.getType()) {
            case INTEGER:
                return parseInteger();
            case STRING:
                return parseString();
            case BOOLEAN:
                return parseBoolean();
            case IDENTIFIER:
                return parseVariable();
            case LPAREN:
                return parseListExpression(); // Umbenannt, da Statements hier nicht erlaubt sind
            default:
                throw new ParserException(
                        String.format("Unexpected token %s at %d:%d",
                                currentToken.getType(),
                                currentToken.getLine(),
                                currentToken.getColumn()));
        }
    }

    private IntegerNode parseInteger() {
        int value = Integer.parseInt(currentToken.getValue());
        advance();
        return new IntegerNode(value);
    }

    private StringNode parseString() {
        String value = currentToken.getValue();
        advance();
        return new StringNode(value);
    }

    private BooleanNode parseBoolean() {
        boolean value = Boolean.parseBoolean(currentToken.getValue());
        advance();
        return new BooleanNode(value);
    }

    private VariableNode parseVariable() {
        String name = currentToken.getValue();
        advance();
        return new VariableNode(name);
    }

    // Verarbeitet Listen, die Expressions sind (kein def/defn hier erlaubt!)
    private Expression parseListExpression() {
        expect(Token.TokenType.LPAREN);

        if (currentToken == null) {
            throw new ParserException("Unexpected end of input after '('");
        }

        // Empty list als Variable "list" interpretieren (oder Fehler werfen, je nach Sprachdesign)
        if (currentToken.getType() == Token.TokenType.RPAREN) {
            advance();
            // Leere Liste ist hier ein Call auf "list" ohne Argumente
            return new ListNode(new VariableNode("list"), new ArrayList<>());
        }

        // Check for special forms keywords
        if (currentToken.getType() == Token.TokenType.IDENTIFIER) {
            String keyword = currentToken.getValue();

            switch (keyword) {
                case "if":
                    return parseIf();
                case "let":
                    return parseLet();
                case "do":
                    return parseDo();
                case "def":
                case "defn":
                    throw new ParserException("Def and Defn are statements and cannot be used as expressions.");
                default:
                    return parseFunctionCall();
            }
        }

        return parseFunctionCall();
    }

    private DefNode parseDef() {
        expect(Token.TokenType.LPAREN); // '(' manuell prüfen, da parseTopLevel nur peekt
        advance(); // skip 'def'

        if (currentToken == null || currentToken.getType() != Token.TokenType.IDENTIFIER) {
            throw new ParserException("Expected identifier after 'def'");
        }

        String name = currentToken.getValue();
        advance();

        Expression value = parseExpression(); // Value muss Expression sein

        expect(Token.TokenType.RPAREN);

        return new DefNode(name, value);
    }

    private DefnNode parseDefn() {
        expect(Token.TokenType.LPAREN);
        advance(); // skip 'defn'

        if (currentToken == null || currentToken.getType() != Token.TokenType.IDENTIFIER) {
            throw new ParserException("Expected identifier after 'defn'");
        }

        String name = currentToken.getValue();
        advance();

        // Parse parameter list
        expect(Token.TokenType.LPAREN);
        List<String> parameters = new ArrayList<>();

        while (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            if (currentToken.getType() != Token.TokenType.IDENTIFIER) {
                throw new ParserException("Expected identifier in parameter list");
            }
            parameters.add(currentToken.getValue());
            advance();
        }

        expect(Token.TokenType.RPAREN);

        Expression body = parseExpression(); // Body muss Expression sein

        expect(Token.TokenType.RPAREN);

        return new DefnNode(name, parameters, body);
    }

    private IfNode parseIf() {
        advance(); // skip 'if'

        Expression condition = parseExpression();
        Expression thenBranch = parseExpression();

        Expression elseBranch = null;
        if (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            elseBranch = parseExpression();
        }

        expect(Token.TokenType.RPAREN);

        return new IfNode(condition, thenBranch, elseBranch);
    }
    private LetNode parseLet() {
        advance(); // skip 'let'

        expect(Token.TokenType.LPAREN); // Start der Bindings-Liste

        List<String> names = new ArrayList<>();
        List<Expression> values = new ArrayList<>();

        // Solange wir nicht am Ende der Bindings-Liste ')' sind
        while (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {

            // 1. Wir erwarten eine öffnende Klammer für das Paar (x 10)
            expect(Token.TokenType.LPAREN);

            // 2. Jetzt muss der Name kommen
            if (currentToken.getType() != Token.TokenType.IDENTIFIER) {
                throw new ParserException("Expected identifier name in let binding");
            }
            names.add(currentToken.getValue());
            advance();

            // 3. Jetzt kommt der Wert (Expression)
            values.add(parseExpression());

            // 4. Wir erwarten eine schließende Klammer für das Paar
            expect(Token.TokenType.RPAREN);
        }

        expect(Token.TokenType.RPAREN); // Ende der Bindings-Liste

        Expression body = parseExpression(); // Der Body (z.B. (+ x y))

        expect(Token.TokenType.RPAREN); // Ende des gesamten let-Ausdrucks

        return new LetNode(names, values, body);
    }

    private DoNode parseDo() {
        advance(); // skip 'do'

        // DoNode darf Statements enthalten, auch wenn es selbst eine Expression ist
        // (es gibt den Wert des letzten Elements zurück)
        List<ASTNode> nodes = new ArrayList<>();

        while (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            // Hier nutzen wir parseTopLevel, um auch 'def' innerhalb von 'do' zu erlauben (optional)
            // Wenn keine lokalen Definitionen erlaubt sein sollen, nutze parseExpression()
            nodes.add(parseTopLevel());
        }

        expect(Token.TokenType.RPAREN);

        return new DoNode(nodes);
    }

    private Expression parseFunctionCall() {
        // 1. Operator parsen
        Expression operator = parseExpression();

        List<Expression> arguments = new ArrayList<>();

        // 2. Alle Argumente einsammeln
        while (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            arguments.add(parseExpression());
        }

        // 3. WICHTIG: Erst die Klammer zumachen!
        expect(Token.TokenType.RPAREN);

        // 4. Entscheidung: Umwandeln (Desugaring) oder flach lassen?
        // Wir wandeln nur um, wenn es ein BinOp ist UND mehr als 2 Argumente hat.
        // (Bei genau 2 Argumenten ist es ja schon binär, da sparen wir uns die Arbeit).
        if (isBinOp(operator.toSExpression()) && arguments.size() > 2) {
            return sugarExpression(operator, arguments); // <-- Hier das Ergebnis ZURÜCKGEBEN
        }

        // 5. Standardfall (kein BinOp oder weniger als 3 Argumente)
        return new ListNode(operator, arguments);
    }

    // Ich habe die Methode mal in "desugar..." umbenannt, da wir den "Zucker" (die Abkürzung) entfernen.
    private Expression sugarExpression(Expression operator, List<Expression> arguments) {
        // Start mit den ersten beiden: (+ 1 2)
        ListNode current = new ListNode(operator, List.of(arguments.get(0), arguments.get(1)));

        // Den Rest schrittweise anfügen
        for (int i = 2; i < arguments.size(); i++) {
            // Das vorherige Ergebnis wird zum linken Argument des neuen Knotens
            current = new ListNode(operator, List.of(current, arguments.get(i)));
        }

        return current;
    }

    private boolean isBinOp(String eingabe) {
        // Kleiner Tipp: .equals ist hier korrekt, aber switch ist oft lesbarer bei Strings ab Java 7
        return eingabe.equals("+") || eingabe.equals("-") || eingabe.equals("*") || eingabe.equals("/");
    }

    public static class ParserException extends RuntimeException {
        public ParserException(String message) {
            super(message);
        }
    }
}