grammar pipoquinha;

@header {
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

 }

@members {
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
}

// Sintática: letra minúscula.
// Léxica: Letra Maiúscula.

pipoca  :  'pipoca' declaracao corpo 'fimpipoca'
        {       programa.setVarTable(tabelaSimbolo);
                programa.setComandos(todosComandos.pop());
        }
        ;
declaracao : (declaracaovariavel)+
        ;
declaracaovariavel: tipo ID {
        _varNome = _input.LT(-1).getText();
        _varValue = null;
        simbolo = new PipoquinhaVariavel(_varNome, _tipo, _varValue);
        System.out.println("Símbolo adicionado " + simbolo);
        if(!tabelaSimbolo.existe(_varNome)) {
            tabelaSimbolo.adicionar(simbolo);
        } else { 
            throw new ExcecaoSemanticaPipoquinha("O Símbolo " + _varNome + " já foi declarado."); 
        }
} (VIRGULA ID {
        _varNome = _input.LT(-1).getText();
        _varValue = null;
        simbolo = new PipoquinhaVariavel(_varNome, _tipo, _varValue);
        System.out.println("Símbolo adicionado " + simbolo);
        if(!tabelaSimbolo.existe(_varNome)) {
            tabelaSimbolo.adicionar(simbolo);
        } else { 
            throw new ExcecaoSemanticaPipoquinha("O Símbolo " + _varNome + " já foi declarado."); 
        }
} )* PontoVirgula
        ;
tipo    : 'numeroPipoca' {_tipo = PipoquinhaVariavel.NUMERO;} | 'textoPipoca' {_tipo = PipoquinhaVariavel.TEXTO;}
        ; 
corpo   : { threadAtual = new ArrayList<ComandoAbstrato>();
            todosComandos.push(threadAtual);
          }
        (ordem)+
        ;

ordem   : ordemLer | ordemEscrever | ordemAtribuir | ordemSelecao
        ;
ordemLer: 'leiaPipoca' 
            AbreParenteses
            ID {
                verificaID(_input.LT(-1).getText());
                _readID = _input.LT(-1).getText();
                }
            FechaParenteses
            PontoVirgula
            {
                PipoquinhaVariavel var = (PipoquinhaVariavel) tabelaSimbolo.pegar(_readID);

                ComandoLeitura comando = new ComandoLeitura(_readID, var);
                todosComandos.peek().add(comando);
            }
        ;
ordemEscrever: 'escrevaPipoca' 
            AbreParenteses
            ID {
                verificaID(_input.LT(-1).getText());
                _writeID = _input.LT(-1).getText();
                }
            FechaParenteses 
            PontoVirgula
            {
                ComandoEscrita comando = new ComandoEscrita(_writeID);
                todosComandos.peek().add(comando);
            }        
                ;
ordemAtribuir: ID{
        verificaID(_input.LT(-1).getText());
                _expressaoID = _input.LT(-1).getText(); 
        
        } Atribuicao {_expressaoConteudo = "";}
         expressao PontoVirgula
         { 
                ComandoAtribuicao comando = new ComandoAtribuicao(_expressaoID, _expressaoConteudo); 
                todosComandos.peek().add(comando);
         }
        ;
ordemSelecao: 'sePipoca' AbreParenteses
                ID {
                        _expressaoDecisao = _input.LT(-1).getText();
                }
                OPERADORRELACIONAL{
                        _expressaoDecisao += _input.LT(-1).getText();
                }
                (ID | NUMERO) {
                        _expressaoDecisao += _input.LT(-1).getText();
                }
                FechaParenteses
                AbreChaves
                {
                        threadAtual = new ArrayList<ComandoAbstrato>();
                        todosComandos.push(threadAtual);
                }
                (ordem)+ 
                FechaChaves {
                      listaVerdadeira = todosComandos.pop();  
                }
                ('senaoPipoca' 
                AbreChaves {
                      threadAtual = new ArrayList<ComandoAbstrato>(); 
                        todosComandos.push(threadAtual);
                }
                (ordem)+  
                FechaChaves {
                        listaFalsa = todosComandos.pop();
                        ComandoDecisao comando= new ComandoDecisao(_expressaoDecisao, listaVerdadeira, listaFalsa);
                        todosComandos.peek().add(comando);
                }
                )?
        ;
VIRGULA : ','
        ;
expressao    : termo ( Operador {
                _expressaoConteudo += _input.LT(-1).getText();
} termo )* // Ela tem um termo e 0 ou mais repetições de operador e termo.
        ; 
termo   : ID{
                verificaID(_input.LT(-1).getText());
                _expressaoConteudo += _input.LT(-1).getText();
        } 
        | 
        NUMERO {
                _expressaoConteudo += _input.LT(-1).getText();
        }
        ;

AbreParenteses: '('
        ;
FechaParenteses: ')'
        ;
AbreChaves: '{'
        ;
FechaChaves: '}'
        ;
PontoVirgula: ';'
        ;
Operador: '+' | '-' | '*' | '/'
        ;
Atribuicao: '='
        ;
ID      :   [a-z] ([a-z] | [A-Z] | [0-9])*
        ;
OPERADORRELACIONAL: '>' | '<' | '>=' | '<=' | '==' | '!='
        ;
NUMERO  : [0-9]+ ('.' [0-9]+)?
        ;
EspacoBranco: ( ' ' | '\t' | '\n' | '\r' ) -> skip
        ;