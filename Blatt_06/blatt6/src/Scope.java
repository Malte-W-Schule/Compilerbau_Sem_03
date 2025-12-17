import java.util.HashMap;
import java.util.Map;

public class Scope {

    public Map<String,Symbol> symbolMap = new HashMap<>();
    public Scope parent;

    public Scope(Scope parent) {
        this.parent = parent;
    }

    //suchen
    public Symbol resolve(String name) {
        Symbol s = symbolMap.get(name);
        if (s != null) return s;
        if (parent != null) return parent.resolve(name);
        return null;
    }

    //zuwesien
    public boolean bind(Symbol symbol) {
        if (symbolMap.containsKey(symbol.getName())) {
            System.out.println("Error: Symbol '" + symbol.getName() + "' schon definiert");
            return false;
        }
        symbolMap.put(symbol.getName(), symbol);
        return true;
    }//bind




}
