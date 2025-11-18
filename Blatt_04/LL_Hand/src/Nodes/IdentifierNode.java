package Nodes;

// IdentifierNode.java
public class IdentifierNode extends ASTNode {
    public final String name;
    public IdentifierNode(String name, int row, int column) {
        super(row, column);
        this.name = name;

        System.out.println(name+" at row "+row+" column "+column);
    }
}
