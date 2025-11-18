package Nodes;

public class BooleanLiteralNode extends LiteralNode {
    public final boolean value;
    public BooleanLiteralNode(boolean value, int row, int column) {
        super(row, column);
        this.value = value;
        System.out.println(value+" at row "+row+" column "+column);
    }
}
