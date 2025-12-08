public class Symbol {

    public String name;
    public PrimType type;
    public ASTNode connectedNode;
    public Scope scope;

    public Symbol(String name, PrimType type,ASTNode querverbindendeNode,Scope scope) {
        this.name = name;
        this.type = type;
        this.connectedNode = querverbindendeNode;
        this.scope = scope;
    }
    //getter
    public String getName() {
        return name;
    }

    public PrimType getType() {
        return type;
    }

    public ASTNode getConnectedNode() {
        return connectedNode;
    }

    public Scope getScope() {
        return scope;
    }
}
