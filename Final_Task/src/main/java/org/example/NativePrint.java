package org.example;

import java.util.List;

public class NativePrint extends Fun {

    public NativePrint(FDeclNode fDeclNode, Environment closure) {
        super(fDeclNode, closure);
    }

    @Override
    public Object call(Environment env, List<Object> args) {
        System.out.println(args.get(0));
        return null;
    }
}
