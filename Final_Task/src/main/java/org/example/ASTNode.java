package org.example;

public abstract class ASTNode {
    public abstract String toSExpression();
    public abstract String prettyPrint(int indent);

    protected String getIndent(int level) {
        return "  ".repeat(level);
    }
}
