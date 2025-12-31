package org.example;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.antlr.CplusplusBaseVisitor;
import org.example.antlr.CplusplusParser;
import org.example.antlr.CplusplusVisitor;

import java.util.ArrayList;

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
        return visitChildren(ctx);
    }


    @Override
    public ASTNode visitF_call(CplusplusParser.F_callContext ctx) {
        return visitChildren(ctx);
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
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitBlock(CplusplusParser.BlockContext ctx) {
        return visitChildren(ctx);
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

        }

        else if (ctx.STRING() != null) {
            String content = ctx.STRING().getText();
            return new StringNode(content); //todo default varibeln wie int string etc definieren(als nodes oder anders).
        }
        //todo potential
        RuleContext g = ctx.getRuleContext();
        if(g instanceof (String) ctx.STRING()){}
        else if(g instanceof Character){}
        else if(inhalt instanceof Boolean){}
        else if(inhalt instanceof Integer){}
        else{System.out.println("Nicht unterstützder Typ")}
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitType(CplusplusParser.TypeContext ctx) {
        return visitChildren(ctx);
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


    public ASTNode visitExpr(CplusplusParser.ProgramContext ctx) {
        //expr: LBRACK expr RBRACK            #grouping
        //    | expr ('*' | '/' | '%') expr   #point_expr
        //    | expr ('+' | '-') expr         #line_expr
        //    | atom                          #atom_expr
        //    ;


        return null;
    }
}
