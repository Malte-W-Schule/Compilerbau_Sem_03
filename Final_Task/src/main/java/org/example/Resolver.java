package org.example;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resolver {

    private Binder binder;

    private Scope currentScope;
    private Map<ASTNode, Scope> nodeScope = new HashMap<>();

    public Resolver(Binder binder) {
        // Globaler Scope (Eltern-Scope ist null)
        currentScope = new Scope(null);
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
                System.out.println("Was Zum Kuckuck ist: " + node.toString());
                throw new RuntimeException("kein Statement oder Expression");
            }
        }

        {
            System.out.println("Was Zum Kuckuck ist: " + node.toString());
            throw new RuntimeException("kein Statement oder Expression");
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
            //case MCall m -> visitMCallStmt(m);
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
        this.currentScope = nodeScope.get(c);
        resolve(c.block());
        this.currentScope = currentScope.getParent();
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
        this.currentScope = nodeScope.get(c);
        resolve(c.block());
        this.currentScope = currentScope.getParent();
    }

    private void visitCDeclHelper(CDeclNode c) {
        resolve(c.block());
    }

    //===================== aktiv resolven ================
    // == visit Statements ==
    private void visitInit(InitNode initNode) {
        //String idName = initNode.id().name();
        //currentScope.resolve(idName); //todo id nicht resolven, da diese binded wurden?
        //Scope scope = nodeScope.get(initNode);
        currentScope.resolve(resolve(initNode.value()).toString()); //todo tostring?
    }

    //Der d;
    //d.x=5;
    private void visitAssi(AssiNode assiNode) {//record AssiNode(IDNode id, Expression value) implements Statement, ASTNode{}
        Symbol lhs;
        if (assiNode.objectId()!= null && assiNode.objectId().name()!= null) {
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

        System.out.println(currentScope.toString());
        //Symbol rhs = currentScope.resolve(resolve(assiNode.value()).toString());
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
    private void checkParameter(ParamNodeDecl paramDecl, ParamCallNode paramCall) {
        if (paramDecl.params().size() != paramCall.params().size()) {
            throw new RuntimeException("Anzahl Parameter bei Übergabe stimmt nicht mit deklarierten überein");
        }

        for (int i = 0; i < paramCall.params().size(); i++) {
            Type typeDecl = paramDecl.params().get(i).type();
            Type typeCall = resolve(paramCall.params().get(i));
            if (typeDecl.getClass() != typeCall.getClass()) {
                throw new RuntimeException("Typen der Paramter stimmen nicht überein");
            }
        }
    }

    private Type checkReturn(FBlockNode fBlock, Symbol fSymbol) {
        Type retType = resolve(fBlock.ret().value());
        if (retType == null) {
            System.out.println("return type null in: " + fBlock.toString());
        }

        if (retType instanceof VoidType) {
            Type func = fSymbol.getType();
            if (func.equals(retType)) {
                throw new RuntimeException("Typen der Funktion und des Rückgabewertes stimmen nicht überein");
            }
        }
        return retType;
    }

    private void visitBlock(Block b) {
        System.out.print("Fehler Block");
    }

    private Type visitFCall(FCallNode f) {
        Scope tempScope = this.currentScope;
        Symbol fDecl = currentScope.resolve(f.id().name());
        Scope fBlockScope = fDecl.getScope();
        this.currentScope = fBlockScope;

        FDeclNode fDeclNode = (FDeclNode) fDecl.getConnectedNode();

        ParamNodeDecl paramDecl = (ParamNodeDecl) fDeclNode.params();
        ParamCallNode paramCall = f.params();
        //prüft Anzahl und Typen der Parameter
        checkParameter(paramDecl, paramCall);

        //return typ vergleichen, wenn einer existiert, der return steht im Block
        FBlockNode fBlock = (FBlockNode) fDeclNode.block();

        this.currentScope = tempScope;

        return checkReturn(fBlock, fDecl);
    }


    private void visitConCall(ConCallNode c) {

        Scope tempScope = this.currentScope;
        Symbol cDecl = currentScope.resolve(c.name().name());
        Scope cBlockScope = cDecl.getScope();
        this.currentScope = cBlockScope;

        ConDeclNode cDeclNode = (ConDeclNode) cDecl.getConnectedNode();

        ParamNodeDecl paramDecl = (ParamNodeDecl) cDeclNode.params();
        ParamCallNode paramCall = c.params();
        //prüft Anzahl und Typen der Parameter
        checkParameter(paramDecl, paramCall);

        this.currentScope = tempScope;
    }
    /*
    private void visitMCallStmt(MCall m) {//todo inherit scope
        //Klasse ist im globalen Scope, sollte so gehen
        currentScope.resolve(m.clars().name());
        //Funktionsname ist nicht im globalen Scope, sondern Klassen Scope
        currentScope.resolve(m.fName().name());
        for (Expression e : m.params().params()) {
            resolve(e);
        }
    }*/

    private Type visitMCall(MCall m) {

        Symbol classSymbol = currentScope.resolve(m.clars().name()); // todo ist clars cdeclnode?
        this.currentScope = classSymbol.getScope();

        // Symbol von function getten um paras über fdecl node zu holen
        Symbol fSymbol = currentScope.resolve(m.fName().name());

        // function declare node für paramsdecl getten
        FDeclNode fDeclNode = (FDeclNode) fSymbol.getConnectedNode();

        // params nodes getten für decl und call
        ParamNodeDecl paramNodeDecl = fDeclNode.params();
        ParamCallNode paramCallNode = m.params();

        // params vergleichen
        checkParameter(paramNodeDecl, paramCallNode);

        FBlockNode fBlock = (FBlockNode) fDeclNode.block();

        this.currentScope = currentScope.getParent();

        return checkReturn(fBlock, fSymbol);
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

        if (b.ret() != null) //todo gucken wo resolve void returned und wie?
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

    private Type visitArithmetischeExpressionNode(ArithmetischeExpressionNode e) { //todo expression? oder statement, was mit scopes
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

