package org.example;

public class Resolver {

    private Scope currentScope;

    public Resolver() {
        // Globaler Scope (Eltern-Scope ist null)
        currentScope = new Scope(null);
    }

    public void resolve(ProgramNode node) {
        for (ASTNode n : node.statements()) {
            if (n instanceof Statement) {
                resolve((Statement) n);
            } else if (n instanceof Expression) {
                resolve((Expression) n);
            } else {
                System.out.println("Was Zum Kukuk ist: " + node.toString());
                throw new RuntimeException("kein Statement oder Expression");
            }
        }
    }

    // Statements geben keinen Typ zurück (void)
    public void resolve(Statement statement) {
        //hier schreiben:
        //ParamNode
        switch (statement) {
            case InitNode i -> visitInit(i);
           case DeclNode d -> visitDecl(d);
            case AssiNode a -> visitAssi(a);

            case BlockNode()
                ;
            case IfNode()
                ;
            case WhileNode()
                ;
            case FDeclNode()
                ;
            case FCallNode()
                ;
            case CDeclNode()
                ;
            case ConDeclNode()
                ;
            case ConCallNode()
                ;
            case MCall()
                ;
        }
    }

    // Expressions MÜSSEN einen PrimType zurückgeben
    public Type resolve(Expression expression) {

        return switch (expression) {
            case IntegerNode i -> new IntType();
            case StringNode s -> new StringType();
            case BoolNode b -> new BoolType();
            case CharNode c -> new CharType();
            case ExprNode e -> visitExpression(e);

            default -> throw new IllegalStateException("Unexpected value: " + expression);
        };
    }

    private Type visitExpression(ExprNode e) { //todo expression? oder statement, was mit scopes
        // left right getten
        //compare with op
        Type left = resolve(e.left());
        Type right = resolve(e.right());
        String operator = e.operator();
        Type type = null;
        if (left != right) {
            System.out.println("Types of Expressions arent the same, Left: " + left + " Right: " + right);
            return null;
        } else {
            type = left;
        }
        // todo nachdenken scopes nutzen=?

        if (operator.equals("+") ||
                operator.equals("-") ||
                operator.equals("*") ||
                operator.equals("/") ||
                operator.equals("%")) {
            opArithmetik(type, operator); //todo return?
        } else if (operator.equals("==") ||
                operator.equals("!=")) {
            opEqual(type, operator);
        } else if (operator.equals("<") ||
                operator.equals("<=") ||
                operator.equals(">") ||
                operator.equals(">=")) {
            opCompare(type, operator);
        }
        return type;
    }

    private Type opCompare(Type type, String operator) {
        if (type instanceof IntType ||
                type instanceof CharType) {
            return type;
        } else {
            System.out.println("compares like :" + operator + " only allowed between int or char");
            throw new RuntimeException();
        }
    }

    private Type opEqual(Type type, String operator) {
        if (type instanceof StringType ||
                type instanceof BoolType ||
                type instanceof IntType ||
                type instanceof CharType) {
            return type;
        } else {
            System.out.println("Its only allowed to compare string, bool, int or chars with each other");
            throw new RuntimeException();
        }
    }

    private Type opArithmetik(Type type, String operator) {
        if (type instanceof IntType) {
            // valid todo implement return scope
            return type;
        } else {
            System.out.println("Arithmetik only allowed between IntTypes, got: " + type);
            throw new RuntimeException();
        }
    }

    // == visit Statements ==
    private void visitInit(InitNode initNode) {
        Symbol s = new Symbol(initNode.id().name(),
                initNode.type(),
                initNode,
                currentScope,
                initNode.and());
        currentScope.bind(s);
    }


    private void visitDecl(DeclNode declNode) {
        Symbol s = new Symbol(declNode.id().name(),
                declNode.type(),
                declNode,
                currentScope,
                declNode.and());
        currentScope.bind(s);
    }

    private void visitAssi(AssiNode assiNode)
    {//record AssiNode(IDNode id, Expression value) implements Statement, ASTNode{}
        //symbol (String name, Type type,ASTNode querverbindendeNode,Scope scope, boolean and) {
      /*  Symbol s = new Symbol(assiNode.id().name(),
                resolve(assiNode.value()),
                assiNode,
                currentScope,
                false
                );*///todo interpreter in resolver?
        currentScope.resolve(assiNode.id().name());
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


}
