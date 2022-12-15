package br.com.pipoquinha.parser;
// Generated from c:\Users\carlo\OneDrive\�rea de Trabalho\Embri�o\pipoquinha\pipoquinha.g4 by ANTLR 4.9.2

    import  br.com.pipoquinha.datastructure.PipoquinhaSimbolo;
    import  br.com.pipoquinha.datastructure.PipoquinhaTabelaSimbolo;
    import  br.com.pipoquinha.datastructure.PipoquinhaVariavel;
    import  br.com.pipoquinha.exceptions.ExcecaoSemanticaPipoquinha;
    import  br.com.pipoquinha.arvore.PipoquinhaPrograma;
    import  br.com.pipoquinha.arvore.ComandoAbstrato;
    import  br.com.pipoquinha.arvore.ComandoLeitura;
    import  br.com.pipoquinha.arvore.ComandoEscrita;
    import  br.com.pipoquinha.arvore.ComandoAtribuicao;
    import  br.com.pipoquinha.arvore.ComandoDecisao;

    import java.util.ArrayList;
    import java.util.Stack;

 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class pipoquinhaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, VIRGULA=9, 
		AbreParenteses=10, FechaParenteses=11, AbreChaves=12, FechaChaves=13, 
		PontoVirgula=14, Operador=15, Atribuicao=16, ID=17, OPERADORRELACIONAL=18, 
		NUMERO=19, EspacoBranco=20;
	public static final int
		RULE_pipoca = 0, RULE_declaracao = 1, RULE_declaracaovariavel = 2, RULE_tipo = 3, 
		RULE_corpo = 4, RULE_ordem = 5, RULE_ordemLer = 6, RULE_ordemEscrever = 7, 
		RULE_ordemAtribuir = 8, RULE_ordemSelecao = 9, RULE_expressao = 10, RULE_termo = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"pipoca", "declaracao", "declaracaovariavel", "tipo", "corpo", "ordem", 
			"ordemLer", "ordemEscrever", "ordemAtribuir", "ordemSelecao", "expressao", 
			"termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pipoca'", "'fimpipoca'", "'numeroPipoca'", "'textoPipoca'", "'leiaPipoca'", 
			"'escrevaPipoca'", "'sePipoca'", "'senaoPipoca'", "','", "'('", "')'", 
			"'{'", "'}'", "';'", null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "VIRGULA", "AbreParenteses", 
			"FechaParenteses", "AbreChaves", "FechaChaves", "PontoVirgula", "Operador", 
			"Atribuicao", "ID", "OPERADORRELACIONAL", "NUMERO", "EspacoBranco"
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
	public String getGrammarFileName() { return "pipoquinha.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int _tipo;
	    private String _varNome;
	    private String _varValue;
	    private PipoquinhaTabelaSimbolo tabelaSimbolo = new PipoquinhaTabelaSimbolo();
	    private PipoquinhaSimbolo simbolo;
	    private PipoquinhaPrograma programa = new PipoquinhaPrograma();
	    private ArrayList<ComandoAbstrato> threadAtual;

	    private Stack<ArrayList<ComandoAbstrato>> todosComandos = new Stack<ArrayList<ComandoAbstrato>>();
	    private String _readID;
	    private String _writeID;
	    private String _expressaoID;
	    private String _expressaoConteudo;
	    private String _expressaoDecisao;

	    private ArrayList<ComandoAbstrato> listaVerdadeira;
	    private ArrayList<ComandoAbstrato> listaFalsa;


	    public void verificaID(String id) {
	        if(!tabelaSimbolo.existe(id)) {
	            throw new ExcecaoSemanticaPipoquinha("O Símbolo " + id + " não foi declarado."); 
	         }
	     }

	     public void exibirComandos() {
	        for(ComandoAbstrato c: programa.getComandos()) {
	                System.out.println(c);
	         }
	     }
	     public void gerarCodigo() {
	        programa.gerarTarget();
	     }

	public pipoquinhaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PipocaContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public PipocaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipoca; }
	}

	public final PipocaContext pipoca() throws RecognitionException {
		PipocaContext _localctx = new PipocaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pipoca);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			declaracao();
			setState(26);
			corpo();
			setState(27);
			match(T__1);
			       programa.setVarTable(tabelaSimbolo);
			                programa.setComandos(todosComandos.pop());
			        
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

	public static class DeclaracaoContext extends ParserRuleContext {
		public List<DeclaracaovariavelContext> declaracaovariavel() {
			return getRuleContexts(DeclaracaovariavelContext.class);
		}
		public DeclaracaovariavelContext declaracaovariavel(int i) {
			return getRuleContext(DeclaracaovariavelContext.class,i);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				declaracaovariavel();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
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

	public static class DeclaracaovariavelContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(pipoquinhaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(pipoquinhaParser.ID, i);
		}
		public TerminalNode PontoVirgula() { return getToken(pipoquinhaParser.PontoVirgula, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(pipoquinhaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(pipoquinhaParser.VIRGULA, i);
		}
		public DeclaracaovariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaovariavel; }
	}

	public final DeclaracaovariavelContext declaracaovariavel() throws RecognitionException {
		DeclaracaovariavelContext _localctx = new DeclaracaovariavelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracaovariavel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			tipo();
			setState(36);
			match(ID);

			        _varNome = _input.LT(-1).getText();
			        _varValue = null;
			        simbolo = new PipoquinhaVariavel(_varNome, _tipo, _varValue);
			        System.out.println("Símbolo adicionado " + simbolo);
			        if(!tabelaSimbolo.existe(_varNome)) {
			            tabelaSimbolo.adicionar(simbolo);
			        } else { 
			            throw new ExcecaoSemanticaPipoquinha("O Símbolo " + _varNome + " já foi declarado."); 
			        }

			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(38);
				match(VIRGULA);
				setState(39);
				match(ID);

				        _varNome = _input.LT(-1).getText();
				        _varValue = null;
				        simbolo = new PipoquinhaVariavel(_varNome, _tipo, _varValue);
				        System.out.println("Símbolo adicionado " + simbolo);
				        if(!tabelaSimbolo.existe(_varNome)) {
				            tabelaSimbolo.adicionar(simbolo);
				        } else { 
				            throw new ExcecaoSemanticaPipoquinha("O Símbolo " + _varNome + " já foi declarado."); 
				        }

				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(PontoVirgula);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(T__2);
				_tipo = PipoquinhaVariavel.NUMERO;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(T__3);
				_tipo = PipoquinhaVariavel.TEXTO;
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

	public static class CorpoContext extends ParserRuleContext {
		public List<OrdemContext> ordem() {
			return getRuleContexts(OrdemContext.class);
		}
		public OrdemContext ordem(int i) {
			return getRuleContext(OrdemContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 threadAtual = new ArrayList<ComandoAbstrato>();
			            todosComandos.push(threadAtual);
			          
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				ordem();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
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

	public static class OrdemContext extends ParserRuleContext {
		public OrdemLerContext ordemLer() {
			return getRuleContext(OrdemLerContext.class,0);
		}
		public OrdemEscreverContext ordemEscrever() {
			return getRuleContext(OrdemEscreverContext.class,0);
		}
		public OrdemAtribuirContext ordemAtribuir() {
			return getRuleContext(OrdemAtribuirContext.class,0);
		}
		public OrdemSelecaoContext ordemSelecao() {
			return getRuleContext(OrdemSelecaoContext.class,0);
		}
		public OrdemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordem; }
	}

	public final OrdemContext ordem() throws RecognitionException {
		OrdemContext _localctx = new OrdemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ordem);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				ordemLer();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				ordemEscrever();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				ordemAtribuir();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				ordemSelecao();
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

	public static class OrdemLerContext extends ParserRuleContext {
		public TerminalNode AbreParenteses() { return getToken(pipoquinhaParser.AbreParenteses, 0); }
		public TerminalNode ID() { return getToken(pipoquinhaParser.ID, 0); }
		public TerminalNode FechaParenteses() { return getToken(pipoquinhaParser.FechaParenteses, 0); }
		public TerminalNode PontoVirgula() { return getToken(pipoquinhaParser.PontoVirgula, 0); }
		public OrdemLerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordemLer; }
	}

	public final OrdemLerContext ordemLer() throws RecognitionException {
		OrdemLerContext _localctx = new OrdemLerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ordemLer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__4);
			setState(67);
			match(AbreParenteses);
			setState(68);
			match(ID);

			                verificaID(_input.LT(-1).getText());
			                _readID = _input.LT(-1).getText();
			                
			setState(70);
			match(FechaParenteses);
			setState(71);
			match(PontoVirgula);

			                PipoquinhaVariavel var = (PipoquinhaVariavel) tabelaSimbolo.pegar(_readID);

			                ComandoLeitura comando = new ComandoLeitura(_readID, var);
			                todosComandos.peek().add(comando);
			            
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

	public static class OrdemEscreverContext extends ParserRuleContext {
		public TerminalNode AbreParenteses() { return getToken(pipoquinhaParser.AbreParenteses, 0); }
		public TerminalNode ID() { return getToken(pipoquinhaParser.ID, 0); }
		public TerminalNode FechaParenteses() { return getToken(pipoquinhaParser.FechaParenteses, 0); }
		public TerminalNode PontoVirgula() { return getToken(pipoquinhaParser.PontoVirgula, 0); }
		public OrdemEscreverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordemEscrever; }
	}

	public final OrdemEscreverContext ordemEscrever() throws RecognitionException {
		OrdemEscreverContext _localctx = new OrdemEscreverContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ordemEscrever);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__5);
			setState(75);
			match(AbreParenteses);
			setState(76);
			match(ID);

			                verificaID(_input.LT(-1).getText());
			                _writeID = _input.LT(-1).getText();
			                
			setState(78);
			match(FechaParenteses);
			setState(79);
			match(PontoVirgula);

			                ComandoEscrita comando = new ComandoEscrita(_writeID);
			                todosComandos.peek().add(comando);
			            
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

	public static class OrdemAtribuirContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(pipoquinhaParser.ID, 0); }
		public TerminalNode Atribuicao() { return getToken(pipoquinhaParser.Atribuicao, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PontoVirgula() { return getToken(pipoquinhaParser.PontoVirgula, 0); }
		public OrdemAtribuirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordemAtribuir; }
	}

	public final OrdemAtribuirContext ordemAtribuir() throws RecognitionException {
		OrdemAtribuirContext _localctx = new OrdemAtribuirContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ordemAtribuir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);

			        verificaID(_input.LT(-1).getText());
			                _expressaoID = _input.LT(-1).getText(); 
			        
			        
			setState(84);
			match(Atribuicao);
			_expressaoConteudo = "";
			setState(86);
			expressao();
			setState(87);
			match(PontoVirgula);
			 
			                ComandoAtribuicao comando = new ComandoAtribuicao(_expressaoID, _expressaoConteudo); 
			                todosComandos.peek().add(comando);
			         
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

	public static class OrdemSelecaoContext extends ParserRuleContext {
		public TerminalNode AbreParenteses() { return getToken(pipoquinhaParser.AbreParenteses, 0); }
		public List<TerminalNode> ID() { return getTokens(pipoquinhaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(pipoquinhaParser.ID, i);
		}
		public TerminalNode OPERADORRELACIONAL() { return getToken(pipoquinhaParser.OPERADORRELACIONAL, 0); }
		public TerminalNode FechaParenteses() { return getToken(pipoquinhaParser.FechaParenteses, 0); }
		public List<TerminalNode> AbreChaves() { return getTokens(pipoquinhaParser.AbreChaves); }
		public TerminalNode AbreChaves(int i) {
			return getToken(pipoquinhaParser.AbreChaves, i);
		}
		public List<TerminalNode> FechaChaves() { return getTokens(pipoquinhaParser.FechaChaves); }
		public TerminalNode FechaChaves(int i) {
			return getToken(pipoquinhaParser.FechaChaves, i);
		}
		public TerminalNode NUMERO() { return getToken(pipoquinhaParser.NUMERO, 0); }
		public List<OrdemContext> ordem() {
			return getRuleContexts(OrdemContext.class);
		}
		public OrdemContext ordem(int i) {
			return getRuleContext(OrdemContext.class,i);
		}
		public OrdemSelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordemSelecao; }
	}

	public final OrdemSelecaoContext ordemSelecao() throws RecognitionException {
		OrdemSelecaoContext _localctx = new OrdemSelecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ordemSelecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__6);
			setState(91);
			match(AbreParenteses);
			setState(92);
			match(ID);

			                        _expressaoDecisao = _input.LT(-1).getText();
			                
			setState(94);
			match(OPERADORRELACIONAL);

			                        _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(96);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMERO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			                        _expressaoDecisao += _input.LT(-1).getText();
			                
			setState(98);
			match(FechaParenteses);
			setState(99);
			match(AbreChaves);

			                        threadAtual = new ArrayList<ComandoAbstrato>();
			                        todosComandos.push(threadAtual);
			                
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				ordem();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
			setState(106);
			match(FechaChaves);

			                      listaVerdadeira = todosComandos.pop();  
			                
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(108);
				match(T__7);
				setState(109);
				match(AbreChaves);

				                      threadAtual = new ArrayList<ComandoAbstrato>(); 
				                        todosComandos.push(threadAtual);
				                
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(111);
					ordem();
					}
					}
					setState(114); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
				setState(116);
				match(FechaChaves);

				                        listaFalsa = todosComandos.pop();
				                        ComandoDecisao comando= new ComandoDecisao(_expressaoDecisao, listaVerdadeira, listaFalsa);
				                        todosComandos.peek().add(comando);
				                
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

	public static class ExpressaoContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> Operador() { return getTokens(pipoquinhaParser.Operador); }
		public TerminalNode Operador(int i) {
			return getToken(pipoquinhaParser.Operador, i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			termo();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operador) {
				{
				{
				setState(122);
				match(Operador);

				                _expressaoConteudo += _input.LT(-1).getText();

				setState(124);
				termo();
				}
				}
				setState(129);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(pipoquinhaParser.ID, 0); }
		public TerminalNode NUMERO() { return getToken(pipoquinhaParser.NUMERO, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(ID);

				                verificaID(_input.LT(-1).getText());
				                _expressaoConteudo += _input.LT(-1).getText();
				        
				}
				break;
			case NUMERO:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(NUMERO);

				                _expressaoConteudo += _input.LT(-1).getText();
				        
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\"\n\3\r\3\16\3#"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\5\5\67\n\5\3\6\3\6\6\6;\n\6\r\6\16\6<\3\7\3\7\3\7\3\7\5\7C\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\6\13i\n\13\r\13\16\13j\3\13\3\13\3\13\3\13\3\13\3\13\6\13"+
		"s\n\13\r\13\16\13t\3\13\3\13\3\13\5\13z\n\13\3\f\3\f\3\f\3\f\7\f\u0080"+
		"\n\f\f\f\16\f\u0083\13\f\3\r\3\r\3\r\3\r\5\r\u0089\n\r\3\r\2\2\16\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\2\3\4\2\23\23\25\25\2\u008a\2\32\3\2\2\2\4"+
		"!\3\2\2\2\6%\3\2\2\2\b\66\3\2\2\2\n8\3\2\2\2\fB\3\2\2\2\16D\3\2\2\2\20"+
		"L\3\2\2\2\22T\3\2\2\2\24\\\3\2\2\2\26{\3\2\2\2\30\u0088\3\2\2\2\32\33"+
		"\7\3\2\2\33\34\5\4\3\2\34\35\5\n\6\2\35\36\7\4\2\2\36\37\b\2\1\2\37\3"+
		"\3\2\2\2 \"\5\6\4\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2"+
		"\2%&\5\b\5\2&\'\7\23\2\2\'-\b\4\1\2()\7\13\2\2)*\7\23\2\2*,\b\4\1\2+("+
		"\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\20"+
		"\2\2\61\7\3\2\2\2\62\63\7\5\2\2\63\67\b\5\1\2\64\65\7\6\2\2\65\67\b\5"+
		"\1\2\66\62\3\2\2\2\66\64\3\2\2\2\67\t\3\2\2\28:\b\6\1\29;\5\f\7\2:9\3"+
		"\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\13\3\2\2\2>C\5\16\b\2?C\5\20\t\2"+
		"@C\5\22\n\2AC\5\24\13\2B>\3\2\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\r\3\2"+
		"\2\2DE\7\7\2\2EF\7\f\2\2FG\7\23\2\2GH\b\b\1\2HI\7\r\2\2IJ\7\20\2\2JK\b"+
		"\b\1\2K\17\3\2\2\2LM\7\b\2\2MN\7\f\2\2NO\7\23\2\2OP\b\t\1\2PQ\7\r\2\2"+
		"QR\7\20\2\2RS\b\t\1\2S\21\3\2\2\2TU\7\23\2\2UV\b\n\1\2VW\7\22\2\2WX\b"+
		"\n\1\2XY\5\26\f\2YZ\7\20\2\2Z[\b\n\1\2[\23\3\2\2\2\\]\7\t\2\2]^\7\f\2"+
		"\2^_\7\23\2\2_`\b\13\1\2`a\7\24\2\2ab\b\13\1\2bc\t\2\2\2cd\b\13\1\2de"+
		"\7\r\2\2ef\7\16\2\2fh\b\13\1\2gi\5\f\7\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2"+
		"jk\3\2\2\2kl\3\2\2\2lm\7\17\2\2my\b\13\1\2no\7\n\2\2op\7\16\2\2pr\b\13"+
		"\1\2qs\5\f\7\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\17"+
		"\2\2wx\b\13\1\2xz\3\2\2\2yn\3\2\2\2yz\3\2\2\2z\25\3\2\2\2{\u0081\5\30"+
		"\r\2|}\7\21\2\2}~\b\f\1\2~\u0080\5\30\r\2\177|\3\2\2\2\u0080\u0083\3\2"+
		"\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\27\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\7\23\2\2\u0085\u0089\b\r\1\2\u0086\u0087\7\25\2\2"+
		"\u0087\u0089\b\r\1\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089\31"+
		"\3\2\2\2\f#-\66<Bjty\u0081\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}