package org.example;

import java.util.HashMap;
import java.util.Map;

public class Instance {
    ClazzInterpreter clazz;
    private Map<String, Object> attributes = new HashMap<>();

    public Instance(ClazzInterpreter clazz) {
        this.clazz = clazz;
        for (int i = 0; i < clazz.attributes.size(); i++) {
            Attribute attribute = (Attribute) clazz.attributes.values().toArray()[i];
            this.attributes.put(clazz.attributes.keySet().toArray()[i].toString(), attribute.getDefaultValue());
        }
    }

    public Fun getFunction(String name) {
        Fun method = this.clazz.findMethod(name);
        if (method != null) {
            return method.bind(this);
        }
        throw new RuntimeException("undefined Method!");
    }

    public Object getAttribute(String name) {
        System.out.println("Attribute: " + name); //todo entfernen
        if (attributes.containsKey(name)) {
            System.out.println("Attribute value: " + attributes.get(name));
            return attributes.get(name);
        }
        throw new RuntimeException("undefined Attribute!");
    }

    public void assignAttribute(String name, Object value){
        if (attributes.containsKey(name)) {
            attributes.put(name, value);
            return;
        }
        throw new RuntimeException("Undefined variable '" + name + "'");
    }

}
