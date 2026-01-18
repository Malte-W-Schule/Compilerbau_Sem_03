// Generated from C:/Users/Sarah Kirchhof/Desktop/fgdh/Compilerbau_Sem_03/Final_Task/src/main/java/org/example/antlr/Cplusplus.g4 by ANTLR 4.13.2
package org.example.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CplusplusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CplusplusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CplusplusParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CplusplusParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CplusplusParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mod_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod_expr(CplusplusParser.Mod_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sub_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub_expr(CplusplusParser.Sub_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_expr(CplusplusParser.Add_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aritgrouping}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAritgrouping(CplusplusParser.AritgroupingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv_expr(CplusplusParser.Div_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atom_arithmExpr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_arithmExpr(CplusplusParser.Atom_arithmExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul_expr(CplusplusParser.Mul_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aexpr}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr(CplusplusParser.AexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleEqual(CplusplusParser.DoubleEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterOrEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterOrEqual(CplusplusParser.GreaterOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterThen}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThen(CplusplusParser.GreaterThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(CplusplusParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(CplusplusParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atom_logExpr}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_logExpr(CplusplusParser.Atom_logExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessOrEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessOrEqual(CplusplusParser.LessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(CplusplusParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThen}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThen(CplusplusParser.LessThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loggrouping}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoggrouping(CplusplusParser.LoggroupingContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#constructor_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor_call(CplusplusParser.Constructor_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#constructor_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor_decl(CplusplusParser.Constructor_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#f_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_decl(CplusplusParser.F_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#f_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_block(CplusplusParser.F_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#f_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_call(CplusplusParser.F_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#f_call_no_semi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_call_no_semi(CplusplusParser.F_call_no_semiContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#parameter_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_decl(CplusplusParser.Parameter_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(CplusplusParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#parameter_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_call(CplusplusParser.Parameter_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(CplusplusParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CplusplusParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(CplusplusParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(CplusplusParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#else_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_block(CplusplusParser.Else_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#then_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen_block(CplusplusParser.Then_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(CplusplusParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(CplusplusParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CplusplusParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(CplusplusParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(CplusplusParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(CplusplusParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#class_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_decl(CplusplusParser.Class_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#class_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_block(CplusplusParser.Class_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#m_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitM_call(CplusplusParser.M_callContext ctx);
}