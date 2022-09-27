package MeuAnalisadorSemantico;

import javax.swing.JFileChooser;


public class Main {
    public static void main(String[] args) {
        String caminho = "";
        JFileChooser escolheArquivo = new JFileChooser();
        int retorno = escolheArquivo.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION) {
            caminho = escolheArquivo.getSelectedFile().getAbsolutePath();
            System.out.println(caminho);
        }
        MeuAnalisador ent = new MeuAnalisador(caminho);
        Token t = null;
        while ((t = ent.proximoToken()) != null) {
            System.out.println(t);
        }
    }
}
