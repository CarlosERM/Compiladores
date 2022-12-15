package br.com.pipoquinha.arvore;

import br.com.pipoquinha.datastructure.PipoquinhaSimbolo;
import br.com.pipoquinha.datastructure.PipoquinhaVariavel;

public class ComandoLeitura extends ComandoAbstrato {
    private String id;
    private PipoquinhaVariavel var;
    public ComandoLeitura(String id, PipoquinhaVariavel var) {
        this.id = id;
        this.var = var;
    }
    @Override
    public String gerarCodigoJava() {
        // TODO Auto-generated method stub
        return id + "= _key." + (var.getTipo() == PipoquinhaVariavel.NUMERO ? "nextDouble();" : "nextLine();");
    }
    @Override
    public String toString() {
        return "ComandoLeitura [id=" + id + "]";
    }
    
}
