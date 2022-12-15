package br.com.pipoquinha.arvore;

import br.com.pipoquinha.datastructure.PipoquinhaSimbolo;

public class ComandoAtribuicao extends ComandoAbstrato {
    private String id;
    private String expressao;

    public ComandoAtribuicao(String id, String expressao) {
        this.id = id;
        this.expressao = expressao;

    }
  
    @Override
    public String gerarCodigoJava() {
        // TODO Auto-generated method stub
        return id + " = " + expressao + ";";
    }
    @Override
    public String toString() {
        return "ComandoAtribuicao [id=" + id + ", expressao=" + expressao + "]";
    }
}
