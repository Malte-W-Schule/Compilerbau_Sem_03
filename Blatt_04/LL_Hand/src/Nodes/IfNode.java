package Nodes;

// IfNode.java
public class IfNode extends ASTNode {
    public final ASTNode condition;
    public final ASTNode thenBranch;
    public final ASTNode elseBranch; // Kann null sein

    public IfNode(ASTNode cond, ASTNode thenB, ASTNode elseB, int row, int column) {
        super(row, column);
        this.condition = cond;
        this.thenBranch = thenB;
        this.elseBranch = elseB;

        System.out.println("cond "+cond+ "then: "+ "else: " +" at row "+row+" column "+column);
    }
}
