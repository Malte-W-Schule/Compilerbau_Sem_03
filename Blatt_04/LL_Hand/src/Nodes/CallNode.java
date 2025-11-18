package Nodes;

import java.util.List;

public class CallNode extends ASTNode {

    public final String functionName;
    public final List<ASTNode> arguments;

    public CallNode(String name, List<ASTNode> args, int row, int column) {
        super(row, column);
        this.functionName = name;
        this.arguments = args;

        System.out.println(name+" with args: " + args + " at row: " +row +" column: "+ column);
    }
}
