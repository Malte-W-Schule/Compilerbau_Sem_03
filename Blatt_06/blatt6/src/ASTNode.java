// AST.java - Abstract Syntax Tree Node Definitions mit Typsicherheit
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

// === ABSTRAKTE BASISKLASSEN ===

// Alles, was einen Wert zurückgibt (z.B. 1, "hallo", x + y)
abstract class Expression extends ASTNode {}

// Alles, was eine Aktion ausführt/definiert, aber keinen Wert hat (z.B. def x)
abstract class Statement extends ASTNode {}

// === PROGRAMM ROOT ===

class ProgramNode extends ASTNode {
    // Ein Programm kann Statements (Definitionen) und Expressions (Berechnungen) enthalten
    private final List<ASTNode> nodes;

    public ProgramNode(List<ASTNode> nodes) {
        this.nodes = nodes;
    }

    public List<ASTNode> getNodes() {
        return nodes;
    }

    @Override
    public String toSExpression() {
        return nodes.stream()
                .map(ASTNode::toSExpression)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Program:\n");
        for (ASTNode node : nodes) {
            sb.append(node.prettyPrint(indent + 1)).append("\n");
        }
        return sb.toString();
    }
}

// === EXPRESSIONS (WERTE) ===

class IntegerNode extends Expression {
    private final int value;

    public IntegerNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toSExpression() { return String.valueOf(value); }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "Integer: " + value;
    }
}

class StringNode extends Expression {
    private final String value;

    public StringNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toSExpression() { return "\"" + value.replace("\n", "\\n") + "\""; }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "String: \"" + value + "\"";
    }
}

class BooleanNode extends Expression {
    private final boolean value;

    public BooleanNode(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toSExpression() { return String.valueOf(value); }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "Boolean: " + value;
    }
}

class VariableNode extends Expression {
    private final String name;

    public VariableNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toSExpression() { return name; }

    @Override
    public String prettyPrint(int indent) {
        return getIndent(indent) + "Variable: " + name;
    }
}

// Funktionsaufruf: (add 1 2)
class ListNode extends Expression {
    private final Expression operator;     // Der Operator muss ein Ausdruck sein (z.B. Variable)
    private final List<Expression> arguments; // Argumente müssen Ausdrücke sein

    public ListNode(Expression operator, List<Expression> arguments) {
        this.operator = operator;
        this.arguments = arguments;
    }

    public Expression getOperator() {
        return operator;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public String toSExpression() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(operator.toSExpression());
        for (Expression arg : arguments) {
            sb.append(" ").append(arg.toSExpression());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Call (List):\n");
        sb.append(getIndent(indent + 1)).append("Operator:\n");
        sb.append(operator.prettyPrint(indent + 2)).append("\n");
        if (!arguments.isEmpty()) {
            sb.append(getIndent(indent + 1)).append("Arguments:\n");
            for (Expression arg : arguments) {
                sb.append(arg.prettyPrint(indent + 2)).append("\n");
            }
        }
        return sb.toString();
    }
}

class IfNode extends Expression {
    private final Expression condition;  // Bedingung muss ein Wert sein
    private final Expression thenBranch; // Zweige müssen Werte liefern
    private final Expression elseBranch;

    public IfNode(Expression condition, Expression thenBranch, Expression elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getThenBranch() {
        return thenBranch;
    }

    public Expression getElseBranch() {
        return elseBranch;
    }

    @Override
    public String toSExpression() {
        String result = "(if " + condition.toSExpression() + " " + thenBranch.toSExpression();
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
        sb.append(getIndent(indent + 1)).append("Condition:\n").append(condition.prettyPrint(indent + 2)).append("\n");
        sb.append(getIndent(indent + 1)).append("Then:\n").append(thenBranch.prettyPrint(indent + 2));
        if (elseBranch != null) {
            sb.append("\n").append(getIndent(indent + 1)).append("Else:\n").append(elseBranch.prettyPrint(indent + 2));
        }
        return sb.toString();
    }
}

class DoNode extends Expression {
    // Do-Block gibt den letzten Wert zurück, darf aber zwischendrin Statements enthalten (Seiteneffekte)
    private final List<ASTNode> nodes;

    public DoNode(List<ASTNode> nodes) {
        this.nodes = nodes;
    }

    public List<ASTNode> getNodes() {
        return nodes;
    }

    @Override
    public String toSExpression() {
        StringBuilder sb = new StringBuilder("(do");
        for (ASTNode node : nodes) {
            sb.append(" ").append(node.toSExpression());
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Do:\n");
        for (ASTNode node : nodes) {
            sb.append(node.prettyPrint(indent + 1)).append("\n");
        }
        return sb.toString();
    }
}

class LetNode extends Expression {
    private final List<String> names;
    private final List<Expression> values; // Zuweisungen müssen Expressions sein
    private final Expression body;         // Body muss Expression sein (Rückgabewert)

    public LetNode(List<String> names, List<Expression> values, Expression body) {
        this.names = names;
        this.values = values;
        this.body = body;
    }

    public List<String> getNames() {
        return names;
    }

    public List<Expression> getValues() {
        return values;
    }

    public Expression getBody() {
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

// === STATEMENTS (DEKLARATIONEN) ===

class DefNode extends Statement {
    private final String name;
    private final Expression value; // Zuweisung muss eine Expression sein

    public DefNode(String name, Expression value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public String toSExpression() {
        return "(def " + name + " " + value.toSExpression() + ")";
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndent(indent)).append("Def (Statement):\n");
        sb.append(getIndent(indent + 1)).append("Name: ").append(name).append("\n");
        sb.append(getIndent(indent + 1)).append("Value:\n");
        sb.append(value.prettyPrint(indent + 2));
        return sb.toString();
    }
}

class DefnNode extends Statement {
    private final String name;
    private final List<String> parameters;
    private final Expression body; // Body einer Funktion ist eine Expression (impliziter Return)

    public DefnNode(String name, List<String> parameters, Expression body) {
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

    public Expression getBody() {
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
        sb.append(getIndent(indent)).append("Defn (Statement):\n");
        sb.append(getIndent(indent + 1)).append("Name: ").append(name).append("\n");
        sb.append(getIndent(indent + 1)).append("Params: ").append(parameters).append("\n");
        sb.append(getIndent(indent + 1)).append("Body:\n");
        sb.append(body.prettyPrint(indent + 2));
        return sb.toString();
    }
}