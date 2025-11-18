package Nodes;

// Nodes.ASTNode.java
public abstract class ASTNode {
    // Speichert optional die Position im Quellcode für Fehlerberichte
    private final int row;
    private final int column;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public ASTNode(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Visitor-Pattern-Methode (optional, aber empfohlen für Compiler-Phasen)
    // public abstract void accept(ASTVisitor visitor); 
}