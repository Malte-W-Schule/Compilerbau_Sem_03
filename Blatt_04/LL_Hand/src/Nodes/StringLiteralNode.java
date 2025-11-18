package Nodes;

public class StringLiteralNode extends LiteralNode {
    public final String value;

    public StringLiteralNode(String value,int row, int column) {
        super(row, column);
        this.value = value;
    }
}
