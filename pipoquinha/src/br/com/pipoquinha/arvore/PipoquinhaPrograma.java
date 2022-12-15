package br.com.pipoquinha.arvore;

import java.io.FileWriter;
import java.util.ArrayList;

import br.com.pipoquinha.datastructure.PipoquinhaSimbolo;
import br.com.pipoquinha.datastructure.PipoquinhaTabelaSimbolo;

public class PipoquinhaPrograma {
    private PipoquinhaTabelaSimbolo varTable;
    private ArrayList<ComandoAbstrato> comandos;
    private String nomePrograma;

    public void gerarTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass{\n");
        str.append("public static void main(String args[]){\n");
        str.append("        Scanner _key = new Scanner(System.in);\n");
        for(PipoquinhaSimbolo simbolo : varTable.pegarTodosSimbolos()) {
            str.append(simbolo.gerarCodigoJava() + "\n");
        }

        for(ComandoAbstrato comando: comandos) {
            str.append(comando.gerarCodigoJava() + "\n");
        }
        str.append("    }\n");
        str.append("}\n");

        try {
            FileWriter fr = new FileWriter("MainClass.java");
            fr.write(str.toString());
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    public ArrayList<ComandoAbstrato> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<ComandoAbstrato> comandos) {
        this.comandos = comandos;
    }

    public String getNomePrograma() {
        return nomePrograma;
    }

    public void setNomePrograma(String nomePrograma) {
        this.nomePrograma = nomePrograma;
    }


    public PipoquinhaTabelaSimbolo getVarTable() {
        return varTable;
    }


    public void setVarTable(PipoquinhaTabelaSimbolo varTable) {
        this.varTable = varTable;
    }
  
}
