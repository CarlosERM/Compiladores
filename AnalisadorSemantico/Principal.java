package AnalisadorSemantico;

import javax.swing.JFileChooser;
// Exercício
// a - Elabore um breve vocabulário para uma linguagem de sua criação.
// É importante conter as seguintes especificações mínimas: 
//  Atributos lógicos.
//  Condicionais
//  Repetição
//  Variáveis
// b - Apresente um breve pseudocódigo correspondente ao seu vocabulário.
// c - Gere os padrões e identifique os tokens.
// d - Construa um analisador léxico para validar a questão c;
public class Principal {
    public static void main(String[] args) {
        String caminho = "";
        JFileChooser fc = new JFileChooser();
        int retorno = fc.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION) {
            caminho = fc.getSelectedFile().getAbsolutePath();
            System.out.println(caminho);
        }
        Analisador ent = new Analisador(caminho);
        Token t = null;
        while ((t = ent.proximoToken()) != null) {
            System.out.println(t);
        }
    }
}
