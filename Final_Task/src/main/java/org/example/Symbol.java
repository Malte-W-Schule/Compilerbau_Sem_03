package org.example;

public class Symbol {

    private String name;
    private Type type;
    private ASTNode connectedNode;
    private Scope scope;
    private boolean and;

    public Symbol(String name, Type type, ASTNode querverbindendeNode,Scope scope, boolean and) {
        this.name = name;
        this.type = type;
        this.connectedNode = querverbindendeNode;
        this.scope = scope;
        this.and = and;
    }

    //getter
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public ASTNode getConnectedNode() {
        return connectedNode;
    }

    public Scope getScope() {
        return scope;
    }
}
