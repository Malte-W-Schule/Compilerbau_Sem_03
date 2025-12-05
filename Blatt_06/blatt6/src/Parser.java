// Parser.java - Recursive Descent Parser
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
        List<ASTNode> expressions = new ArrayList<>();

        while (currentToken != null && currentToken.getType() != Token.TokenType.EOF) {
            expressions.add(parseExpression());
        }

        return new ProgramNode(expressions);
    }

    private ASTNode parseExpression() {
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
                return parseList();
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

    private ASTNode parseList() {
        expect(Token.TokenType.LPAREN);

        if (currentToken == null) {
            throw new ParserException("Unexpected end of input after '('");
        }

        // Empty list
        if (currentToken.getType() == Token.TokenType.RPAREN) {
            advance();
            return new ListNode(new VariableNode("list"), new ArrayList<>());
        }

        // Check for special forms
        if (currentToken.getType() == Token.TokenType.IDENTIFIER) {
            String keyword = currentToken.getValue();

            switch (keyword) {
                case "def":
                    return parseDef();
                case "defn":
                    return parseDefn();
                case "if":
                    return parseIf();
                case "let":
                    return parseLet();
                case "do":
                    return parseDo();
                default:
                    // Regular function call
                    return parseFunctionCall();
            }
        }

        // If not an identifier, parse as regular list
        return parseFunctionCall();
    }

    private DefNode parseDef() {
        advance(); // skip 'def'

        if (currentToken == null || currentToken.getType() != Token.TokenType.IDENTIFIER) {
            throw new ParserException("Expected identifier after 'def'");
        }

        String name = currentToken.getValue();
        advance();

        ASTNode value = parseExpression();

        expect(Token.TokenType.RPAREN);

        return new DefNode(name, value);
    }

    private DefnNode parseDefn() {
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

        // Parse body
        ASTNode body = parseExpression();

        expect(Token.TokenType.RPAREN);

        return new DefnNode(name, parameters, body);
    }

    private IfNode parseIf() {
        advance(); // skip 'if'

        ASTNode condition = parseExpression();
        ASTNode thenBranch = parseExpression();

        ASTNode elseBranch = null;
        if (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            elseBranch = parseExpression();
        }

        expect(Token.TokenType.RPAREN);

        return new IfNode(condition, thenBranch, elseBranch);
    }

    private LetNode parseLet() {
        advance(); // skip 'let'

        // Parse bindings
        expect(Token.TokenType.LPAREN);

        List<String> names = new ArrayList<>();
        List<ASTNode> values = new ArrayList<>();

        while (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            if (currentToken.getType() != Token.TokenType.IDENTIFIER) {
                throw new ParserException("Expected identifier in let bindings");
            }
            names.add(currentToken.getValue());
            advance();

            values.add(parseExpression());
        }

        expect(Token.TokenType.RPAREN);

        // Parse body
        ASTNode body = parseExpression();

        expect(Token.TokenType.RPAREN);

        return new LetNode(names, values, body);
    }

    private DoNode parseDo() {
        advance(); // skip 'do'

        List<ASTNode> expressions = new ArrayList<>();

        while (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            expressions.add(parseExpression());
        }

        expect(Token.TokenType.RPAREN);

        return new DoNode(expressions);
    }

    private ListNode parseFunctionCall() {
        ASTNode operator = parseExpression();

        List<ASTNode> arguments = new ArrayList<>();

        while (currentToken != null && currentToken.getType() != Token.TokenType.RPAREN) {
            arguments.add(parseExpression());
        }

        expect(Token.TokenType.RPAREN);

        return new ListNode(operator, arguments);
    }

    public static class ParserException extends RuntimeException {
        public ParserException(String message) {
            super(message);
        }
    }
}