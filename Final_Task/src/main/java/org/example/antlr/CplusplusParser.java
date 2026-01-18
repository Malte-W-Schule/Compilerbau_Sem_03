// Generated from C:/Users/Sarah Kirchhof/Desktop/fgdh/Compilerbau_Sem_03/Final_Task/src/main/java/org/example/antlr/Cplusplus.g4 by ANTLR 4.13.2
package org.example.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CplusplusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, LOP=24, PLOP=25, 
		LLOP=26, SIGN=27, ASS=28, COMP=29, NEGATE=30, STRING=31, INT=32, CHAR=33, 
		LITERAL=34, IF=35, ELSE=36, WHILE=37, PUBLIC=38, PRIVATE=39, CLASS=40, 
		VOID=41, VIRTUAL=42, AND=43, RETURN=44, LBRACK=45, RBRACK=46, CLBRACK=47, 
		CRBRACK=48, WS=49, COMMENT=50, IMPORT=51, M_L_COMMENT=52, ID=53;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_expr = 2, RULE_arithmExpr = 3, RULE_logExpr = 4, 
		RULE_constructor_call = 5, RULE_constructor_decl = 6, RULE_f_decl = 7, 
		RULE_f_block = 8, RULE_f_call = 9, RULE_f_call_no_semi = 10, RULE_parameter_decl = 11, 
		RULE_parameter = 12, RULE_parameter_call = 13, RULE_bool = 14, RULE_block = 15, 
		RULE_return = 16, RULE_if_stmt = 17, RULE_else_block = 18, RULE_then_block = 19, 
		RULE_while_stmt = 20, RULE_atom = 21, RULE_type = 22, RULE_decl = 23, 
		RULE_init = 24, RULE_assign = 25, RULE_class_decl = 26, RULE_class_block = 27, 
		RULE_m_call = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "expr", "arithmExpr", "logExpr", "constructor_call", 
			"constructor_decl", "f_decl", "f_block", "f_call", "f_call_no_semi", 
			"parameter_decl", "parameter", "parameter_call", "bool", "block", "return", 
			"if_stmt", "else_block", "then_block", "while_stmt", "atom", "type", 
			"decl", "init", "assign", "class_decl", "class_block", "m_call"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'%'", "'+'", "'-'", "'=='", "'!='", "'<'", "'>'", 
			"'<='", "'>='", "'&&'", "'||'", "';'", "','", "'true'", "'false'", "'string'", 
			"'int'", "'bool'", "'char'", "'.'", "':'", null, null, null, null, "'='", 
			null, "'!'", null, null, null, null, "'if'", "'else'", "'while'", "'public'", 
			"'private'", "'class'", "'void'", "'virtual'", "'&'", "'return'", "'('", 
			"')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"LOP", "PLOP", "LLOP", "SIGN", "ASS", "COMP", "NEGATE", "STRING", "INT", 
			"CHAR", "LITERAL", "IF", "ELSE", "WHILE", "PUBLIC", "PRIVATE", "CLASS", 
			"VOID", "VIRTUAL", "AND", "RETURN", "LBRACK", "RBRACK", "CLBRACK", "CRBRACK", 
			"WS", "COMMENT", "IMPORT", "M_L_COMMENT", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cplusplus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CplusplusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CplusplusParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				stmt();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9155805127114752L) != 0) );
			setState(63);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public F_callContext f_call() {
			return getRuleContext(F_callContext.class,0);
		}
		public F_declContext f_decl() {
			return getRuleContext(F_declContext.class,0);
		}
		public M_callContext m_call() {
			return getRuleContext(M_callContext.class,0);
		}
		public Constructor_callContext constructor_call() {
			return getRuleContext(Constructor_callContext.class,0);
		}
		public Constructor_declContext constructor_decl() {
			return getRuleContext(Constructor_declContext.class,0);
		}
		public Class_declContext class_decl() {
			return getRuleContext(Class_declContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public F_blockContext f_block() {
			return getRuleContext(F_blockContext.class,0);
		}
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				if_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				while_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				decl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				init();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				assign();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				f_call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(71);
				f_decl();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(72);
				m_call();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(73);
				constructor_call();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(74);
				constructor_decl();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(75);
				class_decl();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(76);
				block();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(77);
				f_block();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(78);
				class_block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ArithmExprContext arithmExpr() {
			return getRuleContext(ArithmExprContext.class,0);
		}
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public F_callContext f_call() {
			return getRuleContext(F_callContext.class,0);
		}
		public M_callContext m_call() {
			return getRuleContext(M_callContext.class,0);
		}
		public Constructor_callContext constructor_call() {
			return getRuleContext(Constructor_callContext.class,0);
		}
		public F_call_no_semiContext f_call_no_semi() {
			return getRuleContext(F_call_no_semiContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				arithmExpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				logExpr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				f_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				m_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				constructor_call();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				f_call_no_semi();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmExprContext extends ParserRuleContext {
		public ArithmExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmExpr; }
	 
		public ArithmExprContext() { }
		public void copyFrom(ArithmExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Mod_exprContext extends ArithmExprContext {
		public ArithmExprContext ae1;
		public ArithmExprContext ae2;
		public List<ArithmExprContext> arithmExpr() {
			return getRuleContexts(ArithmExprContext.class);
		}
		public ArithmExprContext arithmExpr(int i) {
			return getRuleContext(ArithmExprContext.class,i);
		}
		public Mod_exprContext(ArithmExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterMod_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitMod_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitMod_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Sub_exprContext extends ArithmExprContext {
		public ArithmExprContext ae1;
		public ArithmExprContext ae2;
		public List<ArithmExprContext> arithmExpr() {
			return getRuleContexts(ArithmExprContext.class);
		}
		public ArithmExprContext arithmExpr(int i) {
			return getRuleContext(ArithmExprContext.class,i);
		}
		public Sub_exprContext(ArithmExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterSub_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitSub_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitSub_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Add_exprContext extends ArithmExprContext {
		public ArithmExprContext ae1;
		public ArithmExprContext ae2;
		public List<ArithmExprContext> arithmExpr() {
			return getRuleContexts(ArithmExprContext.class);
		}
		public ArithmExprContext arithmExpr(int i) {
			return getRuleContext(ArithmExprContext.class,i);
		}
		public Add_exprContext(ArithmExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAdd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAdd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAdd_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AritgroupingContext extends ArithmExprContext {
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public ArithmExprContext arithmExpr() {
			return getRuleContext(ArithmExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public AritgroupingContext(ArithmExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAritgrouping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAritgrouping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAritgrouping(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Div_exprContext extends ArithmExprContext {
		public ArithmExprContext ae1;
		public ArithmExprContext ae2;
		public List<ArithmExprContext> arithmExpr() {
			return getRuleContexts(ArithmExprContext.class);
		}
		public ArithmExprContext arithmExpr(int i) {
			return getRuleContext(ArithmExprContext.class,i);
		}
		public Div_exprContext(ArithmExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterDiv_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitDiv_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitDiv_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Atom_arithmExprContext extends ArithmExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Atom_arithmExprContext(ArithmExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAtom_arithmExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAtom_arithmExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAtom_arithmExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Mul_exprContext extends ArithmExprContext {
		public ArithmExprContext ae1;
		public ArithmExprContext ae2;
		public List<ArithmExprContext> arithmExpr() {
			return getRuleContexts(ArithmExprContext.class);
		}
		public ArithmExprContext arithmExpr(int i) {
			return getRuleContext(ArithmExprContext.class,i);
		}
		public Mul_exprContext(ArithmExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterMul_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitMul_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitMul_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmExprContext arithmExpr() throws RecognitionException {
		return arithmExpr(0);
	}

	private ArithmExprContext arithmExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmExprContext _localctx = new ArithmExprContext(_ctx, _parentState);
		ArithmExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_arithmExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				_localctx = new AritgroupingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(90);
				match(LBRACK);
				setState(91);
				arithmExpr(0);
				setState(92);
				match(RBRACK);
				}
				break;
			case T__15:
			case T__16:
			case SIGN:
			case STRING:
			case INT:
			case CHAR:
			case LITERAL:
			case ID:
				{
				_localctx = new Atom_arithmExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new Mul_exprContext(new ArithmExprContext(_parentctx, _parentState));
						((Mul_exprContext)_localctx).ae1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmExpr);
						setState(97);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						{
						setState(98);
						match(T__0);
						}
						setState(99);
						((Mul_exprContext)_localctx).ae2 = arithmExpr(8);
						}
						break;
					case 2:
						{
						_localctx = new Div_exprContext(new ArithmExprContext(_parentctx, _parentState));
						((Div_exprContext)_localctx).ae1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmExpr);
						setState(100);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(101);
						match(T__1);
						}
						setState(102);
						((Div_exprContext)_localctx).ae2 = arithmExpr(7);
						}
						break;
					case 3:
						{
						_localctx = new Mod_exprContext(new ArithmExprContext(_parentctx, _parentState));
						((Mod_exprContext)_localctx).ae1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmExpr);
						setState(103);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(104);
						match(T__2);
						}
						setState(105);
						((Mod_exprContext)_localctx).ae2 = arithmExpr(6);
						}
						break;
					case 4:
						{
						_localctx = new Add_exprContext(new ArithmExprContext(_parentctx, _parentState));
						((Add_exprContext)_localctx).ae1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmExpr);
						setState(106);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(107);
						match(T__3);
						}
						setState(108);
						((Add_exprContext)_localctx).ae2 = arithmExpr(5);
						}
						break;
					case 5:
						{
						_localctx = new Sub_exprContext(new ArithmExprContext(_parentctx, _parentState));
						((Sub_exprContext)_localctx).ae1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmExpr);
						setState(109);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(110);
						match(T__4);
						}
						setState(111);
						((Sub_exprContext)_localctx).ae2 = arithmExpr(4);
						}
						break;
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogExprContext extends ParserRuleContext {
		public LogExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logExpr; }
	 
		public LogExprContext() { }
		public void copyFrom(LogExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AexprContext extends LogExprContext {
		public ArithmExprContext arithmExpr() {
			return getRuleContext(ArithmExprContext.class,0);
		}
		public AexprContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleEqualContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public DoubleEqualContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterDoubleEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitDoubleEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitDoubleEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterOrEqualContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public GreaterOrEqualContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterGreaterOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitGreaterOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitGreaterOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThenContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public GreaterThenContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterGreaterThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitGreaterThen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitGreaterThen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public OrContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public AndContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Atom_logExprContext extends LogExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode NEGATE() { return getToken(CplusplusParser.NEGATE, 0); }
		public Atom_logExprContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAtom_logExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAtom_logExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAtom_logExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessOrEqualContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public LessOrEqualContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterLessOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitLessOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitLessOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotEqualContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public NotEqualContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThenContext extends LogExprContext {
		public LogExprContext le1;
		public LogExprContext le2;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public LessThenContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterLessThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitLessThen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitLessThen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoggroupingContext extends LogExprContext {
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public TerminalNode NEGATE() { return getToken(CplusplusParser.NEGATE, 0); }
		public LoggroupingContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterLoggrouping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitLoggrouping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitLoggrouping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogExprContext logExpr() throws RecognitionException {
		return logExpr(0);
	}

	private LogExprContext logExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogExprContext _localctx = new LogExprContext(_ctx, _parentState);
		LogExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_logExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new LoggroupingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATE) {
					{
					setState(118);
					match(NEGATE);
					}
				}

				setState(121);
				match(LBRACK);
				setState(122);
				logExpr(0);
				setState(123);
				match(RBRACK);
				}
				break;
			case 2:
				{
				_localctx = new AexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				arithmExpr(0);
				}
				break;
			case 3:
				{
				_localctx = new Atom_logExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATE) {
					{
					setState(126);
					match(NEGATE);
					}
				}

				setState(129);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new DoubleEqualContext(new LogExprContext(_parentctx, _parentState));
						((DoubleEqualContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(132);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						{
						setState(133);
						match(T__5);
						}
						setState(134);
						((DoubleEqualContext)_localctx).le2 = logExpr(12);
						}
						break;
					case 2:
						{
						_localctx = new NotEqualContext(new LogExprContext(_parentctx, _parentState));
						((NotEqualContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(135);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						{
						setState(136);
						match(T__6);
						}
						setState(137);
						((NotEqualContext)_localctx).le2 = logExpr(11);
						}
						break;
					case 3:
						{
						_localctx = new LessThenContext(new LogExprContext(_parentctx, _parentState));
						((LessThenContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(138);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						{
						setState(139);
						match(T__7);
						}
						setState(140);
						((LessThenContext)_localctx).le2 = logExpr(10);
						}
						break;
					case 4:
						{
						_localctx = new GreaterThenContext(new LogExprContext(_parentctx, _parentState));
						((GreaterThenContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(141);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						{
						setState(142);
						match(T__8);
						}
						setState(143);
						((GreaterThenContext)_localctx).le2 = logExpr(9);
						}
						break;
					case 5:
						{
						_localctx = new LessOrEqualContext(new LogExprContext(_parentctx, _parentState));
						((LessOrEqualContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(144);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						{
						setState(145);
						match(T__9);
						}
						setState(146);
						((LessOrEqualContext)_localctx).le2 = logExpr(8);
						}
						break;
					case 6:
						{
						_localctx = new GreaterOrEqualContext(new LogExprContext(_parentctx, _parentState));
						((GreaterOrEqualContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(147);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(148);
						match(T__10);
						}
						setState(149);
						((GreaterOrEqualContext)_localctx).le2 = logExpr(7);
						}
						break;
					case 7:
						{
						_localctx = new AndContext(new LogExprContext(_parentctx, _parentState));
						((AndContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(150);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(151);
						match(T__11);
						}
						setState(152);
						((AndContext)_localctx).le2 = logExpr(6);
						}
						break;
					case 8:
						{
						_localctx = new OrContext(new LogExprContext(_parentctx, _parentState));
						((OrContext)_localctx).le1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(153);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						{
						setState(154);
						match(T__12);
						}
						setState(155);
						((OrContext)_localctx).le2 = logExpr(5);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Constructor_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public Parameter_callContext parameter_call() {
			return getRuleContext(Parameter_callContext.class,0);
		}
		public Constructor_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterConstructor_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitConstructor_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitConstructor_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constructor_callContext constructor_call() throws RecognitionException {
		Constructor_callContext _localctx = new Constructor_callContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constructor_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(ID);
			setState(162);
			parameter_call();
			setState(163);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Constructor_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public Parameter_declContext parameter_decl() {
			return getRuleContext(Parameter_declContext.class,0);
		}
		public F_blockContext f_block() {
			return getRuleContext(F_blockContext.class,0);
		}
		public Constructor_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterConstructor_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitConstructor_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitConstructor_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constructor_declContext constructor_decl() throws RecognitionException {
		Constructor_declContext _localctx = new Constructor_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constructor_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(ID);
			setState(166);
			parameter_decl();
			setState(167);
			f_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class F_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public Parameter_declContext parameter_decl() {
			return getRuleContext(Parameter_declContext.class,0);
		}
		public F_blockContext f_block() {
			return getRuleContext(F_blockContext.class,0);
		}
		public TerminalNode VIRTUAL() { return getToken(CplusplusParser.VIRTUAL, 0); }
		public TerminalNode AND() { return getToken(CplusplusParser.AND, 0); }
		public F_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterF_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitF_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitF_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final F_declContext f_decl() throws RecognitionException {
		F_declContext _localctx = new F_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_f_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(169);
				match(VIRTUAL);
				}
			}

			setState(172);
			type();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(173);
				match(AND);
				}
			}

			setState(176);
			match(ID);
			setState(177);
			parameter_decl();
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLBRACK:
				{
				setState(178);
				f_block();
				}
				break;
			case T__13:
				{
				setState(179);
				match(T__13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class F_blockContext extends ParserRuleContext {
		public TerminalNode CLBRACK() { return getToken(CplusplusParser.CLBRACK, 0); }
		public TerminalNode CRBRACK() { return getToken(CplusplusParser.CRBRACK, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public F_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterF_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitF_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitF_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final F_blockContext f_block() throws RecognitionException {
		F_blockContext _localctx = new F_blockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_f_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(CLBRACK);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9155805127114752L) != 0)) {
				{
				{
				setState(183);
				stmt();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(189);
				return_();
				}
			}

			setState(192);
			match(CRBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class F_callContext extends ParserRuleContext {
		public F_call_no_semiContext f_call_no_semi() {
			return getRuleContext(F_call_no_semiContext.class,0);
		}
		public F_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterF_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitF_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitF_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final F_callContext f_call() throws RecognitionException {
		F_callContext _localctx = new F_callContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_f_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			f_call_no_semi();
			setState(195);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class F_call_no_semiContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public Parameter_callContext parameter_call() {
			return getRuleContext(Parameter_callContext.class,0);
		}
		public F_call_no_semiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_call_no_semi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterF_call_no_semi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitF_call_no_semi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitF_call_no_semi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final F_call_no_semiContext f_call_no_semi() throws RecognitionException {
		F_call_no_semiContext _localctx = new F_call_no_semiContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_f_call_no_semi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(ID);
			setState(198);
			parameter_call();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_declContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public Parameter_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterParameter_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitParameter_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitParameter_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_declContext parameter_decl() throws RecognitionException {
		Parameter_declContext _localctx = new Parameter_declContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameter_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(LBRACK);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9009398281928704L) != 0)) {
				{
				setState(201);
				parameter();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(202);
					match(T__14);
					setState(203);
					parameter();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(211);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public TerminalNode AND() { return getToken(CplusplusParser.AND, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			type();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(214);
				match(AND);
				}
			}

			setState(217);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_callContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Parameter_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterParameter_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitParameter_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitParameter_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_callContext parameter_call() throws RecognitionException {
		Parameter_callContext _localctx = new Parameter_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parameter_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(LBRACK);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9042417047240704L) != 0)) {
				{
				setState(220);
				expr();
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(221);
					match(T__14);
					setState(222);
					expr();
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(230);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode CLBRACK() { return getToken(CplusplusParser.CLBRACK, 0); }
		public TerminalNode CRBRACK() { return getToken(CplusplusParser.CRBRACK, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(CLBRACK);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9155805127114752L) != 0)) {
				{
				{
				setState(235);
				stmt();
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
			match(CRBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CplusplusParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(RETURN);
			setState(244);
			expr();
			setState(245);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CplusplusParser.IF, 0); }
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public Then_blockContext then_block() {
			return getRuleContext(Then_blockContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(IF);
			setState(248);
			match(LBRACK);
			setState(249);
			logExpr(0);
			setState(250);
			match(RBRACK);
			setState(251);
			then_block();
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(252);
				else_block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_blockContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(CplusplusParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterElse_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitElse_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitElse_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_blockContext else_block() throws RecognitionException {
		Else_blockContext _localctx = new Else_blockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_else_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(ELSE);
			setState(256);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Then_blockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Then_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterThen_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitThen_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitThen_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Then_blockContext then_block() throws RecognitionException {
		Then_blockContext _localctx = new Then_blockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_then_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CplusplusParser.WHILE, 0); }
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(WHILE);
			setState(261);
			match(LBRACK);
			setState(262);
			logExpr(0);
			setState(263);
			match(RBRACK);
			setState(264);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(CplusplusParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(CplusplusParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(CplusplusParser.INT, 0); }
		public TerminalNode SIGN() { return getToken(CplusplusParser.SIGN, 0); }
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public TerminalNode LITERAL() { return getToken(CplusplusParser.LITERAL, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_atom);
		int _la;
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(STRING);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(CHAR);
				}
				break;
			case SIGN:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SIGN) {
					{
					setState(268);
					match(SIGN);
					}
				}

				setState(271);
				match(INT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(272);
				match(ID);
				}
				break;
			case LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(273);
				match(LITERAL);
				}
				break;
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 6);
				{
				setState(274);
				bool();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(CplusplusParser.VOID, 0); }
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 9009398281928704L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public TerminalNode AND() { return getToken(CplusplusParser.AND, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			type();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(280);
				match(AND);
				}
			}

			setState(283);
			match(ID);
			setState(284);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public TerminalNode ASS() { return getToken(CplusplusParser.ASS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AND() { return getToken(CplusplusParser.AND, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			type();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(287);
				match(AND);
				}
			}

			setState(290);
			match(ID);
			setState(291);
			match(ASS);
			setState(292);
			expr();
			setState(293);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CplusplusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CplusplusParser.ID, i);
		}
		public TerminalNode ASS() { return getToken(CplusplusParser.ASS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(295);
				match(ID);
				setState(296);
				match(T__21);
				}
				break;
			}
			setState(299);
			match(ID);
			setState(300);
			match(ASS);
			setState(301);
			expr();
			setState(302);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_declContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(CplusplusParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(CplusplusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CplusplusParser.ID, i);
		}
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(CplusplusParser.PUBLIC, 0); }
		public Class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterClass_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitClass_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitClass_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_declContext class_decl() throws RecognitionException {
		Class_declContext _localctx = new Class_declContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_class_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(CLASS);
			setState(305);
			match(ID);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(306);
				match(T__22);
				setState(307);
				match(PUBLIC);
				setState(308);
				match(ID);
				}
			}

			setState(311);
			class_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_blockContext extends ParserRuleContext {
		public TerminalNode CLBRACK() { return getToken(CplusplusParser.CLBRACK, 0); }
		public TerminalNode CRBRACK() { return getToken(CplusplusParser.CRBRACK, 0); }
		public TerminalNode PUBLIC() { return getToken(CplusplusParser.PUBLIC, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Class_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterClass_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitClass_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitClass_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_blockContext class_block() throws RecognitionException {
		Class_blockContext _localctx = new Class_blockContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_class_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(CLBRACK);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC) {
				{
				setState(314);
				match(PUBLIC);
				setState(315);
				match(T__22);
				}
			}

			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9155805127114752L) != 0)) {
				{
				{
				setState(318);
				stmt();
				}
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(324);
			match(CRBRACK);
			setState(325);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class M_callContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CplusplusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CplusplusParser.ID, i);
		}
		public Parameter_callContext parameter_call() {
			return getRuleContext(Parameter_callContext.class,0);
		}
		public M_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_m_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterM_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitM_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitM_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final M_callContext m_call() throws RecognitionException {
		M_callContext _localctx = new M_callContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_m_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(ID);
			setState(328);
			match(T__21);
			setState(329);
			match(ID);
			setState(330);
			parameter_call();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return arithmExpr_sempred((ArithmExprContext)_localctx, predIndex);
		case 4:
			return logExpr_sempred((LogExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmExpr_sempred(ArithmExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean logExpr_sempred(LogExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u014d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0004\u0000<\b\u0000\u000b\u0000"+
		"\f\u0000=\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"P\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002X\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003`\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003q\b\u0003\n\u0003\f\u0003t\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004x\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0080\b\u0004"+
		"\u0001\u0004\u0003\u0004\u0083\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u009d\b\u0004\n\u0004"+
		"\f\u0004\u00a0\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0003\u0007"+
		"\u00ab\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00af\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b5\b\u0007\u0001"+
		"\b\u0001\b\u0005\b\u00b9\b\b\n\b\f\b\u00bc\t\b\u0001\b\u0003\b\u00bf\b"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00cd\b\u000b\n"+
		"\u000b\f\u000b\u00d0\t\u000b\u0003\u000b\u00d2\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0003\f\u00d8\b\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u00e0\b\r\n\r\f\r\u00e3\t\r\u0003\r\u00e5\b"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u00ed\b\u000f\n\u000f\f\u000f\u00f0\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00fe\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u010e\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u0114\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u011a\b\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u0121\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u012a\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u0136\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u013d\b\u001b\u0001\u001b\u0005\u001b\u0140\b"+
		"\u001b\n\u001b\f\u001b\u0143\t\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0000\u0002\u0006\b\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0002\u0001\u0000"+
		"\u0010\u0011\u0003\u0000\u0012\u0015))55\u016c\u0000;\u0001\u0000\u0000"+
		"\u0000\u0002O\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000\u0000\u0006"+
		"_\u0001\u0000\u0000\u0000\b\u0082\u0001\u0000\u0000\u0000\n\u00a1\u0001"+
		"\u0000\u0000\u0000\f\u00a5\u0001\u0000\u0000\u0000\u000e\u00aa\u0001\u0000"+
		"\u0000\u0000\u0010\u00b6\u0001\u0000\u0000\u0000\u0012\u00c2\u0001\u0000"+
		"\u0000\u0000\u0014\u00c5\u0001\u0000\u0000\u0000\u0016\u00c8\u0001\u0000"+
		"\u0000\u0000\u0018\u00d5\u0001\u0000\u0000\u0000\u001a\u00db\u0001\u0000"+
		"\u0000\u0000\u001c\u00e8\u0001\u0000\u0000\u0000\u001e\u00ea\u0001\u0000"+
		"\u0000\u0000 \u00f3\u0001\u0000\u0000\u0000\"\u00f7\u0001\u0000\u0000"+
		"\u0000$\u00ff\u0001\u0000\u0000\u0000&\u0102\u0001\u0000\u0000\u0000("+
		"\u0104\u0001\u0000\u0000\u0000*\u0113\u0001\u0000\u0000\u0000,\u0115\u0001"+
		"\u0000\u0000\u0000.\u0117\u0001\u0000\u0000\u00000\u011e\u0001\u0000\u0000"+
		"\u00002\u0129\u0001\u0000\u0000\u00004\u0130\u0001\u0000\u0000\u00006"+
		"\u0139\u0001\u0000\u0000\u00008\u0147\u0001\u0000\u0000\u0000:<\u0003"+
		"\u0002\u0001\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0005\u0000\u0000\u0001@\u0001\u0001\u0000\u0000\u0000AP\u0003"+
		"\"\u0011\u0000BP\u0003(\u0014\u0000CP\u0003.\u0017\u0000DP\u00030\u0018"+
		"\u0000EP\u00032\u0019\u0000FP\u0003\u0012\t\u0000GP\u0003\u000e\u0007"+
		"\u0000HP\u00038\u001c\u0000IP\u0003\n\u0005\u0000JP\u0003\f\u0006\u0000"+
		"KP\u00034\u001a\u0000LP\u0003\u001e\u000f\u0000MP\u0003\u0010\b\u0000"+
		"NP\u00036\u001b\u0000OA\u0001\u0000\u0000\u0000OB\u0001\u0000\u0000\u0000"+
		"OC\u0001\u0000\u0000\u0000OD\u0001\u0000\u0000\u0000OE\u0001\u0000\u0000"+
		"\u0000OF\u0001\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000OH\u0001\u0000"+
		"\u0000\u0000OI\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000\u0000OK\u0001"+
		"\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"ON\u0001\u0000\u0000\u0000P\u0003\u0001\u0000\u0000\u0000QX\u0003\u0006"+
		"\u0003\u0000RX\u0003\b\u0004\u0000SX\u0003\u0012\t\u0000TX\u00038\u001c"+
		"\u0000UX\u0003\n\u0005\u0000VX\u0003\u0014\n\u0000WQ\u0001\u0000\u0000"+
		"\u0000WR\u0001\u0000\u0000\u0000WS\u0001\u0000\u0000\u0000WT\u0001\u0000"+
		"\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X\u0005"+
		"\u0001\u0000\u0000\u0000YZ\u0006\u0003\uffff\uffff\u0000Z[\u0005-\u0000"+
		"\u0000[\\\u0003\u0006\u0003\u0000\\]\u0005.\u0000\u0000]`\u0001\u0000"+
		"\u0000\u0000^`\u0003*\u0015\u0000_Y\u0001\u0000\u0000\u0000_^\u0001\u0000"+
		"\u0000\u0000`r\u0001\u0000\u0000\u0000ab\n\u0007\u0000\u0000bc\u0005\u0001"+
		"\u0000\u0000cq\u0003\u0006\u0003\bde\n\u0006\u0000\u0000ef\u0005\u0002"+
		"\u0000\u0000fq\u0003\u0006\u0003\u0007gh\n\u0005\u0000\u0000hi\u0005\u0003"+
		"\u0000\u0000iq\u0003\u0006\u0003\u0006jk\n\u0004\u0000\u0000kl\u0005\u0004"+
		"\u0000\u0000lq\u0003\u0006\u0003\u0005mn\n\u0003\u0000\u0000no\u0005\u0005"+
		"\u0000\u0000oq\u0003\u0006\u0003\u0004pa\u0001\u0000\u0000\u0000pd\u0001"+
		"\u0000\u0000\u0000pg\u0001\u0000\u0000\u0000pj\u0001\u0000\u0000\u0000"+
		"pm\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000s\u0007\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000uw\u0006\u0004\uffff\uffff\u0000vx\u0005\u001e\u0000"+
		"\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000yz\u0005-\u0000\u0000z{\u0003\b\u0004\u0000{|\u0005.\u0000"+
		"\u0000|\u0083\u0001\u0000\u0000\u0000}\u0083\u0003\u0006\u0003\u0000~"+
		"\u0080\u0005\u001e\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0003*\u0015\u0000\u0082u\u0001\u0000\u0000\u0000\u0082}\u0001\u0000"+
		"\u0000\u0000\u0082\u007f\u0001\u0000\u0000\u0000\u0083\u009e\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\n\u000b\u0000\u0000\u0085\u0086\u0005\u0006\u0000"+
		"\u0000\u0086\u009d\u0003\b\u0004\f\u0087\u0088\n\n\u0000\u0000\u0088\u0089"+
		"\u0005\u0007\u0000\u0000\u0089\u009d\u0003\b\u0004\u000b\u008a\u008b\n"+
		"\t\u0000\u0000\u008b\u008c\u0005\b\u0000\u0000\u008c\u009d\u0003\b\u0004"+
		"\n\u008d\u008e\n\b\u0000\u0000\u008e\u008f\u0005\t\u0000\u0000\u008f\u009d"+
		"\u0003\b\u0004\t\u0090\u0091\n\u0007\u0000\u0000\u0091\u0092\u0005\n\u0000"+
		"\u0000\u0092\u009d\u0003\b\u0004\b\u0093\u0094\n\u0006\u0000\u0000\u0094"+
		"\u0095\u0005\u000b\u0000\u0000\u0095\u009d\u0003\b\u0004\u0007\u0096\u0097"+
		"\n\u0005\u0000\u0000\u0097\u0098\u0005\f\u0000\u0000\u0098\u009d\u0003"+
		"\b\u0004\u0006\u0099\u009a\n\u0004\u0000\u0000\u009a\u009b\u0005\r\u0000"+
		"\u0000\u009b\u009d\u0003\b\u0004\u0005\u009c\u0084\u0001\u0000\u0000\u0000"+
		"\u009c\u0087\u0001\u0000\u0000\u0000\u009c\u008a\u0001\u0000\u0000\u0000"+
		"\u009c\u008d\u0001\u0000\u0000\u0000\u009c\u0090\u0001\u0000\u0000\u0000"+
		"\u009c\u0093\u0001\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000"+
		"\u009c\u0099\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\t\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u00055\u0000\u0000\u00a2\u00a3\u0003\u001a\r\u0000\u00a3\u00a4"+
		"\u0005\u000e\u0000\u0000\u00a4\u000b\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u00055\u0000\u0000\u00a6\u00a7\u0003\u0016\u000b\u0000\u00a7\u00a8\u0003"+
		"\u0010\b\u0000\u00a8\r\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005*\u0000"+
		"\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae\u0003,\u0016\u0000"+
		"\u00ad\u00af\u0005+\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u00055\u0000\u0000\u00b1\u00b4\u0003\u0016\u000b\u0000\u00b2\u00b5"+
		"\u0003\u0010\b\u0000\u00b3\u00b5\u0005\u000e\u0000\u0000\u00b4\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u000f\u0001"+
		"\u0000\u0000\u0000\u00b6\u00ba\u0005/\u0000\u0000\u00b7\u00b9\u0003\u0002"+
		"\u0001\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bf\u0003 \u0010\u0000\u00be\u00bd\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c1\u00050\u0000\u0000\u00c1\u0011\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0003\u0014\n\u0000\u00c3\u00c4\u0005\u000e\u0000\u0000\u00c4"+
		"\u0013\u0001\u0000\u0000\u0000\u00c5\u00c6\u00055\u0000\u0000\u00c6\u00c7"+
		"\u0003\u001a\r\u0000\u00c7\u0015\u0001\u0000\u0000\u0000\u00c8\u00d1\u0005"+
		"-\u0000\u0000\u00c9\u00ce\u0003\u0018\f\u0000\u00ca\u00cb\u0005\u000f"+
		"\u0000\u0000\u00cb\u00cd\u0003\u0018\f\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00c9\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0005.\u0000\u0000\u00d4\u0017\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d7\u0003,\u0016\u0000\u00d6\u00d8\u0005+\u0000\u0000\u00d7\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u00055\u0000\u0000\u00da\u0019\u0001"+
		"\u0000\u0000\u0000\u00db\u00e4\u0005-\u0000\u0000\u00dc\u00e1\u0003\u0004"+
		"\u0002\u0000\u00dd\u00de\u0005\u000f\u0000\u0000\u00de\u00e0\u0003\u0004"+
		"\u0002\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e4\u00dc\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005.\u0000"+
		"\u0000\u00e7\u001b\u0001\u0000\u0000\u0000\u00e8\u00e9\u0007\u0000\u0000"+
		"\u0000\u00e9\u001d\u0001\u0000\u0000\u0000\u00ea\u00ee\u0005/\u0000\u0000"+
		"\u00eb\u00ed\u0003\u0002\u0001\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000"+
		"\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f2\u00050\u0000\u0000\u00f2"+
		"\u001f\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005,\u0000\u0000\u00f4\u00f5"+
		"\u0003\u0004\u0002\u0000\u00f5\u00f6\u0005\u000e\u0000\u0000\u00f6!\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0005#\u0000\u0000\u00f8\u00f9\u0005-\u0000"+
		"\u0000\u00f9\u00fa\u0003\b\u0004\u0000\u00fa\u00fb\u0005.\u0000\u0000"+
		"\u00fb\u00fd\u0003&\u0013\u0000\u00fc\u00fe\u0003$\u0012\u0000\u00fd\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe#\u0001"+
		"\u0000\u0000\u0000\u00ff\u0100\u0005$\u0000\u0000\u0100\u0101\u0003\u001e"+
		"\u000f\u0000\u0101%\u0001\u0000\u0000\u0000\u0102\u0103\u0003\u001e\u000f"+
		"\u0000\u0103\'\u0001\u0000\u0000\u0000\u0104\u0105\u0005%\u0000\u0000"+
		"\u0105\u0106\u0005-\u0000\u0000\u0106\u0107\u0003\b\u0004\u0000\u0107"+
		"\u0108\u0005.\u0000\u0000\u0108\u0109\u0003\u001e\u000f\u0000\u0109)\u0001"+
		"\u0000\u0000\u0000\u010a\u0114\u0005\u001f\u0000\u0000\u010b\u0114\u0005"+
		"!\u0000\u0000\u010c\u010e\u0005\u001b\u0000\u0000\u010d\u010c\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f\u0114\u0005 \u0000\u0000\u0110\u0114\u00055\u0000\u0000"+
		"\u0111\u0114\u0005\"\u0000\u0000\u0112\u0114\u0003\u001c\u000e\u0000\u0113"+
		"\u010a\u0001\u0000\u0000\u0000\u0113\u010b\u0001\u0000\u0000\u0000\u0113"+
		"\u010d\u0001\u0000\u0000\u0000\u0113\u0110\u0001\u0000\u0000\u0000\u0113"+
		"\u0111\u0001\u0000\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114"+
		"+\u0001\u0000\u0000\u0000\u0115\u0116\u0007\u0001\u0000\u0000\u0116-\u0001"+
		"\u0000\u0000\u0000\u0117\u0119\u0003,\u0016\u0000\u0118\u011a\u0005+\u0000"+
		"\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011c\u00055\u0000\u0000"+
		"\u011c\u011d\u0005\u000e\u0000\u0000\u011d/\u0001\u0000\u0000\u0000\u011e"+
		"\u0120\u0003,\u0016\u0000\u011f\u0121\u0005+\u0000\u0000\u0120\u011f\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u00055\u0000\u0000\u0123\u0124\u0005\u001c"+
		"\u0000\u0000\u0124\u0125\u0003\u0004\u0002\u0000\u0125\u0126\u0005\u000e"+
		"\u0000\u0000\u01261\u0001\u0000\u0000\u0000\u0127\u0128\u00055\u0000\u0000"+
		"\u0128\u012a\u0005\u0016\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000"+
		"\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u00055\u0000\u0000\u012c\u012d\u0005\u001c\u0000\u0000\u012d"+
		"\u012e\u0003\u0004\u0002\u0000\u012e\u012f\u0005\u000e\u0000\u0000\u012f"+
		"3\u0001\u0000\u0000\u0000\u0130\u0131\u0005(\u0000\u0000\u0131\u0135\u0005"+
		"5\u0000\u0000\u0132\u0133\u0005\u0017\u0000\u0000\u0133\u0134\u0005&\u0000"+
		"\u0000\u0134\u0136\u00055\u0000\u0000\u0135\u0132\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u00036\u001b\u0000\u01385\u0001\u0000\u0000\u0000\u0139\u013c"+
		"\u0005/\u0000\u0000\u013a\u013b\u0005&\u0000\u0000\u013b\u013d\u0005\u0017"+
		"\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000"+
		"\u0000\u0000\u013d\u0141\u0001\u0000\u0000\u0000\u013e\u0140\u0003\u0002"+
		"\u0001\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000"+
		"\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000"+
		"\u0000\u0000\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u00050\u0000\u0000\u0145\u0146\u0005\u000e\u0000"+
		"\u0000\u01467\u0001\u0000\u0000\u0000\u0147\u0148\u00055\u0000\u0000\u0148"+
		"\u0149\u0005\u0016\u0000\u0000\u0149\u014a\u00055\u0000\u0000\u014a\u014b"+
		"\u0003\u001a\r\u0000\u014b9\u0001\u0000\u0000\u0000\u001f=OW_prw\u007f"+
		"\u0082\u009c\u009e\u00aa\u00ae\u00b4\u00ba\u00be\u00ce\u00d1\u00d7\u00e1"+
		"\u00e4\u00ee\u00fd\u010d\u0113\u0119\u0120\u0129\u0135\u013c\u0141";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}