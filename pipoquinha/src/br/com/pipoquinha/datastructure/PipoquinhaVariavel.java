package br.com.pipoquinha.datastructure;

public class PipoquinhaVariavel extends PipoquinhaSimbolo {
    public static final int NUMERO = 0;
    public static final int TEXTO = 1;
    private int tipo;
    private String valor;

    public PipoquinhaVariavel(String nome, int tipo, String valor) {
        super(nome);
        this.tipo = tipo;
        this.valor = valor;
    }
    public String gerarCodigoJava() {
        String str;
        if(tipo == NUMERO) {
            str = "double ";
        } else {
            str = "String ";
        }
        return str + " " + super.nome + ';';
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PipoquinhaVariavel [nome= " + nome + ", tipo=" + tipo + ", valor=" + valor + "]";
    }


    
}
