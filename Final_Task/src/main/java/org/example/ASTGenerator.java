package org.example;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr.CplusplusBaseVisitor;
import org.example.antlr.CplusplusParser;

import javax.naming.Context;
import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

public class ASTGenerator extends CplusplusBaseVisitor<ASTNode> {

    //todo visit methoden implementieren:
    //visitClass_decl
    // visitM_call
    // visitConstructor_call
    // visitconstructor_decl

    @Override public ASTNode visitClass_decl(CplusplusParser.Class_declContext ctx) {

        //T x; == T()
        //T x = T(args)
        //record CDeclNode(IDNode name, List<FDeclNode> functions,BlockNode constructor) implements ASTNode{}

        String name = ctx.ID().toString();
        IDNode id = new IDNode(name);
        ConDeclNode constructor = null;
        List<FDeclNode> functions = new ArrayList<>();

        for(CplusplusParser.StmtContext stmtContext: ctx.stmt()){
            ASTNode node = visit(stmtContext);
            if (node instanceof FDeclNode) {
                functions.add((FDeclNode) node);
            }
            else if (node instanceof ConDeclNode) {
                constructor = (ConDeclNode) node;
            }
            //evtl noch auf variablen und klassenattribute checken

        }
        return new CDeclNode(id, functions, constructor);
    }

    @Override public ASTNode visitM_call(CplusplusParser.M_callContext ctx) {
//record MCall(IDNode clars, IDNode fName, List<Expression> params) implements ASTNode{}

        String objText = ctx.ID(0).getText();
        IDNode objName = new IDNode(objText);

        String methodText = ctx.ID(1).getText();
        IDNode methodName = new IDNode(methodText);

        List<Expression> params = new ArrayList<>();

        if(ctx.parameter_call() != null)
        {
         for(CplusplusParser.ExprContext exprContext:ctx.parameter_call().expr())
         {
             ASTNode node = visit(exprContext);
             if(node instanceof Expression)
             {
                 params.add((Expression) node);
             }
         }
        }

        return new MCall(objName,methodName,params);
    }

    @Override
    public ASTNode visitProgram(CplusplusParser.ProgramContext ctx) {
        List<Statement> statements = new ArrayList<>();

        // Alle Statements im Programm durchgehen
        for (CplusplusParser.StmtContext stmtCtx : ctx.stmt()) {
            ASTNode node = visit(stmtCtx);
            if (node instanceof Statement stmt) {
                statements.add(stmt);
                System.out.println(stmt); // todo remove
            }
        }

        return new ProgramNode(statements); }

    @Override
    public ASTNode visitStmt(CplusplusParser.StmtContext ctx) {

       /* RuleContext g = ctx.getPayload();
        if(g instanceof CplusplusParser.If_stmtContext i){visitIf_stmt(ctx)}*/
        //(g instanceof CplusplusParser.Constructor_callContext)

        return visitChildren(ctx);
        //return visit(ctx.getChild(0));
    }

    @Override
    public ASTNode visitAtom_expr(CplusplusParser.Atom_exprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitConstructor_call(CplusplusParser.Constructor_callContext ctx) {

        String name = ctx.ID(0).getText();
        IDNode id = new IDNode(name);
        return new ConCallNode(id);
    }

    @Override
    public ASTNode visitConstructor_decl(CplusplusParser.Constructor_declContext ctx) {

        String name = ctx.ID().getText();
        IDNode id = new IDNode(name);
        BlockNode block = (BlockNode) visit(ctx.block());
        return new ConDeclNode(id,block);
        //return visitChildren(ctx);
    }

    @Override
    public ASTNode visitF_decl(CplusplusParser.F_declContext ctx) {
        boolean virtual = false;
        if(ctx.VIRTUAL() != null){
            virtual = true;
        }
        Type t = (Type) visit(ctx.type());

        String name = ctx.ID().getText();
        IDNode id = new IDNode(name);

        boolean and = false;
        if(ctx.AND() != null){
             and = true;
        }
        ParamNodeDecl params = (ParamNodeDecl) visit(ctx.parameter_decl());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new FDeclNode(virtual, t, and, id, params, block);
    }

    @Override
    public ASTNode visitF_call(CplusplusParser.F_callContext ctx) {

        String name = ctx.ID().getText();
        IDNode id = new IDNode(name);
        ParamNode params = (ParamNode) visit(ctx.parameter_call());
        return new FCallNode(id,params);
    }

    @Override public ASTNode visitParameter_call(CplusplusParser.Parameter_callContext ctx) {
        List<Expression> params = new ArrayList<>();
        for( CplusplusParser.ExprContext exprContext: ctx.expr())
        {
            Expression n = (Expression) visit(exprContext);

            params.add(n);
        }
        return new ParamNode(params);
    }

    @Override public ASTNode visitParameter_decl(CplusplusParser.Parameter_declContext ctx) {
        List<SingleParamNode> params = new ArrayList<>();

        for(int i = 0; i < ctx.parameter().size(); i++){
            params.add((SingleParamNode) visit(ctx.parameter(i)));
        }

        /* "Korrektur fals andere nicht klappt"
        for(CplusplusParser.ParameterContext pCtx : ctx.parameter()) {
            params.add((SingleParamNode) visit(pCtx));
        }*/

        //type id
        return new ParamNodeDecl(params);
    }

    @Override
    public ASTNode visitParameter(CplusplusParser.ParameterContext ctx) {
        boolean and = false;
        if(ctx.AND() != null){
            and = true;
        }
        Type t = (Type) visit(ctx.type());

        String name = ctx.ID().getText();
        IDNode id = new IDNode(name);

        return new SingleParamNode(t, and, id);
    }


    @Override
    public ASTNode visitIf_stmt(CplusplusParser.If_stmtContext ctx) {
        //ComNode com = (ComNode) visit(ctx.expr()); mit ComNode?
        Expression com = (Expression) visit(ctx.expr());
        BlockNode thenblock = (BlockNode) visit(ctx.then_block());
        BlockNode elseBlock = null;
        if (ctx.else_block() != null) {
            elseBlock = (BlockNode) visit(ctx.else_block());
        }
        return new IfNode(com, thenblock, elseBlock);
    }
/*
    @Override
    public ASTNode visitCom_expr(CplusplusParser.Com_exprContext ctx) {
        ArrayList<PrimExprNode> primExprs = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < ctx.primary_expr().size(); i++) {
            primExprs.add((PrimExprNode) visit(ctx.primary_expr(i)));
        }

        for (int i = 0; i < ctx.COMP().size(); i++) {
            values.add(ctx.COMP(i).getText());
        }

        return new ComNode(primExprs, values);
    }

    @Override
    public ASTNode visitPrimary_expr(CplusplusParser.Primary_exprContext ctx) {
        boolean negate = false;
        if (ctx.NEGATE() != null) {
            negate = true;
        }

        Expression expr = null;
        if (ctx.com_expr() != null) {
            expr = (ComNode) visit(ctx.com_expr());
        }

        if (ctx.expr() != null) {
            expr = (Expression) visit(ctx.expr());
        }
        return new PrimExprNode(negate, expr);
    }
*/



    @Override
    public ASTNode visitBool(CplusplusParser.BoolContext ctx) {
        // -- not with visit v --
        boolean b = Boolean.parseBoolean(ctx.getText());
        return new BoolNode(b);
    }

    @Override
    public ASTNode visitBlock(CplusplusParser.BlockContext ctx) {
        List<Statement> body = new ArrayList<>();
        for (CplusplusParser.StmtContext stmtCtx : ctx.stmt()) {

            ASTNode node = visit(stmtCtx);

            if (node instanceof Statement) {
                body.add((Statement) node);
            }
        }

        return new BlockNode(body);
    }

    @Override
    public ASTNode visitReturn(CplusplusParser.ReturnContext ctx) {
        Expression expr = (Expression)visit(ctx.expr());
        return new ReturnNode(expr);
    }


    @Override
    public ASTNode visitWhile_stmt(CplusplusParser.While_stmtContext ctx) {
        Expression com = (Expression) visit(ctx.expr()); //todo nur expresion?
        BlockNode block = (BlockNode) visit(ctx.block());
        return new WhileNode(com, block);
    }

    @Override
    public ASTNode visitAtom(CplusplusParser.AtomContext ctx) {

        if (ctx.INT() != null) {
            String content = ctx.INT().getText();
            String sign = null;
            if(ctx.SIGN() != null){
                sign = ctx.SIGN().getText();
            }
            int i = Integer.parseInt(content);
            return new IntegerNode(sign, i);
        }
        else if(ctx.bool() != null)
        {
            return visit(ctx.bool()) ;
        }
        else if (ctx.CHAR() != null) {
            String rawText = ctx.CHAR().getText();
            // index 1 da : 'x' , x = pos 1
            char c = rawText.charAt(1);
            return new CharNode(c);
        }
        else if(ctx.LITERAL() != null){

            String rawText = ctx.LITERAL().getText();
            // index 2 da : '\x' , x = pos 2
            char c = rawText.charAt(2);
            return new LitNode(c);
        }
        else if (ctx.ID() != null) {
            String content = ctx.ID().getText();
            return new IDNode(content);
        }
        else if (ctx.STRING() != null) {
            String content = ctx.STRING().getText();
            return new StringNode(content);
            // definieren(als nodes oder anders).
        }
        else{
            throw new RuntimeException("Bing Bing Bing, das haut nich hin");
        }
    }

    @Override
    public ASTNode visitType(CplusplusParser.TypeContext ctx) {

        if (ctx.getText().equals("int")) {
            return new IntType();
        }
        else if (ctx.getText().equals("bool")) {
            return new BoolType();
        }
        else if (ctx.getText().equals("char")) {
            return new CharType();
        }
        else if (ctx.getText().equals("string")) {
        return new StringType();
        }
        else if (ctx.getText().equals("void")) {
            return new VoidType();
        }
        else{
            throw new RuntimeException("Bing Bing Bing, das haut nich hin");
        }
    }

    @Override
    public ASTNode visitDecl(CplusplusParser.DeclContext ctx) {
        boolean and = false;
        if(ctx.AND() != null){
            and = true;
        }
        Type t = (Type) visit(ctx.type());
        String name = ctx.ID().getText();
        IDNode id = new IDNode(name);
        return new DeclNode(t, id, and);
    }

    @Override
    public ASTNode visitInit(CplusplusParser.InitContext ctx) {
        boolean and = false;
        if(ctx.AND() != null){
            and = true;
        }
        Type t = (Type) visit(ctx.type());
        String name = ctx.ID().getText();
        IDNode id = new IDNode(name);
        checkForLogicalOperator(ctx.expr()); //überprüft ob Expr eine logische Operation ist
        Expression expr = (Expression)visit(ctx.expr());

        return new InitNode(t, id, and, expr);
    }

    public ASTNode visitAssign(CplusplusParser.AssignContext ctx) {
        String name = ctx.ID().getText();
        IDNode id = new IDNode(name);
        checkForLogicalOperator(ctx.expr());  //überprüft ob Expr eine logische Operation ist
        Expression value = (Expression) visit(ctx.expr());
        return new AssiNode(id, value);
    }


    public ASTNode visitGrouping(CplusplusParser.GroupingContext ctx) { return visitChildren(ctx); }

    // ==== arithmetic expressions ===
    public ASTNode visitMul_expr(CplusplusParser.Mul_exprContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("*", child1, child2);
    }
    public ASTNode visitDiv_expr(CplusplusParser.Div_exprContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("/", child1, child2);
    }

    public ASTNode visitMod_expr(CplusplusParser.Mod_exprContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("%", child1, child2);
    }

    public ASTNode visitAdd_expr(CplusplusParser.Add_exprContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("+", child1, child2);
    }
    public ASTNode visitSub_expr(CplusplusParser.Sub_exprContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("-", child1, child2);
    }

    // ==== compare expressions ====
    public ASTNode visitOr(CplusplusParser.OrContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("||", child1, child2); }
    public ASTNode visitAnd(CplusplusParser.AndContext ctx) { Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("&&", child1, child2);}

    public ASTNode visitDoubleEqual(CplusplusParser.DoubleEqualContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("==", child1, child2);
    }
    public ASTNode visitNotEqual(CplusplusParser.NotEqualContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("!=", child1, child2); }

    public ASTNode visitLessThen(CplusplusParser.LessThenContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("<", child1, child2);
    }
    public ASTNode visitLessOrEqual(CplusplusParser.LessOrEqualContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("<=", child1, child2);}

    public ASTNode visitGreaterThen(CplusplusParser.GreaterThenContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode(">", child1, child2); }
    public ASTNode visitGreaterOrEqual(CplusplusParser.GreaterOrEqualContext ctx) {
        Expression child1 = (Expression) visit(ctx.expr(0));
        Expression child2 = (Expression) visit(ctx.expr(1));
        return new ExprNode("<=", child1, child2);
    }

    public void checkForLogicalOperator(CplusplusParser.ExprContext expr) {
        if (expr instanceof CplusplusParser.AndContext) {
            throw new RuntimeException("&& nicht erlaubt in Assign");
        } else if (expr instanceof CplusplusParser.OrContext) {
            throw new RuntimeException("|| nicht erlaubt in Assign");
        } else if (expr instanceof CplusplusParser.GreaterThenContext) {
            throw new RuntimeException("> nicht erlaubt in Assign");
        } else if (expr instanceof CplusplusParser.LessThenContext) {
            throw new RuntimeException("< nicht erlaubt in Assign");
        } else if (expr instanceof CplusplusParser.GreaterOrEqualContext) {
            throw new RuntimeException(">= nicht erlaubt in Assign");
        } else if (expr instanceof CplusplusParser.LessOrEqualContext) {
            throw new RuntimeException("<= nicht erlaubt in Assign");
        } else if (expr instanceof CplusplusParser.DoubleEqualContext) {
            throw new RuntimeException("== nicht erlaubt in Assign");
        } else if (expr instanceof CplusplusParser.NotEqualContext) {
            throw new RuntimeException("!= nicht erlaubt in Assign");
        }
    }
}
