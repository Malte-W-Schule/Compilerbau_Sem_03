import java.util.HashMap;
import java.util.Map;

public class Lexer {

    private String input;
    private int pos;
    private char peek;

    private int column;
    private int row;

    private static final Map<String, TokenType> keywords;
    static {
        keywords = new HashMap<>();
        // Schlüsselwörter und Built-ins
        keywords.put("if", TokenType.IF);
        keywords.put("do", TokenType.DO);
        keywords.put("def", TokenType.DEF);
        keywords.put("defn", TokenType.DEFN);
        keywords.put("let", TokenType.LET);
        keywords.put("list", TokenType.LIST);
        // Boolesche Literale
        keywords.put("true", TokenType.BOOLEAN_TRUE);
        keywords.put("false", TokenType.BOOLEAN_FALSE);
        // Eingebaute Funktionen
        keywords.put("print", TokenType.PRINT);
        keywords.put("str", TokenType.STR);
        keywords.put("nth", TokenType.NTH);
        keywords.put("head", TokenType.HEAD);
        keywords.put("tail", TokenType.TAIL);
    }


    public Lexer(String input) {
        this.input = input + "\0";
        this.pos = 0;
        this.row = 1;
        this.column = 0;
        consume();
    }

    public void start() {
        Token currentToken;

        // Die Schleife läuft, solange das aktuelle Token nicht EOF ist
        while (true) {
            currentToken = nextToken();

            if (currentToken.getType() == TokenType.EOF) {
                break; // Ende der Datei erreicht
            }

            // Hier startet die eigentliche Parselogik:
            // z.B. parseExpression(currentToken);
        }

        System.out.println("Parsing abgeschlossen (EOF erreicht).");
    }

    public Token nextToken() {
        skipWhitespaceAndComments();

        if (peek == '\0') {
            return new Token(TokenType.EOF, "EOF", this.column, this.row);
        }

        int tokenStartColumn = this.column;
        int tokenStartRow = this.row;

        switch (peek) {
            // Spezielle Zeichen
            case '(':
                consume();
                return new Token(TokenType.LPAREN, "(", tokenStartColumn, tokenStartRow);
            case ')':
                consume();
                return new Token(TokenType.RPAREN, ")", tokenStartColumn, tokenStartRow);

            // Operatoren
            case '+':
                consume();
                return new Token(TokenType.PLUS, "+", tokenStartColumn, tokenStartRow);
            case '-':
                consume();
                return new Token(TokenType.MINUS, "-", tokenStartColumn, tokenStartRow);
            case '*':
                consume();
                return new Token(TokenType.MULT, "*", tokenStartColumn, tokenStartRow);
            case '/':
                consume();
                return new Token(TokenType.DIV, "/", tokenStartColumn, tokenStartRow);
            case '=':
                consume();
                return new Token(TokenType.EQ, "=", tokenStartColumn, tokenStartRow);
            case '>':
                consume();
                return new Token(TokenType.GT, ">", tokenStartColumn, tokenStartRow);
            case '<':
                consume();
                return new Token(TokenType.LT, "<", tokenStartColumn, tokenStartRow);

            // String-Literale
            case '"':
                return stringLiteral();

            // Bezeichner und Literale
            default:
                if (isDigit(peek)) {
                    return number();
                }
                if (isLetter(peek) || peek == '_') {
                    return name();
                }

                // Fehlerbehandlung
                char invalidChar = this.peek;
                consume();
                System.err.println("Invalid Character '" + invalidChar + "' at Row: " + tokenStartRow + " Column: " + tokenStartColumn);
                return new Token(TokenType.ERROR, String.valueOf(invalidChar), tokenStartColumn, tokenStartRow);
        }
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public boolean isIdentifierChar(char c) {
        return isLetter(c) || isDigit(c) || c == '_';
    }

    public void skipWhitespaceAndComments() {
        while (true) {
            if (this.peek == ' ' || this.peek == '\t' || this.peek == '\r') {
                consume();
            } else if (this.peek == '\n') {
                consume();
                this.row++;
                this.column = 0;
            } else if (this.peek == ';') {
                while (this.peek != '\n' && this.peek != '\0') {
                    consume();
                }
            } else {
                break;
            }
        }
    }

    public Token name() {
        int tokenStartColumn = this.column;
        int tokenStartRow = this.row;
        StringBuilder buf = new StringBuilder();

        while (isIdentifierChar(this.peek)) {
            buf.append(this.peek);
            consume();
        }

        String lexeme = buf.toString();

        TokenType type = keywords.get(lexeme);
        if (type == null) {
            type = TokenType.IDENTIFIER;
        }

        return new Token(type, lexeme, tokenStartColumn, tokenStartRow);
    }

    public Token number() {
        int tokenStartColumn = this.column;
        int tokenStartRow = this.row;
        StringBuilder buf = new StringBuilder();

        while (isDigit(this.peek)) {
            buf.append(this.peek);
            consume();
        }

        String lexeme = buf.toString();
        return new Token(TokenType.INTEGER, lexeme, tokenStartColumn, tokenStartRow);
    }

    public Token stringLiteral() {
        int tokenStartColumn = this.column;
        int tokenStartRow = this.row;
        StringBuilder buf = new StringBuilder();

        consume(); // Das öffnende '"' verwerfen

        while (this.peek != '"' && this.peek != '\0' && this.peek != '\n') {
            if (this.peek == '\\') {
                consume(); // Das '\\' verwerfen
                switch (this.peek) {
                    case 'n': buf.append('\n'); break;
                    case 't': buf.append('\t'); break;
                    case '"': buf.append('"'); break;
                    case '\\': buf.append('\\'); break;
                    default:
                        System.err.println("Warning: Invalid escape sequence '\\" + this.peek + "'");
                        buf.append(this.peek);
                }
            } else {
                buf.append(this.peek);
            }
            consume();
        }

        if (this.peek != '"') {
            System.err.println("Error: Unclosed string literal started at Row: " + tokenStartRow + " Column: " + tokenStartColumn);
            return new Token(TokenType.ERROR, buf.toString(), tokenStartColumn, tokenStartRow);
        }

        consume(); // Das schließende '"' verwerfen

        return new Token(TokenType.STRING, buf.toString(), tokenStartColumn, tokenStartRow);
    }

    public void consume() {
        if (this.pos < this.input.length()) {
            this.peek = this.input.charAt(this.pos);
            this.pos++;
            this.column++;
        } else {
            this.peek = '\0';
        }
    }
}