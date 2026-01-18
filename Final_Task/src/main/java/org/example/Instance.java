package org.example;

public class Instance {
    ClazzInterpreter clazz;

    public Instance(ClazzInterpreter clazz) {
        this.clazz = clazz;
    }

    public Fun get(String name) {
        Fun method = this.clazz.findMethod(name);
        if (method != null) {
            return method.bind(this);
        }
        throw new RuntimeException("undefined Method!");
    }
}
