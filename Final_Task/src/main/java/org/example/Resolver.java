package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resolver {

    private Scope currentScope;
    private Scope classScope;


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
                System.out.println("Was Zum Kuckuck ist: " + node.toString());
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


    public void visitConDecl(ConDeclNode c) {
        // Logik für Konstruktor-Deklarationen
        Symbol sym = new Symbol(c.name().name(), c.name(), c, currentScope, false);
        currentScope.bind(sym);
        this.currentScope = new Scope(currentScope);
        //Parameter binden
        for (SingleParamNode p : c.params().params()) {
            Symbol s = new Symbol(p.id().name(), p.type(), c, currentScope, p.and());
            currentScope.bind(s);
        }
        resolve(c.block());
        currentScope = currentScope.getParent();
    }

    // Expressions MÜSSEN einen PrimType zurückgeben
    public Type resolve(Expression expression) {

        return switch (expression) {
            case IntegerNode i -> new IntType();
            case StringNode s -> new StringType();
            case BoolNode b -> new BoolType();
            case CharNode c -> new CharType();
            case MCall m -> visitMCallExpr(m);
            case FCallNode f -> visitFCallExpr(f);
            case LogischeExpressionNode e -> visitLogischeExpressionNode(e);
            case ArithmetischeExpressionNode e -> visitArithmetischeExpressionNode(e);

            default -> throw new IllegalStateException("Unexpected value: " + expression);
        };
    }


    public void visitBlock(Block b) {
        System.out.println("Error " + b + " Block ");
    }

    public void visitWhile(WhileNode w) {
        resolve(w.com());
        resolve(w.block()); //todo com in block scope?
    }

    //cord FDeclNode(boolean virtual, Type type, boolean and, IDNode id,
    // ParamNodeDecl params, BlockNode block) implements ASTNode,Statement {}
    //r

    public void visitFCall(FCallNode f) {
        currentScope.resolve(f.id().name());
        for (Expression s : f.params().params()) {
            resolve(s);
        }
    }

    public void visitConCall(ConCallNode c) {
        currentScope.resolve(c.name().name());
        for (Expression e : c.params().params()) {
            resolve(e);
        }
    }

    public void visitMCallStmt(MCall m) {//todo inherit scope
        //Klasse ist im globalen Scope, sollte so gehen
        currentScope.resolve(m.clars().name());
        //Funktionsname ist nicht im globalen Scope, sondern Klassen Scope
        currentScope.resolve(m.fName().name());

        for (Expression e : m.params().params()) {
            resolve(e);
        }
    }

    private Type visitMCallExpr(MCall m) {
        return classScope.resolve(m.fName().name()).getType();
    }


    public void visitIf(IfNode i) {
        resolve(i.com());
        resolve(i.thenBlock());
        if (i.elseBlock() != null) {
            resolve(i.elseBlock());
        }
    }

    public void visitBlock(BlockNode b) {
        Scope blockScope = new Scope(currentScope);
        this.currentScope = blockScope; // Scope wechseln
        for (Statement s : b.body()) {
            resolve(s);
        }
        this.currentScope = currentScope.getParent();
    }

    public void visitFBlock(FBlockNode b) {
        //this.currentScope = new Scope(currentScope);
        for (Statement s : b.body()) {
            resolve(s);
        }
    }

    public void visitCBlock(CBlockNode b) {
        for (Statement s : b.body()) {
            resolve(s);
        }
    }

    //class b {}
    //int c(){
    //return 2
    //
    //

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

    // == visit Statements ==
    private void visitInit(InitNode initNode) {

    }


    private void visitDecl(DeclNode declNode) {

    }

    private void visitAssi(AssiNode assiNode) {//record AssiNode(IDNode id, Expression value) implements Statement, ASTNode{}
        currentScope.resolve(assiNode.id().name());
    }


    public void visitFDecl(FDeclNode f) {
        Symbol ids = new Symbol(f.id().name(), f.type(), f, currentScope, f.and());
        currentScope.bind(ids);
        //neuer Scope
        this.currentScope = new Scope(currentScope);
        //Parameter binden
        for (SingleParamNode p : f.params().params()) {
            Symbol s = new Symbol(p.id().name(), p.type(), f, currentScope, f.and());
            currentScope.bind(s);
        }
        resolve(f.block());
        currentScope = currentScope.getParent();
    }


    public void visitCDecl(CDeclNode c) {
        if (c.isInherit()) {
            //Scope inheritScope = resolveClass(c.inherit().name());
            Scope oldScope = this.currentScope;
           // this.currentScope = new Scope(inheritScope);
            visitCDeclHelper(c);

            // scope zurück setzen
            this.currentScope = oldScope;
        } else {
            currentScope = new Scope(currentScope);

            visitCDeclHelper(c);
            //current scope zurück setzen
            this.currentScope = currentScope.getParent();
        }
    }

    private void visitCDeclHelper(CDeclNode c) {
        IDType idType = new IDType(c.name());
        Symbol sName = new Symbol(c.name().name(), idType, c, currentScope, false);
        currentScope.bind(sName);
        resolve(c.block());

    }
}

