package Nodes;

// LetNode.java
import java.util.List;

public class LetNode extends ASTNode {
    public final List<LetBinding> bindings; // Liste der lokalen Variablen
    public final ASTNode body;             // Der Ausdruck, in dem die Variablen gültig sind

    public LetNode(List<LetBinding> bindings, ASTNode body, int row, int column) {
        super(row, column);
        this.bindings = bindings;
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("LET(Bindings: %s, Body: %s)", bindings, body);
    }
}
