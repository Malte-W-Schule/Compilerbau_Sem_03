package org.example;

import java.util.List;
import java.util.Map;

public class ClazzInterpreter {
    Map<String, Fun> methods;

    public ClazzInterpreter(Map<String, Fun> methods) {
        this.methods = methods;
    }

    public Instance call(Interpreter i, List<Object> a) {
        return new Instance(this);
    }

    public Fun findMethod(String name) {
        return this.methods.get(name);
    }
}
