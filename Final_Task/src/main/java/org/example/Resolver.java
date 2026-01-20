package org.example;

import java.io.FileDescriptor;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resolver {

    private Binder binder;
    private ArrayList<String> klassen = new ArrayList<>();

    private Scope currentScope;
    private Map<ASTNode, Scope> nodeScope = new HashMap<>();

    public Resolver(Binder binder) {
        // Globaler Scope (Eltern-Scope ist null)
        currentScope = binder.getCurrentScope();
        this.binder = binder;
        this.nodeScope = binder.getNodeScope();
    }

    public void resolve(ProgramNode node) {
        for (ASTNode n : node.statements()) {
            if (n instanceof Statement) {
                resolve((Statement) n);
            } else if (n instanceof Expression) {
                resolve((Expression) n);
            } else {
                System.out.println("Was Zum Kuckuck ist: " + n.toString());
                throw new RuntimeException("kein Statement oder Expression");
            }
        }
    }

    // Statements geben keinen Typ zurück (void)
    public void resolve(Statement statement) {

        switch (statement) {
            case InitNode i -> visitInit(i);
            case DeclNode d -> visitDecl(d);
            case AssiNode a -> visitAssi(a);
            case BlockNode b -> visitBlock(b);
            case FBlockNode b -> visitFBlock(b);
            case CBlockNode b -> visitCBlock(b);
            case IfNode i -> visitIf(i);
            case WhileNode w -> visitWhile(w);
            case FDeclNode f -> visitFDecl(f);
            case FCallNode f -> visitFCall(f);
            case CDeclNode c -> visitCDecl(c);
            case ConDeclNode c -> visitConDecl(c);
            case ConCallNode c -> visitConCall(c);
            case MCall m -> visitMCallStmt(m);
            case Block b -> visitBlock(b);
            default ->
                    throw new IllegalArgumentException("Unbekannter Knotentyp: " + statement.getClass().getSimpleName());
        }
    }

    // Expressions MÜSSEN einen PrimType zurückgeben
    public Type resolve(Expression expression) {

        return switch (expression) {
            case IntegerNode i -> new IntType();
            case StringNode s -> new StringType();
            case BoolNode b -> new BoolType();
            case CharNode c -> new CharType();
            case MCall m -> visitMCall(m);
            case FCallNode f -> visitFCall(f);
            case LogischeExpressionNode e -> visitLogischeExpressionNode(e);
            case ArithmetischeExpressionNode e -> visitArithmetischeExpressionNode(e);
            case IDNode id -> visitID(id);
            default -> throw new IllegalStateException("Unexpected value: " + expression);
        };
    }

    public Type visitID(IDNode id) {
        Symbol s = currentScope.resolve(id.name());
        if (s != null) {
            return s.getType();

        } //todo bedenken
        return new VoidType();
    }

    //================== Deklarationen ============================
    public void visitConDecl(ConDeclNode c) {
        Scope oldScope = this.currentScope;
        this.currentScope = nodeScope.get(c);
        resolve(c.block());
        this.currentScope = oldScope;
    }

    private void visitDecl(DeclNode declNode) {
        this.currentScope.resolve(declNode.id().name());
    }

    public void visitFDecl(FDeclNode f) {
        this.currentScope = nodeScope.get(f);
        resolve(f.block());
        this.currentScope = currentScope.getParent();
    }

    public void visitCDecl(CDeclNode c) {
        klassen.add(c.name().name());
        Scope oldScope = this.currentScope;
        this.currentScope = nodeScope.get(c);
        resolve(c.block());
        this.currentScope = oldScope;
    }

    private void visitCDeclHelper(CDeclNode c) {
        resolve(c.block());
    }

    //===================== aktiv resolven ================
    // == visit Statements ==
    //todo zeige polymorphie ansatz
    private void visitInit(InitNode initNode) {

        //Grad ncoh nicht Polymorphie fähig, da Superklasse a = Klasse b; nicht unterstütz wird.
        //Nur linke Declaration wird für Scope Suche genutzt
       if(initNode.type() instanceof KlassenType){
           Scope oldScope = this.currentScope;
           String klassenName = ((KlassenType) initNode.type()).name();
           Symbol klasse = currentScope.resolve(klassenName);
           Scope klassenScope = klasse.getScope();
           this.currentScope = klassenScope;
           currentScope.resolve(resolve(initNode.value()).toString());
           this.currentScope = oldScope;
           return;
       }

        currentScope.resolve(resolve(initNode.value()).toString()); //todo tostring?
    }

    private void visitAssi(AssiNode assiNode) {//record AssiNode(IDNode id, Expression value) implements Statement, ASTNode{}
        Symbol lhs;
        if (assiNode.objectId() != null && assiNode.objectId().name() != null) {
            // ist d definiert
            Scope temp = this.currentScope;
            currentScope.resolve(assiNode.objectId().name());
            // check if class is defined
            Symbol klassenSymbol = currentScope.resolve(assiNode.objectId().name());
            // um x zu resolven: wir brauchen Klassenscope des Objekts d.
            KlassenType klassenType = (KlassenType) klassenSymbol.getType();
            String klassenName = klassenType.name();
            Symbol klasse = currentScope.resolve(klassenName);
            Clazz klassenScope = (Clazz) klasse.getScope();
            this.currentScope = klassenScope;
            lhs = currentScope.resolve(assiNode.id().name());
            this.currentScope = temp;

        } else {

            lhs = currentScope.resolve(assiNode.id().name());
        }

        
        Expression rhs = assiNode.value();
        Type t = resolve(rhs);
        if (lhs.getType().getClass() != t.getClass()) {
            System.out.println("ohoh!!");
        }

        //objectid klassending aufruf klasse.id (object.id)
    }

    private void visitWhile(WhileNode w) {
        resolve(w.com());
        resolve(w.block()); //todo com in block scope?
    }

    //prüft Anzahl und Typen
    private void checkParameter(ParamNodeDecl paramDecl, ArrayList<Type> types) {
        if (paramDecl.params().size() != types.size()) {
            throw new RuntimeException("Anzahl Parameter bei Übergabe stimmt nicht mit deklarierten überein");
        }

        for (int i = 0; i < types.size(); i++) {
            Type typeDecl = paramDecl.params().get(i).type();
            Type typeCall = types.get(i);
            if (!typeDecl.equals(typeCall)) {
                throw new RuntimeException("Typen der Paramter stimmen nicht überein");
            }
        }
    }

    private Type checkReturn(FBlockNode fBlock, Symbol fSymbol) {
        Type retType = null;
        if (fBlock.ret() != null && fBlock.ret().value() != null) {
            retType = resolve(fBlock.ret().value());
            if (!(retType instanceof VoidType)) {
                Type func = fSymbol.getType();
                if (!func.equals(retType)) {
                    throw new RuntimeException("Typen der Funktion und des Rückgabewertes stimmen nicht überein");
                }
            }
        }

        return retType;
    }

    private void visitBlock(Block b) {
        System.out.print("Fehler Block");
    }

    private Type visitFCall(FCallNode f) {
        Scope tempScope = this.currentScope;

        //======nur wegen Überladung==========================================================
        //der muss den namen auch wiederherstellen
        String nameOhneParams = f.id().name();
        String nameMitParams = nameOhneParams;

        ParamCallNode paramCalls = f.params();
        for (Expression e : paramCalls.params()) {
            Type param = (resolve(e));
            nameMitParams = nameMitParams + "_" + param.toString(); //todo parameterlösung zeigen print_int1_int2
        }
        //=====================================================================

        Symbol fDecl = this.currentScope.resolve(nameMitParams);

        //Hier erst übergebene Parameter im aktuellen Scope prüfen
        ParamCallNode paramCall = f.params();
        ArrayList<Type> passedParamtypes = new ArrayList<>();
        for (Expression e : paramCall.params()) {
            passedParamtypes.add(resolve(e));
        }

        if(fDecl.getConnectedNode() instanceof ConDeclNode){
            visitConDecl((ConDeclNode) fDecl.getConnectedNode());
            return new VoidType();
        }
        if(fDecl.getConnectedNode() instanceof CDeclNode){
            visitCDecl((CDeclNode) fDecl.getConnectedNode());
            return new VoidType();
        }

        //Prüfe ob call ein Constructor ist

        //Scope zu Funktionsaufruf ändern, um Zugriff auf die deklarierten Parameter zu ermöglichen
        Scope fBlockScope = fDecl.getScope();
        this.currentScope = fBlockScope;

        FDeclNode fDeclNode = (FDeclNode) fDecl.getConnectedNode();

        ParamNodeDecl paramDecl = fDeclNode.params();

        //prüft Anzahl und Typen der Parameter
        checkParameter(paramDecl, passedParamtypes);

        //return typ der aufgerufenen Funktion vergleichen, wenn einer existiert
        FBlockNode fBlock = (FBlockNode) fDeclNode.block();

        Type returnF = checkReturn(fBlock, fDecl);

        this.currentScope = tempScope;

        return returnF;
    }


    private void visitConCall(ConCallNode c) {

        Scope tempScope = this.currentScope;

        //======nur wegen Überladung==========================================================
        //der muss den namen auch wiederherstellen mit typen
        String nameOhneParams = c.name().name();
        String nameMitParams = nameOhneParams;

        ParamCallNode paramCalls = c.params();
        for (Expression e : paramCalls.params()) {
            Type param = (resolve(e));
            nameMitParams = nameMitParams + "_" + param.toString();
        }
        //=====================================================================


        Symbol cDecl = currentScope.resolve(nameMitParams);

        //Hier erst übergebene Parameter im aktuellen Scope prüfen
        ParamCallNode paramCall = c.params();
        ArrayList<Type> passedParamtypes = new ArrayList<>();
        for (Expression e : paramCall.params()) {
            passedParamtypes.add(resolve(e));
        }

        Scope cBlockScope = cDecl.getScope();
        this.currentScope = cBlockScope;

        ConDeclNode cDeclNode = (ConDeclNode) cDecl.getConnectedNode();
        ParamNodeDecl paramDecl = (ParamNodeDecl) cDeclNode.params();
        //ParamCallNode paramCall = c.params();
        //prüft Anzahl und Typen der Parameter
        checkParameter(paramDecl, passedParamtypes);

        this.currentScope = tempScope;
    }

    private void visitMCallStmt(MCall m) {
        //Klasse ist im globalen Scope, sollte so gehen
        currentScope.resolve(m.clars().name());
        //Funktionsname ist nicht im globalen Scope, sondern Klassen Scope
        currentScope.resolve(m.fName().name());
        for (Expression e : m.params().params()) {
            resolve(e);
        }
    }

    //todo zeige objekt auflösung
    private Type visitMCall(MCall m) {

        Scope temp = this.currentScope;
        ParamCallNode paramCall = m.params();
        ArrayList<Type> passedParamtypes = new ArrayList<>();
        for (Expression e : paramCall.params()) {
            passedParamtypes.add(resolve(e));
        }
        //clars irreführend; wir bekommen das Symbol des definierten Objekts, zB Der d; d.x=4; Symbol==d
        Symbol object = currentScope.resolve(m.clars().name());
        //hole das Klassensymbol über den Typ des Objekts
        KlassenType kl = (KlassenType) object.getType();
        String klassenname = kl.name();

        Symbol klassenSymbol = currentScope.resolve(klassenname);
        this.currentScope = klassenSymbol.getScope();

        //======nur wegen Überladung==========================================================
        //der muss den namen auch wiederherstellen
        String nameOhneParams = m.fName().name();
        String nameMitParams = nameOhneParams;

        ParamCallNode paramCalls = m.params();
        for (Expression e : paramCalls.params()) {
            Type param = (resolve(e));
            nameMitParams = nameMitParams + "_" + param.toString();
        }
        //=====================================================================


        // Symbol von function getten um paras über fdecl node zu holen
        Symbol fSymbol = currentScope.resolve(nameMitParams);

        // function declare node für paramsdecl getten
        FDeclNode fDeclNode = (FDeclNode) fSymbol.getConnectedNode();

        // params nodes getten für decl und call
        ParamNodeDecl paramNodeDecl = fDeclNode.params();
        //ParamCallNode paramCallNode = m.params();

        // params vergleichen
        checkParameter(paramNodeDecl, passedParamtypes);

        FBlockNode fBlock = (FBlockNode) fDeclNode.block();
        Type t = checkReturn(fBlock, fSymbol);
        this.currentScope = temp;

        return t;
    }


    private void visitIf(IfNode i) {
        resolve(i.com());
        resolve(i.thenBlock());
        if (i.elseBlock() != null) {
            resolve(i.elseBlock());
        }
    }

    private void visitBlock(BlockNode b) {
        this.currentScope = nodeScope.get(b);
        for (Statement s : b.body()) {
            resolve(s);
        }
        this.currentScope = currentScope.getParent();
    }

    private void visitFBlock(FBlockNode b) {
        for (Statement s : b.body()) {
            resolve(s);
        }

        if (b.ret() != null)
        {
            resolve(b.ret().value());
        }
    }

    private void visitCBlock(CBlockNode b) {
        for (Statement s : b.body()) {
            resolve(s);
        }
    }

    private Type visitFCallExpr(FCallNode f) {
        Symbol s = currentScope.resolve(f.id().name());
        return s.getType();
    }

    private Type visitLogischeExpressionNode(LogischeExpressionNode l) {
        Type left = resolve(l.left());
        Type right = resolve(l.right());
        String operator = l.operator();
        Type type = null;
        if (!left.getClass().equals(right.getClass())) {
            System.out.println("Type mismatch! Left: " + left.getClass().getSimpleName() +
                    " Right: " + right.getClass().getSimpleName());
            return null;
        } else {
            type = left;
        }
        if (operator.equals("==") ||
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
    //todo zeige typprüfung
    private Type visitArithmetischeExpressionNode(ArithmetischeExpressionNode e) {
        Type left = resolve(e.left());
        Type right = resolve(e.right());
        String operator = e.operator();
        Type type = null;
        if (!left.getClass().equals(right.getClass())) {
            System.out.println("Type mismatch in arithmetic! Left: " + left + " Right: " + right);
            return null;
        } else {
            type = left;
        }
        if (operator.equals("+") ||
                operator.equals("-") ||
                operator.equals("*") ||
                operator.equals("/") ||
                operator.equals("%")) {
            opArithmetik(type, operator);
        }
        return type;
    }

    private Type opCompare(Type type, String operator) {
        if (type instanceof IntType ||
                type instanceof CharType) {
            return new BoolType();
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
            return new BoolType();
        } else {
            System.out.println("Its only allowed to compare string, bool, int or chars with each other");
            throw new RuntimeException();
        }
    }

    private Type opArithmetik(Type type, String operator) {
        if (type instanceof IntType) {
            return type;
        } else {
            System.out.println("Arithmetik only allowed between IntTypes, got: " + type);
            throw new RuntimeException();
        }
    }

}

