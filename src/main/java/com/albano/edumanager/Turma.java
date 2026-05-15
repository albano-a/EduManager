package com.albano.edumanager;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int idTurma;
    private String nomeTurma;
    private int ano;
    private List<Aluno> alunos;

    public Turma(int id, String nm, int ano) {
        this.idTurma = id;
        this.nomeTurma = nm;
        this.ano = ano;
        this.alunos = new ArrayList<>();
    }

    public void addAluno(Aluno a) { alunos.add(a); }

    public int getId() { return idTurma; }
    public String getNome() { return nomeTurma; }
    public int getAno() { return ano; }
    public List<Aluno> getAlunos() { return alunos; }

    @Override
    public String toString() {
        return "Turma " + nomeTurma + " (" + ano + ")";
    }
}
