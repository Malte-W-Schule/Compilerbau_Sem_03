package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClazzInterpreter implements Callable {
    Map<String, Fun> methods;
    Map<String, Attribute> attributes;

    public ClazzInterpreter(Map<String, Fun> methods, Map<String, Attribute> attributes) {
        this.methods = methods;
        this.attributes = attributes;
    }

    @Override
    public Object call(Environment env, List<Object> args) {
        return new Instance(this);
    }

    public Fun findMethod(String name) {
        return this.methods.get(name);
    }
}
