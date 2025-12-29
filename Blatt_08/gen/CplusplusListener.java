// Generated from C:/Users/Malte/Documents/GitHub/Compilerbau_Sem_03/Blatt_08/untitled/src/Cplusplus.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CplusplusParser}.
 */
public interface CplusplusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#programm}.
	 * @param ctx the parse tree
	 */
	void enterProgramm(CplusplusParser.ProgrammContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#programm}.
	 * @param ctx the parse tree
	 */
	void exitProgramm(CplusplusParser.ProgrammContext ctx);
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
	 * Enter a parse tree produced by the {@code atom_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtom_expr(CplusplusParser.Atom_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atom_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtom_expr(CplusplusParser.Atom_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code point_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPoint_expr(CplusplusParser.Point_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code point_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPoint_expr(CplusplusParser.Point_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code line_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLine_expr(CplusplusParser.Line_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code line_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLine_expr(CplusplusParser.Line_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code grouping}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGrouping(CplusplusParser.GroupingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code grouping}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGrouping(CplusplusParser.GroupingContext ctx);
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
	 * Enter a parse tree produced by {@link CplusplusParser#com_expr}.
	 * @param ctx the parse tree
	 */
	void enterCom_expr(CplusplusParser.Com_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#com_expr}.
	 * @param ctx the parse tree
	 */
	void exitCom_expr(CplusplusParser.Com_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CplusplusParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expr(CplusplusParser.Primary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CplusplusParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expr(CplusplusParser.Primary_exprContext ctx);
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