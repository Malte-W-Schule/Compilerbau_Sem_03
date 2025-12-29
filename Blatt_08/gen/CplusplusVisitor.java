// Generated from C:/Users/Malte/Documents/GitHub/Compilerbau_Sem_03/Blatt_08/untitled/src/Cplusplus.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link CplusplusParser#programm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramm(CplusplusParser.ProgrammContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CplusplusParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atom_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_expr(CplusplusParser.Atom_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code point_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint_expr(CplusplusParser.Point_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code line_expr}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_expr(CplusplusParser.Line_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code grouping}
	 * labeled alternative in {@link CplusplusParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrouping(CplusplusParser.GroupingContext ctx);
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
	 * Visit a parse tree produced by {@link CplusplusParser#f_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_call(CplusplusParser.F_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#parameter_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_decl(CplusplusParser.Parameter_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#parameter_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_call(CplusplusParser.Parameter_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#com_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCom_expr(CplusplusParser.Com_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CplusplusParser#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expr(CplusplusParser.Primary_exprContext ctx);
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
	 * Visit a parse tree produced by {@link CplusplusParser#m_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitM_call(CplusplusParser.M_callContext ctx);
}