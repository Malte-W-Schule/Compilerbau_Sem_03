package org.example;

import java.util.List;

public record Fun(FDeclNode fDeclNode, Environment closure) {
    public Fun bind(Instance i) {
        Environment e = new Environment(this.closure);
        return new Fun(this.fDeclNode, e);
    }
}


