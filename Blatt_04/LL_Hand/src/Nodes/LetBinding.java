package Nodes;

// LetBinding.java (Kann auch als innere Klasse in LetNode definiert werden)
public class LetBinding {
    public final String name;
    public final ASTNode value;

    public LetBinding(String name, ASTNode value) {
        this.name = name;
        this.value = value;

    }

    @Override
    public String toString() {
        return String.format("[%s = %s]", name, value);
    }
}
