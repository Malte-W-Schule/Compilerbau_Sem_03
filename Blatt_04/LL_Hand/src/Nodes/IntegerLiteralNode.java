package Nodes;

public class IntegerLiteralNode extends LiteralNode {
    public final int value;
    public IntegerLiteralNode(int value,int row, int column) {
        super(row, column);
        this.value = value;
    }
    // Innerhalb der Klasse IntegerLiteralNode
    @Override
    public String toString() {
        return "INT(" + value + ") [Row: " + getRow() + ", Col: " + getColumn() + "]";
    }
}
