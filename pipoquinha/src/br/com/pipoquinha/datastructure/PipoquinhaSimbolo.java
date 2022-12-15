package br.com.pipoquinha.datastructure;

public abstract class PipoquinhaSimbolo {
    protected String nome;
    public PipoquinhaSimbolo(String nome) {
        this.nome = nome;
    }
    public abstract String gerarCodigoJava();
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PipoquinhaSimbolo [nome=" + nome + "]";
    }

    
}
