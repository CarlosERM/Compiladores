package br.com.pipoquinha.main;
// Essa é a classe que é responsável por criar 
// a interação com o usuário instanciando o parser
// e apontando para o arquivo fonte.

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import br.com.pipoquinha.exceptions.ExcecaoSemanticaPipoquinha;
import br.com.pipoquinha.parser.pipoquinhaLexer;
import br.com.pipoquinha.parser.pipoquinhaParser;

// Arquivo fonte: extensão .pip
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            pipoquinhaLexer analisadorLexico;
            pipoquinhaParser analisadorSintatico;

            // A entrada do analisador léxico é o arquivo input.pip.
            analisadorLexico = new pipoquinhaLexer(CharStreams.fromFileName("input.pip"));

            // Aqui se cria o fluxo de tokens que vão passar para o parser.
            CommonTokenStream tokenStream = new CommonTokenStream(analisadorLexico);

            // O parser é criado a partir do tokenStream.
            analisadorSintatico = new pipoquinhaParser(tokenStream);

            analisadorSintatico.pipoca();
            System.out.println("A compilação foi um sucesso.");
            analisadorSintatico.exibirComandos();
            analisadorSintatico.gerarCodigo();

        } catch(ExcecaoSemanticaPipoquinha ex) {
            System.err.println("Erro Semântico. " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro. " + ex.getMessage());

        }
    }
}
