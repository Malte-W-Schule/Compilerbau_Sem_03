package org.example;

public class Clazz extends Scope{
    Clazz parentClazz;

    public Clazz(Scope parent) {
        super(parent);
        parentClazz = null;
    }

    public Clazz(Scope parent, Clazz z) {
        super(parent);
        this.parentClazz = z;
    }

    // class foo {
    //      x = 0;
    // }
    public Symbol resolve(String name)
    {
        if (isNameInMap(name)) {
            //return resolve(name);
            Symbol s = getSymbolMap(name);
            if (s != null) return s;
        }
        else if (parentClazz != null && parentClazz.isNameInMap(name)) {
            return parentClazz.resolve(name);
        }
        //todo für verschachtelte klassen:
        /*else:
                # ... or enclosing scope if base class
        if enclosingScope: return enclosingScope.resolve(name)
        verschachtelte Klasse machen wir erstmal nicht
         */
        return null;
    }

    public Symbol resolveMember(String name){
        if(getSymbolMap(name) != null)
        {
            return getSymbolMap(name);
        }
        else if(parentClazz != null)
        {
            return parentClazz.resolveMember(name);
        }
        return null;
    }
}

