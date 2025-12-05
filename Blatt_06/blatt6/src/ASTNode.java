// AST.java - Abstract Syntax Tree Node Definitions
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class ASTNode {
    public abstract String toSExpression();
    public abstract String prettyPrint(int indent);

    protected String getIndent(int level) {
        return "  ".repeat(level);
    }
}

// Program node (root)
class ProgramNode extends ASTNode {
    private final List<ASTNode> expressions;

    public ProgramNode(List<ASTNode> expressions) {
        this.expressions = expressions;
    }

    public List<ASTNode> getExpressions() {
        return expressions;
    }

    @Override
    public String toSExpression() {
        return expressions.stream()
                .map(ASTNode::toSExpression)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Program:\n");
        for (ASTNode expr : expressions) {
            sb.append(expr.prettyPrint(indent + 1)).append("\n");
        }
        return sb.toString();
    }
}

// Literal nodes
class IntegerNode extends ASTNode {
    private final int value;

    public IntegerNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toSExpression() {
        return String.valueOf(value);
    }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "Integer: " + value;
    }
}

class StringNode extends ASTNode {
    private final String value;

    public StringNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toSExpression() {
        return "\"" + value.replace("\n", "\\n") + "\"";
    }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "String: \"" + value + "\"";
    }
}

class BooleanNode extends ASTNode {
    private final boolean value;

    public BooleanNode(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toSExpression() {
        return String.valueOf(value);
    }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "Boolean: " + value;
    }
}

// Variable reference
class VariableNode extends ASTNode {
    private final String name;

    public VariableNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toSExpression() {
        return name;
    }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "Variable: " + name;
    }
}

// List/Function call
class ListNode extends ASTNode {
    private final ASTNode operator;
    private final List<ASTNode> arguments;

    public ListNode(ASTNode operator, List<ASTNode> arguments) {
        this.operator = operator;
        this.arguments = arguments;
    }

    public ASTNode getOperator() {
        return operator;
    }

    public List<ASTNode> getArguments() {
        return arguments;
    }

    @Override
    public String toSExpression() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(operator.toSExpression());
        for (ASTNode arg : arguments) {
            sb.append(" ");
            sb.append(arg.toSExpression());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("List:\n");
        sb.append(getIndent(indent + 1)).append("Operator:\n");
        sb.append(operator.prettyPrint(indent + 2)).append("\n");
        if (!arguments.isEmpty()) {
            sb.append(getIndent(indent + 1)).append("Arguments:\n");
            for (int i = 0; i < arguments.size(); i++) {
                sb.append(arguments.get(i).prettyPrint(indent + 2));
                if (i < arguments.size() - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}

// Special forms
class DefNode extends ASTNode {
    private final String name;
    private final ASTNode value;

    public DefNode(String name, ASTNode value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public ASTNode getValue() {
        return value;
    }

    @Override
    public String toSExpression() {
        return "(def " + name + " " + value.toSExpression() + ")";
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Def:\n");
        sb.append(getIndent(indent + 1)).append("Name: ").append(name).append("\n");
        sb.append(getIndent(indent + 1)).append("Value:\n");
        sb.append(value.prettyPrint(indent + 2));
        return sb.toString();
    }
}

class DefnNode extends ASTNode {
    private final String name;
    private final List<String> parameters;
    private final ASTNode body;

    public DefnNode(String name, List<String> parameters, ASTNode body) {
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public ASTNode getBody() {
        return body;
    }

    @Override
    public String toSExpression() {
        return "(defn " + name + " (" + String.join(" ", parameters) + ") " +
                body.toSExpression() + ")";
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Defn:\n");
        sb.append(getIndent(indent + 1)).append("Name: ").append(name).append("\n");
        sb.append(getIndent(indent + 1)).append("Parameters: ").append(parameters).append("\n");
        sb.append(getIndent(indent + 1)).append("Body:\n");
        sb.append(body.prettyPrint(indent + 2));
        return sb.toString();
    }
}

class IfNode extends ASTNode {
    private final ASTNode condition;
    private final ASTNode thenBranch;
    private final ASTNode elseBranch;

    public IfNode(ASTNode condition, ASTNode thenBranch, ASTNode elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public ASTNode getCondition() {
        return condition;
    }

    public ASTNode getThenBranch() {
        return thenBranch;
    }

    public ASTNode getElseBranch() {
        return elseBranch;
    }

    @Override
    public String toSExpression() {
        String result = "(if " + condition.toSExpression() + " " +
                thenBranch.toSExpression();
        if (elseBranch != null) {
            result += " " + elseBranch.toSExpression();
        }
        result += ")";
        return result;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("If:\n");
        sb.append(getIndent(indent + 1)).append("Condition:\n");
        sb.append(condition.prettyPrint(indent + 2)).append("\n");
        sb.append(getIndent(indent + 1)).append("Then:\n");
        sb.append(thenBranch.prettyPrint(indent + 2));
        if (elseBranch != null) {
            sb.append("\n").append(getIndent(indent + 1)).append("Else:\n");
            sb.append(elseBranch.prettyPrint(indent + 2));
        }
        return sb.toString();
    }
}

class DoNode extends ASTNode {
    private final List<ASTNode> expressions;

    public DoNode(List<ASTNode> expressions) {
        this.expressions = expressions;
    }

    public List<ASTNode> getExpressions() {
        return expressions;
    }

    @Override
    public String toSExpression() {
        StringBuilder sb = new StringBuilder("(do");
        for (ASTNode expr : expressions) {
            sb.append(" ").append(expr.toSExpression());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Do:\n");
        for (int i = 0; i < expressions.size(); i++) {
            sb.append(expressions.get(i).prettyPrint(indent + 1));
            if (i < expressions.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

class LetNode extends ASTNode {
    private final List<String> names;
    private final List<ASTNode> values;
    private final ASTNode body;

    public LetNode(List<String> names, List<ASTNode> values, ASTNode body) {
        this.names = names;
        this.values = values;
        this.body = body;
    }

    public List<String> getNames() {
        return names;
    }

    public List<ASTNode> getValues() {
        return values;
    }

    public ASTNode getBody() {
        return body;
    }

    @Override
    public String toSExpression() {
        StringBuilder sb = new StringBuilder("(let (");
        for (int i = 0; i < names.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(names.get(i)).append(" ").append(values.get(i).toSExpression());
        }
        sb.append(") ").append(body.toSExpression()).append(")");
        return sb.toString();
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Let:\n");
        sb.append(getIndent(indent + 1)).append("Bindings:\n");
        for (int i = 0; i < names.size(); i++) {
            sb.append(getIndent(indent + 2)).append(names.get(i)).append(" =\n");
            sb.append(values.get(i).prettyPrint(indent + 3)).append("\n");
        }
        sb.append(getIndent(indent + 1)).append("Body:\n");
        sb.append(body.prettyPrint(indent + 2));
        return sb.toString();
    }
}