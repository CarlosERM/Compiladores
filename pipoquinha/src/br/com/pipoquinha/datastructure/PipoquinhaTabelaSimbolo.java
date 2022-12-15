package br.com.pipoquinha.datastructure;

import java.util.ArrayList;
import java.util.HashMap;

public class PipoquinhaTabelaSimbolo {
    private HashMap<String, PipoquinhaSimbolo> map;

    public PipoquinhaTabelaSimbolo() {
        map = new HashMap<String, PipoquinhaSimbolo>();
    }
    public void adicionar(PipoquinhaSimbolo simbolo) {
        map.put(simbolo.getNome(), simbolo);
    }
    public boolean existe(String nomeSimbolo) {
        return map.get(nomeSimbolo) != null;
    }
    public PipoquinhaSimbolo pegar(String nomeSimbolo) {
        return map.get(nomeSimbolo);
    }

    public ArrayList<PipoquinhaSimbolo> pegarTodosSimbolos() {
        ArrayList<PipoquinhaSimbolo> lista = new ArrayList<PipoquinhaSimbolo>();
        for (PipoquinhaSimbolo simbolo : map.values()) {
            lista.add(simbolo);
        }
        return lista;
    }
}
