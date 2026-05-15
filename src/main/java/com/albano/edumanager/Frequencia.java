package com.albano.edumanager;

import java.util.Date;

public class Frequencia {
    private int idFreq;
    private Aluno aluno;
    private Disciplina disc;
    private Date dtAula;
    private boolean presente;

    public Frequencia(int id, Aluno a, Disciplina d, Date dt, boolean pres) {
        this.idFreq = id;
        this.aluno = a;
        this.disc = d;
        this.dtAula = dt;
        this.presente = pres;
    }

    public int getId() { return idFreq; }
    public Aluno getAluno() { return aluno; }
    public Disciplina getDisc() { return disc; }
    public Date getDtAula() { return dtAula; }
    public boolean isPresente() { return presente; }
    public void setPresente(boolean p) { this.presente = p; }

    @Override
    public String toString() {
        return disc.getNome() + " | " + dtAula + " | " + (presente ? "Presente" : "Falta");
    }
}
