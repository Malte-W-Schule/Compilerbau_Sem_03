package org.example;

import java.util.*;

public class Binder {

    private Scope currentScope;
    private Map<ASTNode, Scope> nodeScope = new IdentityHashMap<>(); //sehr gut
    //identity hashmap?

    public Map<ASTNode, Scope> getNodeScope() {
        return nodeScope;
    }

    public Binder() {
        // Globaler Scope (Eltern-Scope ist null)
        currentScope = new Scope(null);

        initNativeFunctions();
    }

    public Scope getCurrentScope() {
        return this.currentScope;
    }

    public void visitProgram(ProgramNode node) {
        for (ASTNode n : node.statements()) {
            if (n instanceof Statement) {
                visitStmt((Statement) n);
            } else if (n instanceof Expression) {
                visitExpression((Expression) n);
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
        }
        ;
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
        nodeScope.put(l, currentScope);
    }

    private void visitArithmetischeExpressionNode(ArithmetischeExpressionNode a) {
        nodeScope.put(a, currentScope);
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
        //neuer Scope
        this.currentScope = new Scope(currentScope);
        //Parameter binden
        for (SingleParamNode p : f.params().params()) {
            Symbol s = new Symbol(p.id().name(), p.type(), f, currentScope, f.and());
            currentScope.bind(s);
        }

        visitStmt(f.block());

        Symbol ids = new Symbol(f.nameParaKombi(), f.type(), f, currentScope, f.and());

        nodeScope.put(f, currentScope);
        currentScope = currentScope.getParent();
        currentScope.bind(ids);
    }

    //momentan kann eine Klasse die eine Vererbung hat, nicht als Superklasse genutzt werden
    private void visitCDecl(CDeclNode c) {

        if (c.isInherit()) {
            Symbol superClazzSymbol = currentScope.resolve(c.inherit().name());
            Clazz clazzScope = (Clazz) superClazzSymbol.getScope();

            Scope globalScope = currentScope;
            //currentScope.resolve(c.inherit().name());

            this.currentScope = new Clazz(currentScope, clazzScope);//Patrick sagt, ist richtig
            visitStmt(c.block());

            Symbol clas = new Symbol(c.name().name(), c.name(), c, currentScope, false);
            nodeScope.put(c, currentScope);
            this.currentScope = globalScope; // current scope zurück auf global setzen
            currentScope.bind(clas);

        } else {
            //neuer Scope der Klasse
            this.currentScope = new Clazz(this.currentScope);
            //neues Symbol das Klassenscope speichert für spätere Vererbung
            //Symbol klassenSymbol = new Symbol(c.name().name(), c.name(), c, currentScope, false);
            //classscope.bind(klassenSymbol);
            //currentScope.bind(klassenSymbol);
            //alles im Block an currentScope speichern, Parent ist global weil keine Vererbung
            visitStmt(c.block());
            //current scope zurück setzen
            Symbol clas = new Symbol(c.name().name(), c.name(), c, currentScope, false);
            nodeScope.put(c, currentScope);
            this.currentScope = currentScope.getParent();
            currentScope.bind(clas);
        }
    }

    private void visitConDecl(ConDeclNode c) {
        // Logik für Konstruktor-Deklarationen
        this.currentScope = new Scope(currentScope);
        //Parameter binden
        for (SingleParamNode p : c.params().params()) {
            Symbol s = new Symbol(p.id().name(), p.type(), c, currentScope, p.and());
            currentScope.bind(s);
        }
        visitStmt(c.block());
        Symbol sym = new Symbol(c.nameParaKombi(), c.name(), c, currentScope, false);
        nodeScope.put(c, currentScope);
        currentScope = currentScope.getParent();
        currentScope.bind(sym);
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

    }

    private void visitMCallStmt(MCall m) {

    }

    // ========================================

    //print_bool, print_int, print_char, print_string
    private void initNativeFunctions() {

        //Eingebaute Funktionen (Runtime/Standardbibliothek): print_bool, print_int, print_char, print_string (Ausgabe eines Werts des jeweiligen Typs)

        // == Print Int ==
        SingleParamNode intPara = new SingleParamNode(new IntType(), false, new IDNode(""));
        ParamNodeDecl intParams = new ParamNodeDecl(List.of(intPara));
        IDNode print_int = new IDNode("print_int");

        FBlockNode fblockInt = new FBlockNode(new ReturnNode(null), List.of());
        FDeclNode fDeclInt = new FDeclNode(false, new VoidType(), false, print_int, intParams, fblockInt, "print_int_IntType[]");

        Symbol native_print_int = new Symbol("print_int_IntType[]", new VoidType(), fDeclInt, this.currentScope, false);
        System.out.println(this.currentScope);
        this.currentScope.bind(native_print_int);

        // == Print Bool ==
        SingleParamNode boolPara = new SingleParamNode(new BoolType(), false, new IDNode(""));
        ParamNodeDecl boolParams = new ParamNodeDecl(List.of(boolPara));
        IDNode print_bool = new IDNode("print_bool");

        FBlockNode fBlockBool = new FBlockNode(new ReturnNode(null), List.of());
        FDeclNode fDeclBool = new FDeclNode(false, new VoidType(), false, print_bool, boolParams, fBlockBool, "print_bool_BoolType[]");

        Symbol native_print_bool = new Symbol("print_bool_BoolType[]", new VoidType(), fDeclBool, this.currentScope, false);
        this.currentScope.bind(native_print_bool);

        // == Print Char ==
        SingleParamNode charPara = new SingleParamNode(new CharType(), false, new IDNode(""));
        ParamNodeDecl charParams = new ParamNodeDecl(List.of(charPara));
        IDNode print_char = new IDNode("print_char");

        FBlockNode fblockChar = new FBlockNode(new ReturnNode(null), List.of());
        FDeclNode fDeclNodeChar = new FDeclNode(false, new VoidType(), false, print_char, charParams, fblockChar, "print_char_CharType[]");

        Symbol native_print_char = new Symbol("print_char_CharType[]", new VoidType(), fDeclNodeChar, this.currentScope, false);
        this.currentScope.bind(native_print_char);

        // == Print String ==
        SingleParamNode strPara = new SingleParamNode(new StringType(), false, new IDNode(""));
        ParamNodeDecl strParams = new ParamNodeDecl(List.of(strPara));
        IDNode print_str = new IDNode("print_str");

        FBlockNode fblockStr = new FBlockNode(new ReturnNode(null), List.of());
        FDeclNode fDeclNodeStr = new FDeclNode(false, new VoidType(), false, print_str, strParams, fblockStr, "print_str_StrType[]");

        Symbol native_print_str = new Symbol("print_str_StrType[]", new VoidType(), fDeclNodeStr, this.currentScope, false);
        this.currentScope.bind(native_print_str);
    }

}
