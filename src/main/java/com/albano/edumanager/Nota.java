package com.albano.edumanager;

public class Nota {
    private int idNota;
    private Aluno aluno;
    private Disciplina disc;
    private int bimestre;
    private double nota;

    public Nota(int id, Aluno a, Disciplina d, int bim, double nt) {
        this.idNota = id;
        this.aluno = a;
        this.disc = d;
        this.bimestre = bim;
        this.nota = nt;
    }

    public boolean isAprovado() { return nota >= 6.0; }

    public int getId() { return idNota; }
    public Aluno getAluno() { return aluno; }
    public Disciplina getDisc() { return disc; }
    public int getBimestre() { return bimestre; }
    public double getNota() { return nota; }
    public void setNota(double n) { this.nota = n; }

    @Override
    public String toString() {
        return disc.getNome() + " | Bim " + bimestre + " | Nota: " + nota;
    }
}
