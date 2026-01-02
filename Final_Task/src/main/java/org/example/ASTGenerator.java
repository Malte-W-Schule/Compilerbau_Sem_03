package org.example;

import org.example.antlr.CplusplusBaseVisitor;
import org.example.antlr.CplusplusParser;

import java.util.ArrayList;
import java.util.List;

public class ASTGenerator extends CplusplusBaseVisitor<ASTNode> {


    @Override
    public ASTNode visitProgram(CplusplusParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitStmt(CplusplusParser.StmtContext ctx) {

       /* RuleContext g = ctx.getPayload();
        if(g instanceof CplusplusParser.If_stmtContext i){visitIf_stmt(ctx)}*/
        //(g instanceof CplusplusParser.Constructor_callContext)

        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitAtom_expr(CplusplusParser.Atom_exprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitConstructor_call(CplusplusParser.Constructor_callContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitConstructor_decl(CplusplusParser.Constructor_declContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitF_decl(CplusplusParser.F_declContext ctx) {
        //boolean virtual
        boolean virtual = false;
        if(ctx.VIRTUAL() != null){
            virtual = true;
        }
        Type t = (Type) visit(ctx);
        IDNode id = (IDNode) visit(ctx);
        //boolean and& = (boolean) visit(ctx);//todo
        ParamNodeDecl params = (ParamNodeDecl) visit(ctx.parameter_decl());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new FDeclNode(virtual, t, id, params, block);
    }

    @Override
    public ASTNode visitF_call(CplusplusParser.F_callContext ctx) {
        //FCallNode(IDNode id, List<Expression> params
        IDNode id = (IDNode) visit(ctx);
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
        List<Type> types = new ArrayList<>();
        List<IDNode> ids = new ArrayList<>();

        for(int i = 0; i < ctx.getChildCount(); i++){
            ids.add((IDNode) visit(ctx.ID(i)));
            types.add((Type) visit(ctx.type(i)));
        }

        //type id
        return new ParamNodeDecl(types, ids);
    }





    @Override
    public ASTNode visitIf_stmt(CplusplusParser.If_stmtContext ctx) {
        ComNode com = (ComNode) visit(ctx.com_expr());
        BlockNode thenblock = (BlockNode) visit(ctx.then_block());
        BlockNode elseBlock = null;
        if (ctx.else_block() != null) {
            elseBlock = (BlockNode) visit(ctx.else_block());
        }
        return new IfNode(com, thenblock, elseBlock);
    }


    @Override
    public ASTNode visitCom_expr(CplusplusParser.Com_exprContext ctx) {
        ArrayList<PrimExprNode> listPExpr = new ArrayList<>();
        ArrayList<ComTypeNode> listCType = new ArrayList<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            listPExpr.add((PrimExprNode) visit(ctx.primary_expr(i)));
            listCType.add(new ComTypeNode(ctx.COMP(i).toString())); //todo beten, täglich
        }

        return new ComNode(listPExpr, listCType);
    }

    @Override
    public ASTNode visitPrimary_expr(CplusplusParser.Primary_exprContext ctx) {
        return visitChildren(ctx);
    }

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
        return visitChildren(ctx);
    }


    @Override
    public ASTNode visitWhile_stmt(CplusplusParser.While_stmtContext ctx) {
        ComNode com = (ComNode) visit(ctx.com_expr());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new WhileNode(com, block);
    }

    @Override
    public ASTNode visitAtom(CplusplusParser.AtomContext ctx) {

        if (ctx.INT() != null) {
            String content = ctx.STRING().getText();
            int i = Integer.parseInt(content);
            return new IntegerNode(i);
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

            String rawText = ctx.CHAR().getText();
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

        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitInit(CplusplusParser.InitContext ctx) {
        return visitChildren(ctx);
    }
    //mehr?

    public ASTNode visitGrouping(CplusplusParser.GroupingContext ctx) { return visitChildren(ctx); }

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
}
