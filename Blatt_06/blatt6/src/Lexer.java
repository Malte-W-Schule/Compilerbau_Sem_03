// Lexer.java
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private int position;
    private int line;
    private int column;
    private char currentChar;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.line = 1;
        this.column = 1;
        this.currentChar = input.length() > 0 ? input.charAt(0) : '\0';
    }

    private void advance() {
        if (currentChar == '\n') {
            line++;
            column = 1;
        } else {
            column++;
        }

        position++;
        if (position < input.length()) {
            currentChar = input.charAt(position);
        } else {
            currentChar = '\0';
        }
    }

    private char peek(int offset) {
        int pos = position + offset;
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }

    private void skipWhitespace() {
        while (currentChar != '\0' && Character.isWhitespace(currentChar)) {
            advance();
        }
    }

    private void skipComment() {
        // Skip until end of line
        while (currentChar != '\0' && currentChar != '\n') {
            advance();
        }
    }

    private Token readString() {
        int startLine = line;
        int startColumn = column;
        StringBuilder sb = new StringBuilder();

        advance(); // Skip opening quote

        while (currentChar != '\0' && currentChar != '"') {
            if (currentChar == '\\') {
                advance();
                switch (currentChar) {
                    case 'n': sb.append('\n'); break;
                    case 't': sb.append('\t'); break;
                    case 'r': sb.append('\r'); break;
                    case '\\': sb.append('\\'); break;
                    case '"': sb.append('"'); break;
                    default:
                        throw new LexerException(
                                String.format("Invalid escape sequence: \\%c at %d:%d",
                                        currentChar, line, column));
                }
                advance();
            } else {
                sb.append(currentChar);
                advance();
            }
        }

        if (currentChar != '"') {
            throw new LexerException(
                    String.format("Unterminated string at %d:%d", startLine, startColumn));
        }

        advance(); // Skip closing quote
        return new Token(Token.TokenType.STRING, sb.toString(), startLine, startColumn);
    }

    private Token readNumber() {
        int startLine = line;
        int startColumn = column;
        StringBuilder sb = new StringBuilder();

        // Handle negative numbers
        if (currentChar == '-') {
            sb.append(currentChar);
            advance();
        }

        while (currentChar != '\0' && Character.isDigit(currentChar)) {
            sb.append(currentChar);
            advance();
        }

        return new Token(Token.TokenType.INTEGER, sb.toString(), startLine, startColumn);
    }

    private Token readIdentifier() {
        int startLine = line;
        int startColumn = column;
        StringBuilder sb = new StringBuilder();

        while (currentChar != '\0' &&
                (Character.isLetterOrDigit(currentChar) ||
                        currentChar == '_' || currentChar == '-' ||
                        currentChar == '+' || currentChar == '*' ||
                        currentChar == '/' || currentChar == '=' ||
                        currentChar == '<' || currentChar == '>' ||
                        currentChar == '?')) {
            sb.append(currentChar);
            advance();
        }

        String value = sb.toString();
        Token.TokenType type;

        // Check for boolean literals
        if (value.equals("true") || value.equals("false")) {
            type = Token.TokenType.BOOLEAN;
        } else {
            type = Token.TokenType.IDENTIFIER;
        }

        return new Token(type, value, startLine, startColumn);
    }

    public Token getNextToken() {
        while (currentChar != '\0') {
            // Skip whitespace
            if (Character.isWhitespace(currentChar)) {
                skipWhitespace();
                continue;
            }

            // Skip comments
            if (currentChar == ';' && peek(1) == ';') {
                skipComment();
                continue;
            }

            // String literals
            if (currentChar == '"') {
                return readString();
            }

            // Numbers (including negative)
            if (Character.isDigit(currentChar) ||
                    (currentChar == '-' && Character.isDigit(peek(1)))) {
                return readNumber();
            }

            // Left parenthesis
            if (currentChar == '(') {
                int l = line, c = column;
                advance();
                return new Token(Token.TokenType.LPAREN, "(", l, c);
            }

            // Right parenthesis
            if (currentChar == ')') {
                int l = line, c = column;
                advance();
                return new Token(Token.TokenType.RPAREN, ")", l, c);
            }

            // Identifiers and operators
            if (Character.isLetter(currentChar) ||
                    currentChar == '+' || currentChar == '-' ||
                    currentChar == '*' || currentChar == '/' ||
                    currentChar == '=' || currentChar == '<' ||
                    currentChar == '>') {
                return readIdentifier();
            }

            throw new LexerException(
                    String.format("Unexpected character '%c' at %d:%d",
                            currentChar, line, column));
        }

        return new Token(Token.TokenType.EOF, "", line, column);
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        Token token;

        do {
            token = getNextToken();
            if (token.getType() != Token.TokenType.COMMENT) {
                tokens.add(token);
            }
        } while (token.getType() != Token.TokenType.EOF);

        return tokens;
    }

    public static class LexerException extends RuntimeException {
        public LexerException(String message) {
            super(message);
        }
    }
}