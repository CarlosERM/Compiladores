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

 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class pipoquinhaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, VIRGULA=9, 
		AbreParenteses=10, FechaParenteses=11, AbreChaves=12, FechaChaves=13, 
		PontoVirgula=14, Operador=15, Atribuicao=16, ID=17, OPERADORRELACIONAL=18, 
		NUMERO=19, EspacoBranco=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "VIRGULA", 
			"AbreParenteses", "FechaParenteses", "AbreChaves", "FechaChaves", "PontoVirgula", 
			"Operador", "Atribuicao", "ID", "OPERADORRELACIONAL", "NUMERO", "EspacoBranco"
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


	public pipoquinhaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "pipoquinha.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00b6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\7\22\u0096\n\22\f"+
		"\22\16\22\u0099\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00a4\n\23\3\24\6\24\u00a7\n\24\r\24\16\24\u00a8\3\24\3\24\6\24\u00ad"+
		"\n\24\r\24\16\24\u00ae\5\24\u00b1\n\24\3\25\3\25\3\25\3\25\2\2\26\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26\3\2\b\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\4\2>>@@\3"+
		"\2\62;\5\2\13\f\17\17\"\"\2\u00bd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\3+\3\2\2\2\5\62\3\2\2\2\7<\3\2\2\2\tI\3\2\2\2\13U\3\2\2\2\r`\3\2\2"+
		"\2\17n\3\2\2\2\21w\3\2\2\2\23\u0083\3\2\2\2\25\u0085\3\2\2\2\27\u0087"+
		"\3\2\2\2\31\u0089\3\2\2\2\33\u008b\3\2\2\2\35\u008d\3\2\2\2\37\u008f\3"+
		"\2\2\2!\u0091\3\2\2\2#\u0093\3\2\2\2%\u00a3\3\2\2\2\'\u00a6\3\2\2\2)\u00b2"+
		"\3\2\2\2+,\7r\2\2,-\7k\2\2-.\7r\2\2./\7q\2\2/\60\7e\2\2\60\61\7c\2\2\61"+
		"\4\3\2\2\2\62\63\7h\2\2\63\64\7k\2\2\64\65\7o\2\2\65\66\7r\2\2\66\67\7"+
		"k\2\2\678\7r\2\289\7q\2\29:\7e\2\2:;\7c\2\2;\6\3\2\2\2<=\7p\2\2=>\7w\2"+
		"\2>?\7o\2\2?@\7g\2\2@A\7t\2\2AB\7q\2\2BC\7R\2\2CD\7k\2\2DE\7r\2\2EF\7"+
		"q\2\2FG\7e\2\2GH\7c\2\2H\b\3\2\2\2IJ\7v\2\2JK\7g\2\2KL\7z\2\2LM\7v\2\2"+
		"MN\7q\2\2NO\7R\2\2OP\7k\2\2PQ\7r\2\2QR\7q\2\2RS\7e\2\2ST\7c\2\2T\n\3\2"+
		"\2\2UV\7n\2\2VW\7g\2\2WX\7k\2\2XY\7c\2\2YZ\7R\2\2Z[\7k\2\2[\\\7r\2\2\\"+
		"]\7q\2\2]^\7e\2\2^_\7c\2\2_\f\3\2\2\2`a\7g\2\2ab\7u\2\2bc\7e\2\2cd\7t"+
		"\2\2de\7g\2\2ef\7x\2\2fg\7c\2\2gh\7R\2\2hi\7k\2\2ij\7r\2\2jk\7q\2\2kl"+
		"\7e\2\2lm\7c\2\2m\16\3\2\2\2no\7u\2\2op\7g\2\2pq\7R\2\2qr\7k\2\2rs\7r"+
		"\2\2st\7q\2\2tu\7e\2\2uv\7c\2\2v\20\3\2\2\2wx\7u\2\2xy\7g\2\2yz\7p\2\2"+
		"z{\7c\2\2{|\7q\2\2|}\7R\2\2}~\7k\2\2~\177\7r\2\2\177\u0080\7q\2\2\u0080"+
		"\u0081\7e\2\2\u0081\u0082\7c\2\2\u0082\22\3\2\2\2\u0083\u0084\7.\2\2\u0084"+
		"\24\3\2\2\2\u0085\u0086\7*\2\2\u0086\26\3\2\2\2\u0087\u0088\7+\2\2\u0088"+
		"\30\3\2\2\2\u0089\u008a\7}\2\2\u008a\32\3\2\2\2\u008b\u008c\7\177\2\2"+
		"\u008c\34\3\2\2\2\u008d\u008e\7=\2\2\u008e\36\3\2\2\2\u008f\u0090\t\2"+
		"\2\2\u0090 \3\2\2\2\u0091\u0092\7?\2\2\u0092\"\3\2\2\2\u0093\u0097\t\3"+
		"\2\2\u0094\u0096\t\4\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098$\3\2\2\2\u0099\u0097\3\2\2\2"+
		"\u009a\u00a4\t\5\2\2\u009b\u009c\7@\2\2\u009c\u00a4\7?\2\2\u009d\u009e"+
		"\7>\2\2\u009e\u00a4\7?\2\2\u009f\u00a0\7?\2\2\u00a0\u00a4\7?\2\2\u00a1"+
		"\u00a2\7#\2\2\u00a2\u00a4\7?\2\2\u00a3\u009a\3\2\2\2\u00a3\u009b\3\2\2"+
		"\2\u00a3\u009d\3\2\2\2\u00a3\u009f\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4&"+
		"\3\2\2\2\u00a5\u00a7\t\6\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00b0\3\2\2\2\u00aa\u00ac\7\60"+
		"\2\2\u00ab\u00ad\t\6\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00aa\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1(\3\2\2\2\u00b2\u00b3\t\7\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b5\b\25\2\2\u00b5*\3\2\2\2\t\2\u0095\u0097\u00a3\u00a8"+
		"\u00ae\u00b0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}