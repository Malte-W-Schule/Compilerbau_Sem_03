import java.util.List;

public class Resolver {

    public Scope currentScope;

    public Resolver() {
        // Globaler Scope (Eltern-Scope ist null)
        currentScope = new Scope(null);
    }

    public void resolve(ProgramNode node) {
        for (ASTNode n : node.getNodes()) {
            if (n instanceof Statement) {
                resolve((Statement) n);
            } else if (n instanceof Expression) {
                resolve((Expression) n);
            }
        }
    }

    // Statements geben keinen Typ zurück (void)
    public void resolve(Statement statement) {
        switch (statement) {
            case DefNode def   -> visitDef(def);
            case DefnNode defn -> visitDefn(defn);
            default -> throw new RuntimeException("Unknown Statement: " + statement.getClass());
        }
    }

    // Expressions MÜSSEN einen PrimType zurückgeben
    public PrimType resolve(Expression expression) {
        return switch (expression) {
            case IntegerNode i  -> PrimType.INT;
            case StringNode s   -> PrimType.STRING;
            case BooleanNode b  -> PrimType.BOOL;
            case VariableNode v -> visitVariable(v);
            case LetNode let    -> visitLet(let);
            case ListNode list  -> visitList(list); // Funktionsaufrufe
            // Falls du IfNode implementierst, muss es den Typ der Zweige zurückgeben
            case IfNode ifNode  -> visitIf(ifNode);
            // DoNode gibt den Typ des letzten Elements zurück
            case DoNode doNode  -> visitDo(doNode);
            default -> PrimType.UNKNOWN;
        };
    }

    // --- Statement Handler ---

    private void visitDef(DefNode def) {
        // 1. Wir müssen wissen, welchen Typ der Wert hat
        // (Hier rufen wir resolve rekursiv auf)
        PrimType valueType = resolve(def.getValue());

        // 2. Symbol erstellen
        Symbol s = new Symbol(def.getName(), valueType, def, currentScope);

        // 3. Im aktuellen Scope speichern
        if (!currentScope.bind(s)) {
            throw new RuntimeException("Variable '" + def.getName() + "' ist bereits definiert!");
        }
    }

    private void visitDefn(DefnNode defn) {
        // 1. Funktionsnamen im AKTUELLEN (äußeren) Scope registrieren
        // Wir nehmen hier VOID oder UNKNOWN an, da wir den Body noch nicht ausgewertet haben.
        // Oder man wertet erst den Body aus (komplexer bei Rekursion).
        Symbol funcSymbol = new Symbol(defn.getName(), PrimType.VOID, defn, currentScope);
        currentScope.bind(funcSymbol);

        // 2. Neuen Scope für die Funktion öffnen
        Scope functionScope = new Scope(currentScope);
        this.currentScope = functionScope; // Scope wechseln

        try {
            // 3. Parameter im neuen Scope binden (als lokale Variablen)
            // Wir wissen den Typ der Parameter oft nicht in dynamischen Sprachen,
            // daher nehmen wir hier UNKNOWN oder INT an (je nach Sprachdesign).
            for (String paramName : defn.getParameters()) {
                // Parameter haben keine "Expression", daher connectedNode = null oder defn
                Symbol paramSymbol = new Symbol(paramName, PrimType.UNKNOWN, null, currentScope);
                currentScope.bind(paramSymbol);
            }

            // 4. Body im Funktions-Scope resolven
            resolve(defn.getBody());

        } finally {
            // 5. Scope wieder verlassen (Wichtig!)
            this.currentScope = currentScope.parent;
        }
    }

    // --- Expression Handler ---

    private PrimType visitVariable(VariableNode v) {
        Symbol s = currentScope.resolve(v.getName());
        if (s == null) {
            throw new RuntimeException("Variable '" + v.getName() + "' nicht gefunden!");
        }
        return s.getType();
    }

    private PrimType visitLet(LetNode let) {
        // Let braucht einen eigenen Scope
        Scope letScope = new Scope(currentScope);
        this.currentScope = letScope;

        try {
            // Bindings verarbeiten
            for (int i = 0; i < let.getNames().size(); i++) {
                String name = let.getNames().get(i);
                Expression expr = let.getValues().get(i);

                PrimType type = resolve(expr); // Typ der Zuweisung ermitteln
                Symbol s = new Symbol(name, type, expr, currentScope);
                currentScope.bind(s);
            }

            // Body ausführen und dessen Typ zurückgeben
            return resolve(let.getBody());

        } finally {
            this.currentScope = currentScope.parent;
        }
    }

    private PrimType visitIf(IfNode ifNode) {
        // Bedingung prüfen (sollte BOOL sein)
        PrimType condType = resolve(ifNode.getCondition());
        if (condType != PrimType.BOOL && condType != PrimType.UNKNOWN) {
            System.out.println("Warnung: If-Bedingung ist kein Boolean");
        }

        PrimType thenType = resolve(ifNode.getThenBranch());
        if (ifNode.getElseBranch() != null) {
            PrimType elseType = resolve(ifNode.getElseBranch());
            // Hier könnte man prüfen, ob thenType == elseType ist
            return thenType;
        }
        return thenType;
    }

    private PrimType visitDo(DoNode doNode) {
        PrimType lastType = PrimType.VOID;
        for (ASTNode n : doNode.getNodes()) {
            if (n instanceof Statement) resolve((Statement)n);
            if (n instanceof Expression) lastType = resolve((Expression)n);
        }
        return lastType;
    }

    private PrimType visitList(ListNode list) {
        // Das ist ein Funktionsaufruf, z.B. (add 1 2)
        // 1. Operator prüfen (ist es eine Funktion?)
        PrimType opType = resolve(list.getOperator());

        // 2. Argumente resolven
        for (Expression arg : list.getArguments()) {
            resolve(arg);
        }

        // Wenn wir wissen, was die Funktion zurückgibt, geben wir das hier zurück.
        // Fürs erste nehmen wir an, Berechnungen ergeben INT.
        return PrimType.INT; // Vereinfacht!
    }
}