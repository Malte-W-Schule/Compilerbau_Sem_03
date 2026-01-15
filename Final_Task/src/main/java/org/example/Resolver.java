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

    private void runMapNodes() {
        //todo change fo reach map to visit ast -> change to visit instead of for each
        binder.getNodeScope().forEach((node, scope) -> {
            this.currentScope = scope;
            //resolve(node);
        });
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

        /*
        if (node instanceof Statement) {
            resolve((Statement) node);
        } else if (node instanceof Expression) {
            resolve((Expression) node);
        } else if(node instanceof ParamNodeDecl){
            ParamNodeDecl p = (ParamNodeDecl) node;
            for(SingleParamNode s : p.params())
            {
                resolve(s.type());
                //Type type, boolean and, IDNode id // todo id node? resolven
            }
        }*/


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

    //===================== aktiv resolven ================
    // == visit Statements ==
    private void visitInit(InitNode initNode) {
        //String idName = initNode.id().name();
        //currentScope.resolve(idName); //todo id nicht resolven, da diese binded wurden?
        //Scope scope = nodeScope.get(initNode);
        currentScope.resolve(resolve(initNode.value()).toString()); //todo tostring?
    }

    //x = m.f() + 4 * 5
    private void visitAssi(AssiNode assiNode) {//record AssiNode(IDNode id, Expression value) implements Statement, ASTNode{}
        Symbol lhs = currentScope.resolve(assiNode.id().name());
        //Symbol rhs = currentScope.resolve(resolve(assiNode.value()).toString());
        Expression rhs = assiNode.value();
        Type t = resolve(rhs);
        if (lhs.getType() != t) {
            System.out.println("ohoh!!");
        }
        if (assiNode.objectId().name() != null) {
            currentScope.resolve(assiNode.objectId().name());
        }//objectid klassending aufruf klasse.id (object.id)
    }

    private void visitWhile(WhileNode w) {
        resolve(w.com());
        resolve(w.block()); //todo com in block scope?
    }

    private void visitDecl(DeclNode declNode) {
        currentScope.resolve(declNode.id().name());  //todo idk ob das klappt mit object typen id
        return;
    }


    private void visitBlock(Block b) {
        System.out.print("Fehler Block");
    }

    private void visitFCall(FCallNode f) {
        currentScope.resolve(f.id().name());
        //hole FdeclNode aus Map mit ID==f.ID
        //hole fBlockNode von FDeclNode
        //hole Scope von fBlockNode
        Symbol fDecl = currentScope.resolve(f.id().name());
        FDeclNode fDeclNode = (FDeclNode) fDecl.getConnectedNode();
        Scope tempScpoe = this.currentScope;
        this.currentScope = nodeScope.get(fDeclNode.block());
        for (Expression s : f.params().params()) {
            //gucke ob der Parameter definiert ist

            //gucke, ob der Typ des Parameters zu dem definierten Typ Passt

            resolve(s);
        }

        this.currentScope = tempScpoe;
        //kein rückgabewert da Statements
    }

    private void visitConCall(ConCallNode c) {
        currentScope.resolve(c.name().name());
        for (Expression e : c.params().params()) {
            resolve(e);
        }
    }

    private void visitMCallStmt(MCall m) {//todo inherit scope
        //Klasse ist im globalen Scope, sollte so gehen
        currentScope.resolve(m.clars().name());
        //Funktionsname ist nicht im globalen Scope, sondern Klassen Scope
        currentScope.resolve(m.fName().name());
        for (Expression e : m.params().params()) {
            resolve(e);
        }
    }

    private Type visitMCallExpr(MCall m) {
        currentScope.resolve(m.fName().name()).getType();
        resolve(m.params()); //todo fehler
        currentScope.resolve(m.clars().name());
        Scope classScopes = binder.getClassScopes();
        Symbol clars = classScopes.resolve(m.clars().name());
        Scope localScope = clars.getScope();
        Symbol f = localScope.resolve(m.fName().name());

        return f.getType(); //todo denken, classe.function suchen und davon return type returnen
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

        if(b.ret() != null) //todo gucken wo resolve void returned und wie?
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

    public void visitFDecl(FDeclNode f) {
        resolve(f.block());
    }

    public void visitCDecl(CDeclNode c) {
        this.currentScope = nodeScope.get(c);
        resolve(c.block());
        this.currentScope = currentScope.getParent();
/*
        if (c.isInherit()) {
            //Scope inheritScope = resolveClass(c.inherit().name());
            Scope oldScope = this.currentScope;
            // this.currentScope = new Scope(inheritScope);
            //visitCDeclHelper(c);

        } else {
            currentScope = new Scope(currentScope);

            //visitCDeclHelper(c);
            //current scope zurück setzen
            this.currentScope = currentScope.getParent();
        } */
        return;
    }

    private void visitCDeclHelper(CDeclNode c) {
        resolve(c.block());
    }
}

