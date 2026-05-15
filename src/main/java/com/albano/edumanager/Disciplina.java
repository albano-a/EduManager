package com.albano.edumanager;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int idDisc;
    private String nomeDisc;
    private Professor prof;
    private List<Nota> notas;

    public Disciplina(int id, String nm, Professor p) {
        this.idDisc = id;
        this.nomeDisc = nm;
        this.prof = p;
        this.notas = new ArrayList<>();
    }

    public void addNota(Nota n) { notas.add(n); }

    public int getId() { return idDisc; }
    public String getNome() { return nomeDisc; }
    public Professor getProf() { return prof; }
    public List<Nota> getNotas() { return notas; }

    @Override
    public String toString() {
        return nomeDisc;
    }
}
