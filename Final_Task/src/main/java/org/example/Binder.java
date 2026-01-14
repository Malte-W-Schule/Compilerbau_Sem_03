package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Binder {

    private Scope currentScope;
    private Scope classScopes;
    private Map<ASTNode, Scope> nodeScope = new HashMap<>();

    public Map<ASTNode, Scope> getNodeScope() {
        return nodeScope;
    }

    public Scope getClassScopes() {
        return this.classScopes;
    }

    public Binder() {
        // Globaler Scope (Eltern-Scope ist null)
        currentScope = new Scope(null);
        classScopes = new Scope(null);
    }

    public void visitProgram(ProgramNode node) {
        for (ASTNode n : node.statements()) {
            if (n instanceof Statement) {
                visitStmt((Statement) n);
            } else if (n instanceof Expression) {
                continue;
            } else {
                System.out.println("Was Zum Kuckuck ist: " + node.toString());
                throw new RuntimeException("kein Statement oder Expression");
            }
        }
    }

    // Statements geben keinen Typ zurück (void)
    private void visitStmt(Statement statement) {

        switch (statement) {
            case InitNode i -> visitInit(i); //
            case DeclNode d -> visitDecl(d); //
            case AssiNode a -> visitAssi(a); //
            case BlockNode b -> visitBlock(b); //
            case FBlockNode b -> visitFBlock(b); //
            case CBlockNode b -> visitCBlock(b); //
            case IfNode i -> visitIf(i); //
            case WhileNode w -> visitWhile(w); //
            case FDeclNode f -> visitFDecl(f); //
            case FCallNode f -> visitFCall(f); //
            case CDeclNode c -> visitCDecl(c); //
            case ConDeclNode c -> visitConDecl(c); //
            case ConCallNode c -> visitConCall(c); //
            case MCall m -> visitMCallStmt(m);
            case Block b -> visitBlock(b); //
            default ->
                    throw new IllegalArgumentException("Unbekannter Knotentyp: " + statement.getClass().getSimpleName());
        }
    }

    public void visitExpression(Expression expression) { //todo return void? in binder?

        switch (expression) {
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

    // === Expression ===

    private void visitMCallExpr(MCall m) {
        //nodeScope.put(m,currentScope);
        // todo type von returntype von fdecl der function
    }

    private void visitFCallExpr(FCallNode f) {
        nodeScope.put(f, currentScope);
        // todo return type? oder void
    }

    private void visitLogischeExpressionNode(LogischeExpressionNode l) {
        nodeScope.put(l,currentScope);
    }

    private void visitArithmetischeExpressionNode(LogischeExpressionNode a) {
        nodeScope.put(a,currentScope);
    }

    // =============== visit methods Statements with bind ==============================

    private void visitInit(InitNode initNode) {

        Symbol s = new Symbol(initNode.id().name(),
                initNode.type(),
                initNode,
                currentScope,
                initNode.and());
        currentScope.bind(s);

        nodeScope.put(initNode, currentScope);
    }

    private void visitDecl(DeclNode declNode) {
        Symbol s = new Symbol(declNode.id().name(),
                declNode.type(),
                declNode,
                currentScope,
                declNode.and());
        currentScope.bind(s);

        nodeScope.put(declNode, currentScope);
    }

    private void visitFDecl(FDeclNode f) {
        Symbol ids = new Symbol(f.id().name(), f.type(), f, currentScope, f.and());
        currentScope.bind(ids);
        //neuer Scope
        this.currentScope = new Scope(currentScope);
        //Parameter binden
        for (SingleParamNode p : f.params().params()) {
            Symbol s = new Symbol(p.id().name(), p.type(), f, currentScope, f.and());
            currentScope.bind(s);
        }

        visitStmt(f.block());
        nodeScope.put(f, currentScope);
        currentScope = currentScope.getParent();
    }


    //momentan kann eine Klasse die eine Vererbung hat, nicht als Superklasse genutzt werden
    private void visitCDecl(CDeclNode c) {

        //Klassenname an globalen Scope binden
        Symbol clas = new Symbol(c.name().name(), c.name(), c, currentScope, false);
        currentScope.bind(clas);

        if (c.isInherit()) {

            Scope globalScope = currentScope;
            this.currentScope = new Scope(currentScope);

            visitStmt(c.block());

            Symbol superKlasse = classScopes.resolve(c.inherit().name()); // parent/inherit scope getten
            //inherit scope parent setzen zu currentscope
            Scope superklassenScope = superKlasse.getScope();
            this.currentScope.setParent(superklassenScope);
            nodeScope.put(c, currentScope);
            this.currentScope = globalScope; // current scope zurück auf global setzen

        } else {
            //neuer Scope der Klasse
            currentScope = new Scope(currentScope);
            //neues Symbol das Klassenscope speichert für spätere Vererbung
            Symbol klassenSymbol = new Symbol(c.name().name(), c.name(), c, currentScope, false);
            classScopes.bind(klassenSymbol);
            currentScope.bind(klassenSymbol);
            //alles im Block an currentScope speichern, Parent ist global weil keine Vererbung
            visitStmt(c.block());
            //current scope zurück setzen
            nodeScope.put(c, currentScope);
            this.currentScope = currentScope.getParent();
        }
    }

    private void visitConDecl(ConDeclNode c) {
        // Logik für Konstruktor-Deklarationen
        Symbol sym = new Symbol(c.name().name(), c.name(), c, currentScope, false);
        currentScope.bind(sym);
        this.currentScope = new Scope(currentScope);
        //Parameter binden
        for (SingleParamNode p : c.params().params()) {
            Symbol s = new Symbol(p.id().name(), p.type(), c, currentScope, p.and());
            currentScope.bind(s);
        }
        visitStmt(c.block());
        nodeScope.put(c, currentScope);
        currentScope = currentScope.getParent();
    }

    // ==================================== binden über umwege ======================

    private void visitBlock(BlockNode b) {
        Scope blockScope = new Scope(currentScope);
        this.currentScope = blockScope; // Scope wechseln
        for (Statement s : b.body()) {
            visitStmt(s);
        }
        nodeScope.put(b, this.currentScope);
        this.currentScope = currentScope.getParent();
    }

    private void visitFBlock(FBlockNode b) {

        for (Statement s : b.body()) {
            visitStmt(s);
        }
        // return type;

    }

    private void visitCBlock(CBlockNode b) {
        for (Statement s : b.body()) {
            visitStmt(s);
        }
    }

    private void visitIf(IfNode i) {
        visitStmt(i.thenBlock());
        if (i.elseBlock() != null) {
            visitStmt(i.elseBlock());
        }
    }

    private void visitWhile(WhileNode w) {
        visitStmt(w.block());
    }

    // ========================= einfach gar nix machen =======================

    private void visitAssi(AssiNode assiNode) {//record AssiNode(IDNode id, Expression value) implements Statement, ASTNode{}
        //currentScope.resolve(assiNode.id().name());
        return;
    }

    private void visitBlock(Block b) {
        System.out.println("Error " + b + " Block ");
    }

    private void visitConCall(ConCallNode c) {
        return;
    }

    private void visitFCall(FCallNode f) {
        return;
    }

    private void visitMCallStmt(MCall m) {

    }

    // ========================================



    /*
    private void visitCDeclHelper(CDeclNode c) {
        IDType idType = new IDType(c.name());
        Symbol sName = new Symbol(c.name().name(), idType, c, currentScope, false);
        currentScope.bind(sName);
        classScopes.bind(sName);
        visitStmt(c.block());
    }*/


}
