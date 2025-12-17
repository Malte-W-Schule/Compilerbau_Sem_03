import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    private Map<String, Object> values = new HashMap<>();
    private Environment parent; // Für spätere Scopes (optional für den Anfang)


    //todo value
    public Environment(Environment parent) {
        // Hier registrieren wir die NATIVEN Funktionen
        this.parent = parent;
        if( parent == null ) {
            defineNativeFunctions();
        }
    }

    public void define(String name, Object value) {
        if( values.containsKey(name)) {
            throw new RuntimeException( "Duplicate name " + name );
        }
        else{
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
    private void defineNativeFunctions() {
      /**  define("+", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                // Hilfsmethode nutzen, um Abstürze bei Integern zu verhindern
                double left = toDouble(args.get(0));
                double right = toDouble(args.get(1));
                return left + right;
            }
        });

        define("-", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                double left = toDouble(args.get(0));
                double right = toDouble(args.get(1));
                return left - right;
            }
        });

        define("*", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                double left = toDouble(args.get(0));
                double right = toDouble(args.get(1));
                return left * right;
            }
        });

        define("/", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                double left = toDouble(args.get(0));
                double right = toDouble(args.get(1));
                return left / right;
            }
        });

       */
        define("print", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                // Wir iterieren über die Argumente und drucken sie
                for (Object arg : args) {
                    System.out.print(arg + " ");
                }
                // Neue Zeile am Ende
                System.out.println();
                return null;
            }
        });

        define("list", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                return args;
            }
        });

        define("nth", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                // 1. Das erste Argument muss eine Liste sein
                if (!(args.get(0) instanceof List)) {
                    throw new RuntimeException("Erstes Argument für 'nth' muss eine Liste sein.");
                }
                List<?> list = (List<?>) args.get(0);

                // 2. Das zweite Argument ist der Index (als Number -> int casten)
                Object indexObj = args.get(1);
                int index;
                if (indexObj instanceof Number) {
                    index = ((Number) indexObj).intValue();
                } else {
                    throw new RuntimeException("Index muss eine Zahl sein.");
                }

                // 3. Zugriff (Java wirft automatisch IndexOutOfBoundsException, wenn zu hoch/niedrig)
                return list.get(index);
            }
        });

        define("tail", new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                if (!(args.get(0) instanceof List)) {
                    throw new RuntimeException("Erstes Argument für 'tail' muss eine Liste sein.");
                }
                List<?> list = (List<?>) args.get(0);
                if (list.isEmpty()) {
                    return new ArrayList<>(); // Leere Liste bleibt leer
                }
                // subList(1, size) erstellt eine Sicht ab Index 1 bis zum Ende
                return new ArrayList<>(list.subList(1, list.size()));
            }
        });

        define("head",new LispFunction() {
            @Override
            public Object apply(List<Object> args) {
                if (!(args.get(0) instanceof List)) {
                    throw new RuntimeException("Erstes Argument für 'head' muss eine Liste sein.");
                }
                else{
                    List<Object> list = (List<Object>) args.get(0);
                    return list.get(0);
                }
            }
        });

    }

    // WICHTIG: Hilfsmethode für Zahlenkonvertierung
    // Verhindert ClassCastException, wenn ein IntegerNode übergeben wird
    private double toDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        throw new RuntimeException("Erwartete eine Zahl, erhielt: " + obj);
    }
}