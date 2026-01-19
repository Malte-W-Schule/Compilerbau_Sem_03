package org.example;

import java.util.List;

public class Fun implements Callable {
    private final FDeclNode fDeclNode;
    private final Environment closure;

    public Environment getClosure(){
        return this.closure;
    }

    public Fun(FDeclNode fDeclNode, Environment closure) {
        this.fDeclNode = fDeclNode;
        this.closure = closure;
    }

    @Override
    public Object call(Environment env, List<Object> args) {
        for (int i = 0; i < args.size(); i++) {
            env.define(this.fDeclNode.params().params().get(i).id().name(), args.get(i));
        }
        return null;
    }

    public Fun bind(Instance i) {
        Environment e = new Environment(this.closure);
        return new Fun(this.fDeclNode, e);
    }

    public FDeclNode getfdeclNode(){
        return fDeclNode;
    }
}


