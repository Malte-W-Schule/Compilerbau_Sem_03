package Nodes;

// DoNode.java
import java.util.List;

public class DoNode extends ASTNode {
    //public final List<ASTNode> expressions; // Die Liste der sequenziellen Ausdrücke

    //public DoNode(List<ASTNode> expressions, int row, int column) {
    //    super(row, column);
    //    this.expressions = expressions;
    //}
    public DoNode( int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() {
        //return "DO(" + expressions + ")";
        return "DO( )";
    }
}
