package Nodes;

// DefnNode.java
import java.util.List;

public class DefnNode extends ASTNode {
    public final String name;
    public final List<String> parameters; // Namen der Parameter
    public final ASTNode body;            // Der Ausdruck, der den Funktionskörper bildet

    public DefnNode(String name, List<String> parameters, ASTNode body, int row, int column) {
        super(row, column);
        this.name = name;
        this.parameters = parameters;
        this.body = body;

        System.out.println("body: "+body+ " param: "+parameters+ " at row "+row+" column "+column);
    }

    @Override
    public String toString() {
        return String.format("DEFN(Name: %s, Params: %s, Body: %s)", name, parameters, body);
    }
}
