package br.com.pipoquinha.arvore;

import java.util.ArrayList;

public class ComandoDecisao extends ComandoAbstrato{

    private String condicao;
    private ArrayList<ComandoAbstrato> listaVerdadeira;
    private ArrayList<ComandoAbstrato> listaFalsa;

    public ComandoDecisao(String condicao, ArrayList<ComandoAbstrato> listaVerdadeira,
            ArrayList<ComandoAbstrato> listaFalsa) {
        this.condicao = condicao;
        this.listaVerdadeira = listaVerdadeira;
        this.listaFalsa = listaFalsa;
    }

    @Override
    public String gerarCodigoJava() {
        // TODO Auto-generated method stub
        StringBuilder str = new StringBuilder();
        str.append("if (" + condicao + ") {\n");
        for(ComandoAbstrato comando: listaVerdadeira) {
            str.append(comando.gerarCodigoJava());
        }
        str.append("}\n");
        if(listaFalsa.size() > 0) {
            str.append("else {\n");
            for(ComandoAbstrato comando: listaFalsa) {
                str.append(comando.gerarCodigoJava());
            }
            str.append("}\n");
        }
        return str.toString();
    }
    
    @Override
    public String toString() {
        return "ComandoDecisao [condicao=" + condicao + ", listaVerdadeira=" + listaVerdadeira + ", listaFalsa="
                + listaFalsa + "]";
    }
}
