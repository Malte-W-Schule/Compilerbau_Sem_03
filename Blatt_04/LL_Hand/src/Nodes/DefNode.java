package Nodes;

// DefNode.java
public class DefNode extends ASTNode {
    public final String name;
    public final ASTNode value; // Der Ausdruck, der der Variablen zugewiesen wird

    public DefNode(String name, ASTNode value, int row, int column) {
        super(row, column);
        this.name = name;
        this.value = value;

        System.out.println(value+" at row "+row+" column "+column);
    }

    @Override
    public String toString() {
        return String.format("DEF(Name: %s, Value: %s)", name, value);
    }
}
