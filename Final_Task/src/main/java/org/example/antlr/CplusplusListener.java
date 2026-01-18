// Generated from C:/Users/Sarah Kirchhof/Desktop/fgdh/Compilerbau_Sem_03/Final_Task/src/main/java/org/example/antlr/Cplusplus.g4 by ANTLR 4.13.2
package org.example.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CplusplusParser}.
 */
public interface CplusplusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CplusplusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CplusplusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CplusplusParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CplusplusParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CplusplusParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CplusplusParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mod_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void enterMod_expr(CplusplusParser.Mod_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mod_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void exitMod_expr(CplusplusParser.Mod_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sub_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void enterSub_expr(CplusplusParser.Sub_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sub_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void exitSub_expr(CplusplusParser.Sub_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdd_expr(CplusplusParser.Add_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdd_expr(CplusplusParser.Add_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aritgrouping}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void enterAritgrouping(CplusplusParser.AritgroupingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aritgrouping}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void exitAritgrouping(CplusplusParser.AritgroupingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code div_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void enterDiv_expr(CplusplusParser.Div_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code div_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void exitDiv_expr(CplusplusParser.Div_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atom_arithmExpr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtom_arithmExpr(CplusplusParser.Atom_arithmExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atom_arithmExpr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtom_arithmExpr(CplusplusParser.Atom_arithmExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mul_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void enterMul_expr(CplusplusParser.Mul_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mul_expr}
	 * labeled alternative in {@link CplusplusParser#arithmExpr}.
	 * @param ctx the parse tree
	 */
	void exitMul_expr(CplusplusParser.Mul_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aexpr}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterAexpr(CplusplusParser.AexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aexpr}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitAexpr(CplusplusParser.AexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleEqual(CplusplusParser.DoubleEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleEqual(CplusplusParser.DoubleEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterOrEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterGreaterOrEqual(CplusplusParser.GreaterOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterOrEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitGreaterOrEqual(CplusplusParser.GreaterOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThen}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThen(CplusplusParser.GreaterThenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThen}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThen(CplusplusParser.GreaterThenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterOr(CplusplusParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitOr(CplusplusParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(CplusplusParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(CplusplusParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atom_logExpr}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtom_logExpr(CplusplusParser.Atom_logExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atom_logExpr}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtom_logExpr(CplusplusParser.Atom_logExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessOrEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterLessOrEqual(CplusplusParser.LessOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessOrEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitLessOrEqual(CplusplusParser.LessOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(CplusplusParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(CplusplusParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThen}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterLessThen(CplusplusParser.LessThenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThen}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitLessThen(CplusplusParser.LessThenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loggrouping}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterLoggrouping(CplusplusParser.LoggroupingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loggrouping}
	 * labeled alternative in {@link CplusplusParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitLoggrouping(CplusplusParser.LoggroupingContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#constructor_call}.
	 * @param ctx the parse tree
	 */
	void enterConstructor_call(CplusplusParser.Constructor_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#constructor_call}.
	 * @param ctx the parse tree
	 */
	void exitConstructor_call(CplusplusParser.Constructor_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#constructor_decl}.
	 * @param ctx the parse tree
	 */
	void enterConstructor_decl(CplusplusParser.Constructor_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#constructor_decl}.
	 * @param ctx the parse tree
	 */
	void exitConstructor_decl(CplusplusParser.Constructor_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#f_decl}.
	 * @param ctx the parse tree
	 */
	void enterF_decl(CplusplusParser.F_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#f_decl}.
	 * @param ctx the parse tree
	 */
	void exitF_decl(CplusplusParser.F_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#f_block}.
	 * @param ctx the parse tree
	 */
	void enterF_block(CplusplusParser.F_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#f_block}.
	 * @param ctx the parse tree
	 */
	void exitF_block(CplusplusParser.F_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#f_call}.
	 * @param ctx the parse tree
	 */
	void enterF_call(CplusplusParser.F_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#f_call}.
	 * @param ctx the parse tree
	 */
	void exitF_call(CplusplusParser.F_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#f_call_no_semi}.
	 * @param ctx the parse tree
	 */
	void enterF_call_no_semi(CplusplusParser.F_call_no_semiContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#f_call_no_semi}.
	 * @param ctx the parse tree
	 */
	void exitF_call_no_semi(CplusplusParser.F_call_no_semiContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#parameter_decl}.
	 * @param ctx the parse tree
	 */
	void enterParameter_decl(CplusplusParser.Parameter_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#parameter_decl}.
	 * @param ctx the parse tree
	 */
	void exitParameter_decl(CplusplusParser.Parameter_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(CplusplusParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(CplusplusParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#parameter_call}.
	 * @param ctx the parse tree
	 */
	void enterParameter_call(CplusplusParser.Parameter_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#parameter_call}.
	 * @param ctx the parse tree
	 */
	void exitParameter_call(CplusplusParser.Parameter_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(CplusplusParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(CplusplusParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CplusplusParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CplusplusParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(CplusplusParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(CplusplusParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(CplusplusParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(CplusplusParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#else_block}.
	 * @param ctx the parse tree
	 */
	void enterElse_block(CplusplusParser.Else_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#else_block}.
	 * @param ctx the parse tree
	 */
	void exitElse_block(CplusplusParser.Else_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#then_block}.
	 * @param ctx the parse tree
	 */
	void enterThen_block(CplusplusParser.Then_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#then_block}.
	 * @param ctx the parse tree
	 */
	void exitThen_block(CplusplusParser.Then_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(CplusplusParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(CplusplusParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CplusplusParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CplusplusParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CplusplusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CplusplusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CplusplusParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CplusplusParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(CplusplusParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(CplusplusParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CplusplusParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CplusplusParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void enterClass_decl(CplusplusParser.Class_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void exitClass_decl(CplusplusParser.Class_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#class_block}.
	 * @param ctx the parse tree
	 */
	void enterClass_block(CplusplusParser.Class_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#class_block}.
	 * @param ctx the parse tree
	 */
	void exitClass_block(CplusplusParser.Class_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#m_call}.
	 * @param ctx the parse tree
	 */
	void enterM_call(CplusplusParser.M_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#m_call}.
	 * @param ctx the parse tree
	 */
	void exitM_call(CplusplusParser.M_callContext ctx);
}