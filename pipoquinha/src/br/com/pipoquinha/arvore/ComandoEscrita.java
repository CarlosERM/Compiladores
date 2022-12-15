package br.com.pipoquinha.arvore;

public class ComandoEscrita extends ComandoAbstrato {
    private String id;

    public ComandoEscrita(String id) {
        this.id = id;
    }
    @Override
    public String gerarCodigoJava() {

        return "System.out.println(" + id + ");";
    }
    @Override
    public String toString() {
        return "ComandoEscrita [id=" + id + "]";
    }
    
}
