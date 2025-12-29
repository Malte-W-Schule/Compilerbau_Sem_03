// Generated from C:/Users/Malte/Documents/GitHub/Compilerbau_Sem_03/Blatt_08/untitled/src/Cplusplus.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CplusplusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		LOP=18, PLOP=19, LLOP=20, ASS=21, COMP=22, NEGATE=23, STRING=24, INT=25, 
		CHAR=26, LITERAL=27, IF=28, ELSE=29, WHILE=30, PUBLIC=31, PRIVATE=32, 
		CLASS=33, VOID=34, VIRTUAL=35, LBRACK=36, RBRACK=37, CLBRACK=38, CRBRACK=39, 
		WS=40, COMMENT=41, IMPORT=42, M_L_COMMENT=43, PREP=44, ID=45;
	public static final int
		RULE_programm = 0, RULE_stmt = 1, RULE_expr = 2, RULE_constructor_call = 3, 
		RULE_constructor_decl = 4, RULE_f_decl = 5, RULE_f_call = 6, RULE_parameter_decl = 7, 
		RULE_parameter_call = 8, RULE_com_expr = 9, RULE_primary_expr = 10, RULE_bool = 11, 
		RULE_block = 12, RULE_return = 13, RULE_if_stmt = 14, RULE_else_block = 15, 
		RULE_then_block = 16, RULE_while_stmt = 17, RULE_atom = 18, RULE_type = 19, 
		RULE_decl = 20, RULE_init = 21, RULE_assign = 22, RULE_class_decl = 23, 
		RULE_m_call = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"programm", "stmt", "expr", "constructor_call", "constructor_decl", "f_decl", 
			"f_call", "parameter_decl", "parameter_call", "com_expr", "primary_expr", 
			"bool", "block", "return", "if_stmt", "else_block", "then_block", "while_stmt", 
			"atom", "type", "decl", "init", "assign", "class_decl", "m_call"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'%'", "'+'", "'-'", "';'", "','", "'true'", "'false'", 
			"'return'", "'string'", "'int'", "'bool'", "'char'", "'&'", "':'", "'.'", 
			null, null, null, "'='", null, "'!'", null, null, null, null, "'if'", 
			"'else'", "'while'", "'public'", "'private'", "'class'", "'void'", "'virtual'", 
			"'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "LOP", "PLOP", "LLOP", "ASS", "COMP", 
			"NEGATE", "STRING", "INT", "CHAR", "LITERAL", "IF", "ELSE", "WHILE", 
			"PUBLIC", "PRIVATE", "CLASS", "VOID", "VIRTUAL", "LBRACK", "RBRACK", 
			"CLBRACK", "CRBRACK", "WS", "COMMENT", "IMPORT", "M_L_COMMENT", "PREP", 
			"ID"
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
	public static class ProgrammContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CplusplusParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgrammContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterProgramm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitProgramm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitProgramm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgrammContext programm() throws RecognitionException {
		ProgrammContext _localctx = new ProgrammContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				stmt();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 35245843838976L) != 0) );
			setState(55);
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				if_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				while_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				decl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				init();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				assign();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(62);
				f_call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(63);
				f_decl();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(64);
				m_call();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(65);
				constructor_call();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(66);
				constructor_decl();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(67);
				class_decl();
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Atom_exprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Atom_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterAtom_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitAtom_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitAtom_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Point_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Point_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterPoint_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitPoint_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitPoint_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Line_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Line_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterLine_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitLine_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitLine_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupingContext extends ExprContext {
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public GroupingContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterGrouping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitGrouping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitGrouping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				_localctx = new GroupingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71);
				match(LBRACK);
				setState(72);
				expr(0);
				setState(73);
				match(RBRACK);
				}
				break;
			case T__7:
			case T__8:
			case STRING:
			case INT:
			case CHAR:
			case LITERAL:
			case ID:
				{
				_localctx = new Atom_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(84);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new Point_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(79);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(80);
						expr(4);
						}
						break;
					case 2:
						{
						_localctx = new Line_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(82);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(83);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		public List<TerminalNode> ID() { return getTokens(CplusplusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CplusplusParser.ID, i);
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
		enterRule(_localctx, 6, RULE_constructor_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(ID);
			setState(90);
			match(ID);
			setState(91);
			match(T__5);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 8, RULE_constructor_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(ID);
			setState(94);
			parameter_decl();
			setState(95);
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
	public static class F_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public Parameter_declContext parameter_decl() {
			return getRuleContext(Parameter_declContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode VIRTUAL() { return getToken(CplusplusParser.VIRTUAL, 0); }
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
		enterRule(_localctx, 10, RULE_f_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VIRTUAL) {
				{
				setState(97);
				match(VIRTUAL);
				}
			}

			setState(100);
			type();
			setState(101);
			match(ID);
			setState(102);
			parameter_decl();
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLBRACK:
				{
				setState(103);
				block();
				}
				break;
			case T__5:
				{
				setState(104);
				match(T__5);
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
	public static class F_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
		public Parameter_callContext parameter_call() {
			return getRuleContext(Parameter_callContext.class,0);
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
		enterRule(_localctx, 12, RULE_f_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(ID);
			setState(108);
			parameter_call();
			setState(109);
			match(T__5);
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
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CplusplusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CplusplusParser.ID, i);
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
		enterRule(_localctx, 14, RULE_parameter_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(LBRACK);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179899904L) != 0)) {
				{
				setState(112);
				type();
				setState(113);
				match(ID);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(114);
					match(T__6);
					setState(115);
					type();
					setState(116);
					match(ID);
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(125);
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
	public static class Parameter_callContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public List<TerminalNode> ID() { return getTokens(CplusplusParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CplusplusParser.ID, i);
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
		enterRule(_localctx, 16, RULE_parameter_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(LBRACK);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(128);
				match(ID);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(129);
					match(T__6);
					setState(130);
					match(ID);
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(138);
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
	public static class Com_exprContext extends ParserRuleContext {
		public List<Primary_exprContext> primary_expr() {
			return getRuleContexts(Primary_exprContext.class);
		}
		public Primary_exprContext primary_expr(int i) {
			return getRuleContext(Primary_exprContext.class,i);
		}
		public List<TerminalNode> COMP() { return getTokens(CplusplusParser.COMP); }
		public TerminalNode COMP(int i) {
			return getToken(CplusplusParser.COMP, i);
		}
		public Com_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterCom_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitCom_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitCom_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Com_exprContext com_expr() throws RecognitionException {
		Com_exprContext _localctx = new Com_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_com_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			primary_expr();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMP) {
				{
				{
				setState(141);
				match(COMP);
				setState(142);
				primary_expr();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Primary_exprContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode NEGATE() { return getToken(CplusplusParser.NEGATE, 0); }
		public TerminalNode LBRACK() { return getToken(CplusplusParser.LBRACK, 0); }
		public Com_exprContext com_expr() {
			return getRuleContext(Com_exprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).enterPrimary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CplusplusListener ) ((CplusplusListener)listener).exitPrimary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CplusplusVisitor ) return ((CplusplusVisitor<? extends T>)visitor).visitPrimary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primary_expr);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATE) {
					{
					setState(148);
					match(NEGATE);
					}
				}

				setState(151);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATE) {
					{
					setState(152);
					match(NEGATE);
					}
				}

				setState(155);
				match(LBRACK);
				setState(156);
				com_expr();
				setState(157);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATE) {
					{
					setState(159);
					match(NEGATE);
					}
				}

				setState(162);
				match(LBRACK);
				setState(163);
				expr(0);
				setState(164);
				match(RBRACK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEGATE) {
					{
					setState(166);
					match(NEGATE);
					}
				}

				setState(169);
				expr(0);
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
		enterRule(_localctx, 22, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
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
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
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
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(CLBRACK);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35245843838976L) != 0)) {
				{
				{
				setState(175);
				stmt();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__9) {
				{
				setState(181);
				return_();
				}
			}

			setState(184);
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
		enterRule(_localctx, 26, RULE_return);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(186);
				match(T__9);
				setState(187);
				expr(0);
				}
			}

			setState(190);
			match(T__5);
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
		public TerminalNode RBRACK() { return getToken(CplusplusParser.RBRACK, 0); }
		public Then_blockContext then_block() {
			return getRuleContext(Then_blockContext.class,0);
		}
		public List<Com_exprContext> com_expr() {
			return getRuleContexts(Com_exprContext.class);
		}
		public Com_exprContext com_expr(int i) {
			return getRuleContext(Com_exprContext.class,i);
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
		enterRule(_localctx, 28, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(IF);
			setState(193);
			match(LBRACK);
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				com_expr();
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 35253351613184L) != 0) );
			setState(199);
			match(RBRACK);
			setState(200);
			then_block();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(201);
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
		enterRule(_localctx, 30, RULE_else_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(ELSE);
			setState(205);
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
		enterRule(_localctx, 32, RULE_then_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
		public Com_exprContext com_expr() {
			return getRuleContext(Com_exprContext.class,0);
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
		enterRule(_localctx, 34, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(WHILE);
			setState(210);
			match(LBRACK);
			setState(211);
			com_expr();
			setState(212);
			match(RBRACK);
			setState(213);
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
		enterRule(_localctx, 36, RULE_atom);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(STRING);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(CHAR);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				match(INT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(ID);
				}
				break;
			case LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				match(LITERAL);
				}
				break;
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
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
		enterRule(_localctx, 38, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179899904L) != 0)) ) {
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
		enterRule(_localctx, 40, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			type();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(226);
				match(T__14);
				}
			}

			setState(229);
			match(ID);
			setState(230);
			match(T__5);
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
		enterRule(_localctx, 42, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			type();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(233);
				match(T__14);
				}
			}

			setState(236);
			match(ID);
			setState(237);
			match(ASS);
			setState(238);
			expr(0);
			setState(239);
			match(T__5);
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
		public TerminalNode ID() { return getToken(CplusplusParser.ID, 0); }
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
		enterRule(_localctx, 44, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(ID);
			setState(242);
			match(ASS);
			setState(243);
			expr(0);
			setState(244);
			match(T__5);
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
		public TerminalNode CLBRACK() { return getToken(CplusplusParser.CLBRACK, 0); }
		public TerminalNode CRBRACK() { return getToken(CplusplusParser.CRBRACK, 0); }
		public List<TerminalNode> PUBLIC() { return getTokens(CplusplusParser.PUBLIC); }
		public TerminalNode PUBLIC(int i) {
			return getToken(CplusplusParser.PUBLIC, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
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
		enterRule(_localctx, 46, RULE_class_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(CLASS);
			setState(247);
			match(ID);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(248);
				match(T__15);
				setState(249);
				match(PUBLIC);
				setState(250);
				match(ID);
				}
			}

			setState(253);
			match(CLBRACK);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC) {
				{
				setState(254);
				match(PUBLIC);
				setState(255);
				match(T__15);
				}
			}

			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35245843838976L) != 0)) {
				{
				{
				setState(258);
				stmt();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			match(CRBRACK);
			setState(265);
			match(T__5);
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
		enterRule(_localctx, 48, RULE_m_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(ID);
			setState(268);
			match(T__16);
			setState(269);
			match(ID);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(270);
				parameter_call();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0112\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0004\u00004\b\u0000\u000b\u0000\f\u00005\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001E\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002M\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002U\b\u0002\n\u0002"+
		"\f\u0002X\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005c\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005j\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007w\b\u0007\n\u0007\f\u0007z\t\u0007\u0003\u0007|\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0084"+
		"\b\b\n\b\f\b\u0087\t\b\u0003\b\u0089\b\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u0090\b\t\n\t\f\t\u0093\t\t\u0001\n\u0003\n\u0096\b"+
		"\n\u0001\n\u0001\n\u0003\n\u009a\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00a1\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00a8"+
		"\b\n\u0001\n\u0003\n\u00ab\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0005\f\u00b1\b\f\n\f\f\f\u00b4\t\f\u0001\f\u0003\f\u00b7\b\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0003\r\u00bd\b\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0004\u000e\u00c4\b\u000e\u000b\u000e\f\u000e"+
		"\u00c5\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00cb\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00de"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u00e4"+
		"\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u00eb\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00fc"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0101\b\u0017"+
		"\u0001\u0017\u0005\u0017\u0104\b\u0017\n\u0017\f\u0017\u0107\t\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0110\b\u0018\u0001\u0018\u0000\u0001\u0004\u0019\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.0\u0000\u0004\u0001\u0000\u0001\u0003\u0001\u0000\u0004"+
		"\u0005\u0001\u0000\b\t\u0002\u0000\u000b\u000e\"\"\u0124\u00003\u0001"+
		"\u0000\u0000\u0000\u0002D\u0001\u0000\u0000\u0000\u0004L\u0001\u0000\u0000"+
		"\u0000\u0006Y\u0001\u0000\u0000\u0000\b]\u0001\u0000\u0000\u0000\nb\u0001"+
		"\u0000\u0000\u0000\fk\u0001\u0000\u0000\u0000\u000eo\u0001\u0000\u0000"+
		"\u0000\u0010\u007f\u0001\u0000\u0000\u0000\u0012\u008c\u0001\u0000\u0000"+
		"\u0000\u0014\u00aa\u0001\u0000\u0000\u0000\u0016\u00ac\u0001\u0000\u0000"+
		"\u0000\u0018\u00ae\u0001\u0000\u0000\u0000\u001a\u00bc\u0001\u0000\u0000"+
		"\u0000\u001c\u00c0\u0001\u0000\u0000\u0000\u001e\u00cc\u0001\u0000\u0000"+
		"\u0000 \u00cf\u0001\u0000\u0000\u0000\"\u00d1\u0001\u0000\u0000\u0000"+
		"$\u00dd\u0001\u0000\u0000\u0000&\u00df\u0001\u0000\u0000\u0000(\u00e1"+
		"\u0001\u0000\u0000\u0000*\u00e8\u0001\u0000\u0000\u0000,\u00f1\u0001\u0000"+
		"\u0000\u0000.\u00f6\u0001\u0000\u0000\u00000\u010b\u0001\u0000\u0000\u0000"+
		"24\u0003\u0002\u0001\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000078\u0005\u0000\u0000\u00018\u0001\u0001\u0000\u0000\u0000"+
		"9E\u0003\u001c\u000e\u0000:E\u0003\"\u0011\u0000;E\u0003(\u0014\u0000"+
		"<E\u0003*\u0015\u0000=E\u0003,\u0016\u0000>E\u0003\f\u0006\u0000?E\u0003"+
		"\n\u0005\u0000@E\u00030\u0018\u0000AE\u0003\u0006\u0003\u0000BE\u0003"+
		"\b\u0004\u0000CE\u0003.\u0017\u0000D9\u0001\u0000\u0000\u0000D:\u0001"+
		"\u0000\u0000\u0000D;\u0001\u0000\u0000\u0000D<\u0001\u0000\u0000\u0000"+
		"D=\u0001\u0000\u0000\u0000D>\u0001\u0000\u0000\u0000D?\u0001\u0000\u0000"+
		"\u0000D@\u0001\u0000\u0000\u0000DA\u0001\u0000\u0000\u0000DB\u0001\u0000"+
		"\u0000\u0000DC\u0001\u0000\u0000\u0000E\u0003\u0001\u0000\u0000\u0000"+
		"FG\u0006\u0002\uffff\uffff\u0000GH\u0005$\u0000\u0000HI\u0003\u0004\u0002"+
		"\u0000IJ\u0005%\u0000\u0000JM\u0001\u0000\u0000\u0000KM\u0003$\u0012\u0000"+
		"LF\u0001\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000MV\u0001\u0000\u0000"+
		"\u0000NO\n\u0003\u0000\u0000OP\u0007\u0000\u0000\u0000PU\u0003\u0004\u0002"+
		"\u0004QR\n\u0002\u0000\u0000RS\u0007\u0001\u0000\u0000SU\u0003\u0004\u0002"+
		"\u0003TN\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000UX\u0001\u0000"+
		"\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W\u0005"+
		"\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005-\u0000\u0000"+
		"Z[\u0005-\u0000\u0000[\\\u0005\u0006\u0000\u0000\\\u0007\u0001\u0000\u0000"+
		"\u0000]^\u0005-\u0000\u0000^_\u0003\u000e\u0007\u0000_`\u0003\u0018\f"+
		"\u0000`\t\u0001\u0000\u0000\u0000ac\u0005#\u0000\u0000ba\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0003&\u0013"+
		"\u0000ef\u0005-\u0000\u0000fi\u0003\u000e\u0007\u0000gj\u0003\u0018\f"+
		"\u0000hj\u0005\u0006\u0000\u0000ig\u0001\u0000\u0000\u0000ih\u0001\u0000"+
		"\u0000\u0000j\u000b\u0001\u0000\u0000\u0000kl\u0005-\u0000\u0000lm\u0003"+
		"\u0010\b\u0000mn\u0005\u0006\u0000\u0000n\r\u0001\u0000\u0000\u0000o{"+
		"\u0005$\u0000\u0000pq\u0003&\u0013\u0000qx\u0005-\u0000\u0000rs\u0005"+
		"\u0007\u0000\u0000st\u0003&\u0013\u0000tu\u0005-\u0000\u0000uw\u0001\u0000"+
		"\u0000\u0000vr\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000"+
		"zx\u0001\u0000\u0000\u0000{p\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}~\u0005%\u0000\u0000~\u000f\u0001\u0000"+
		"\u0000\u0000\u007f\u0088\u0005$\u0000\u0000\u0080\u0085\u0005-\u0000\u0000"+
		"\u0081\u0082\u0005\u0007\u0000\u0000\u0082\u0084\u0005-\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088"+
		"\u0080\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0005%\u0000\u0000\u008b\u0011"+
		"\u0001\u0000\u0000\u0000\u008c\u0091\u0003\u0014\n\u0000\u008d\u008e\u0005"+
		"\u0016\u0000\u0000\u008e\u0090\u0003\u0014\n\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0013\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0096\u0005\u0017"+
		"\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u00ab\u0003$\u0012"+
		"\u0000\u0098\u009a\u0005\u0017\u0000\u0000\u0099\u0098\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0005$\u0000\u0000\u009c\u009d\u0003\u0012\t\u0000"+
		"\u009d\u009e\u0005%\u0000\u0000\u009e\u00ab\u0001\u0000\u0000\u0000\u009f"+
		"\u00a1\u0005\u0017\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0005$\u0000\u0000\u00a3\u00a4\u0003\u0004\u0002\u0000\u00a4\u00a5"+
		"\u0005%\u0000\u0000\u00a5\u00ab\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005"+
		"\u0017\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0003"+
		"\u0004\u0002\u0000\u00aa\u0095\u0001\u0000\u0000\u0000\u00aa\u0099\u0001"+
		"\u0000\u0000\u0000\u00aa\u00a0\u0001\u0000\u0000\u0000\u00aa\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ab\u0015\u0001\u0000\u0000\u0000\u00ac\u00ad\u0007"+
		"\u0002\u0000\u0000\u00ad\u0017\u0001\u0000\u0000\u0000\u00ae\u00b2\u0005"+
		"&\u0000\u0000\u00af\u00b1\u0003\u0002\u0001\u0000\u00b0\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b7\u0003\u001a"+
		"\r\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\'\u0000\u0000"+
		"\u00b9\u0019\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\n\u0000\u0000\u00bb"+
		"\u00bd\u0003\u0004\u0002\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0005\u0006\u0000\u0000\u00bf\u001b\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0005\u001c\u0000\u0000\u00c1\u00c3\u0005$\u0000\u0000\u00c2\u00c4"+
		"\u0003\u0012\t\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005"+
		"%\u0000\u0000\u00c8\u00ca\u0003 \u0010\u0000\u00c9\u00cb\u0003\u001e\u000f"+
		"\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u001d\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u001d\u0000"+
		"\u0000\u00cd\u00ce\u0003\u0018\f\u0000\u00ce\u001f\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u0003\u0018\f\u0000\u00d0!\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0005\u001e\u0000\u0000\u00d2\u00d3\u0005$\u0000\u0000\u00d3\u00d4"+
		"\u0003\u0012\t\u0000\u00d4\u00d5\u0005%\u0000\u0000\u00d5\u00d6\u0003"+
		"\u0018\f\u0000\u00d6#\u0001\u0000\u0000\u0000\u00d7\u00de\u0005\u0018"+
		"\u0000\u0000\u00d8\u00de\u0005\u001a\u0000\u0000\u00d9\u00de\u0005\u0019"+
		"\u0000\u0000\u00da\u00de\u0005-\u0000\u0000\u00db\u00de\u0005\u001b\u0000"+
		"\u0000\u00dc\u00de\u0003\u0016\u000b\u0000\u00dd\u00d7\u0001\u0000\u0000"+
		"\u0000\u00dd\u00d8\u0001\u0000\u0000\u0000\u00dd\u00d9\u0001\u0000\u0000"+
		"\u0000\u00dd\u00da\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de%\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0007\u0003\u0000\u0000\u00e0\'\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e3\u0003&\u0013\u0000\u00e2\u00e4\u0005\u000f\u0000\u0000\u00e3\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005-\u0000\u0000\u00e6\u00e7\u0005"+
		"\u0006\u0000\u0000\u00e7)\u0001\u0000\u0000\u0000\u00e8\u00ea\u0003&\u0013"+
		"\u0000\u00e9\u00eb\u0005\u000f\u0000\u0000\u00ea\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0005-\u0000\u0000\u00ed\u00ee\u0005\u0015\u0000\u0000"+
		"\u00ee\u00ef\u0003\u0004\u0002\u0000\u00ef\u00f0\u0005\u0006\u0000\u0000"+
		"\u00f0+\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005-\u0000\u0000\u00f2\u00f3"+
		"\u0005\u0015\u0000\u0000\u00f3\u00f4\u0003\u0004\u0002\u0000\u00f4\u00f5"+
		"\u0005\u0006\u0000\u0000\u00f5-\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005"+
		"!\u0000\u0000\u00f7\u00fb\u0005-\u0000\u0000\u00f8\u00f9\u0005\u0010\u0000"+
		"\u0000\u00f9\u00fa\u0005\u001f\u0000\u0000\u00fa\u00fc\u0005-\u0000\u0000"+
		"\u00fb\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u0100\u0005&\u0000\u0000\u00fe"+
		"\u00ff\u0005\u001f\u0000\u0000\u00ff\u0101\u0005\u0010\u0000\u0000\u0100"+
		"\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101"+
		"\u0105\u0001\u0000\u0000\u0000\u0102\u0104\u0003\u0002\u0001\u0000\u0103"+
		"\u0102\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105"+
		"\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106"+
		"\u0108\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108"+
		"\u0109\u0005\'\u0000\u0000\u0109\u010a\u0005\u0006\u0000\u0000\u010a/"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0005-\u0000\u0000\u010c\u010d\u0005"+
		"\u0011\u0000\u0000\u010d\u010f\u0005-\u0000\u0000\u010e\u0110\u0003\u0010"+
		"\b\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000"+
		"\u0000\u01101\u0001\u0000\u0000\u0000\u001d5DLTVbix{\u0085\u0088\u0091"+
		"\u0095\u0099\u00a0\u00a7\u00aa\u00b2\u00b6\u00bc\u00c5\u00ca\u00dd\u00e3"+
		"\u00ea\u00fb\u0100\u0105\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}