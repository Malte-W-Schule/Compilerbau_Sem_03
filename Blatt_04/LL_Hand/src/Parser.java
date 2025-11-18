public class Parser {

    public Lexer lexer;
    public Token lookahead; // Das aktuelle Token

    public Parser(String input) {
        lexer = new Lexer(input);
        lookahead = lexer.nextToken();
    }

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

    // ====================================================================
    // 1. OBERSTE REGEL: Programm
    // Programm: Expression* EOF
    // ====================================================================

    public void parse() {
        program();
        System.out.println("Parsing erfolgreich abgeschlossen.");
    }

    public void program() {
        // Ein Programm besteht aus einer oder mehreren Expressions bis zum EOF
        while (lookahead.getType() != TokenType.EOF) {
            expression();
        }
        match(TokenType.EOF);
    }

    // ====================================================================
    // 2. AUSDRÜCKE: Expression (die zentrale Regel)
    // Expression: Literal | IDENTIFIER | SExpression
    // ====================================================================

    public void expression() {
        TokenType type = lookahead.getType();

        if (type == TokenType.INTEGER || type == TokenType.STRING ||
                type == TokenType.BOOLEAN_TRUE || type == TokenType.BOOLEAN_FALSE) {

            literal();

        } else if (type == TokenType.IDENTIFIER) {
            // Variable oder ungebundener Funktionsname
            match(TokenType.IDENTIFIER);

        } else if (type == TokenType.LPAREN) {
            // Eine S-Expression (Liste/Aufruf/Kontrollstruktur)
            sExpression();

        } else {
            throw new RuntimeException("Syntax Error: Expected Expression (Literal, Identifier, or List), found " + type);
        }
    }

    public void literal() {
        TokenType type = lookahead.getType();

        if (type == TokenType.INTEGER) {
            match(TokenType.INTEGER);
        } else if (type == TokenType.STRING) {
            match(TokenType.STRING);
        } else if (type == TokenType.BOOLEAN_TRUE) {
            match(TokenType.BOOLEAN_TRUE);
        } else if (type == TokenType.BOOLEAN_FALSE) {
            match(TokenType.BOOLEAN_FALSE);
        } else {
            // Sollte nicht passieren, da bereits in expression() geprüft
            throw new RuntimeException("Internal Error: Literal parse failed.");
        }
    }

    // ====================================================================
    // 3. LISTENSTRUKTUR: SExpression
    // SExpression: '(' Head Expression* ')'
    // ====================================================================

    public void sExpression() {
        match(TokenType.LPAREN);

        // Das Head-Token entscheidet über die Semantik der Liste
        sExprHead();

        // Die restlichen Expressionen sind die Argumente/Körper-Teile
        while (lookahead.getType() != TokenType.RPAREN) {
            expression();
        }

        match(TokenType.RPAREN);
    }

    // ====================================================================
    // 4. SPEZIFISCHE REGELN (Head der S-Expression)
    // ====================================================================

    // Head: IF | DO | DEF | DEFN | LET | Operator | BuiltIn | IDENTIFIER (Funktionsaufruf)
    public void sExprHead() {
        TokenType type = lookahead.getType();

        // --- Kontrollstrukturen/Definitionen ---
        if (type == TokenType.IF) {
            parseIf();
        } else if (type == TokenType.DO) {
            match(TokenType.DO);
        } else if (type == TokenType.DEF) {
            parseDef();
        } else if (type == TokenType.DEFN) {
            parseDefn();
        } else if (type == TokenType.LET) {
            parseLet();

            // --- Operatoren/Built-ins/Funktionsaufrufe ---
        } else if (isOperator(type) || isBuiltIn(type) || type == TokenType.LIST || type == TokenType.IDENTIFIER) {
            // Die Regel wird aufgerufen, um das Head-Token zu konsumieren
            match(type);

        } else {
            throw new RuntimeException("Syntax Error: Invalid S-Expression head: " + type);
        }
    }

    // -- Hilfsmethoden zur Klassifizierung --
    private boolean isOperator(TokenType type) {
        return type == TokenType.PLUS || type == TokenType.MINUS || type == TokenType.MULT ||
                type == TokenType.DIV || type == TokenType.EQ || type == TokenType.GT || type == TokenType.LT;
    }

    private boolean isBuiltIn(TokenType type) {
        return type == TokenType.PRINT || type == TokenType.STR || type == TokenType.NTH ||
                type == TokenType.HEAD || type == TokenType.TAIL;
    }

    // --- Spezifische Struktur-Regeln ---

    // (if boolean-form then-form optional-else-form)
    public void parseIf() {
        match(TokenType.IF);

        // boolean-form (Expression)
        expression();
        // then-form (Expression)
        expression();

        // optional-else-form
        if (lookahead.getType() != TokenType.RPAREN) {
            expression();
        }
    }

    // (def name value)
    public void parseDef() {
        match(TokenType.DEF);
        match(TokenType.IDENTIFIER); // name
        expression();               // value
    }

    // (defn name (params*) body)
    public void parseDefn() {
        match(TokenType.DEFN);
        match(TokenType.IDENTIFIER); // name

        // (params*)
        match(TokenType.LPAREN);
        while (lookahead.getType() == TokenType.IDENTIFIER) {
            match(TokenType.IDENTIFIER);
        }
        match(TokenType.RPAREN);

        // body (Expression)
        expression();
    }

    // (let (bindings*) body)
    // bindings* : (IDENTIFIER Expression)*
    public void parseLet() {
        match(TokenType.LET);

        // (bindings*)
        match(TokenType.LPAREN);
        // Bindungen kommen paarweise: Name, Wert
        while (lookahead.getType() == TokenType.IDENTIFIER) {
            match(TokenType.IDENTIFIER); // Name
            expression();               // Wert
        }
        match(TokenType.RPAREN);

        // body (Expression)
        expression();
    }
}