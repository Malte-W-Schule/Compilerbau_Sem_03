import java.util.List;

public class UserDefinedFunction implements LispFunction {
    private final DefnNode declaration;
    private final Environment closure; // Das Environment bei der ERSTELLUNG

    public UserDefinedFunction(DefnNode declaration, Environment closure) {
        this.declaration = declaration;
        this.closure = closure;
    }

    @Override
    public Object apply(List<Object> args) {
        // 1. Einen neuen Scope erstellen für den Funktionsaufruf
        Environment funcEnv = new Environment(closure);

        // 2. Die übergebenen Werte (args) an die Parameternamen binden
        // args: [1, 2]
        // params: ["a", "b"]
        // -> a=1, b=2 im funcEnv speichern
        for (int i = 0; i < declaration.getParameters().size(); i++) {
            funcEnv.define(declaration.getParameters().get(i), args.get(i));
        }

        // 3. Den Body der Funktion ausführen!
        // Hier brauchen wir eine Instanz des Interpreters, um evaluate aufzurufen.
        // (Entweder Interpreter durchreichen oder statisch/singleton lösen)
        Interpreter interpreter = new Interpreter();
        return interpreter.evaluate(declaration.getBody(), funcEnv);
    }
}
