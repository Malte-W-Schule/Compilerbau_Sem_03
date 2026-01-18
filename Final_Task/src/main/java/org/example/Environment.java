package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    private Map<String, Object> values = new HashMap<>();
    private Environment parent; // Für spätere Scopes (optional für den Anfang)

    public Environment(Environment parent) {
        this.parent = parent;
        if (parent == null) {
            defineNativeFunctions();
        }
    }

    public void define(String name, Object value) {
        if (values.containsKey(name)) {
            throw new RuntimeException("Duplicate name " + name);
        } else {
            values.put(name, value);
        }
    }

    // Variablen nachschlagen
    public Object get(String name) {
        if (values.containsKey(name)) {
            return values.get(name);
        }
        if (parent != null) {
            return parent.get(name);
        }
        throw new RuntimeException("Undefined symbol: " + name);
    }

    public void assign(String name, Object value) {

        if (values.containsKey(name)) {
            values.put(name, value);
            return;
        }

        if (parent != null) {
            parent.assign(name, value);
            return;
        }

        throw new RuntimeException("Undefined variable '" + name + "'");
    }

    private void defineNativeFunctions() {
    }


    private double toDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        throw new RuntimeException("Erwartete eine Zahl, erhielt: " + obj);
    }
}