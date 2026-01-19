package org.example;

public class Attribute {
    private Type type;
    private Object defaultValue;

    public Type getType() {
        return type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public Attribute(Type type, Object defaultValue) {
        this.type = type;
        this.defaultValue = defaultValue;
    }
}
