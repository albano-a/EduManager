/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Aluno {
    private int idAluno;
    private String nome;
    private String email;
    private LocalDate dtNasc;
    private Turma turma;
    private LocalDate dtMatricula;
    private String cpf;
    private String telefone;
    private List<Nota> notas;
    private List<Frequencia> freqs;

    public Aluno(int id, String nm, String em, LocalDate dt, LocalDate dtm, String cpf, String tel, Turma t) {
        this.idAluno = id;
        this.nome = nm;
        this.email = em;
        this.dtMatricula = dtm;
        this.cpf = cpf;
        this.telefone = tel;
        this.dtNasc = dt;
        this.turma = t;
        this.notas = new ArrayList<>();
        this.freqs = new ArrayList<>();
    }

    public void addNota(Nota n) {
        notas.add(n);
    }

    public void addFreq(Frequencia f) {
        freqs.add(f);
    }

    public double calcMedia() {
        if (notas.isEmpty())
            return 0;
        double soma = 0;
        for (Nota n : notas)
            soma += n.getNota();
        return soma / notas.size();
    }

    public double calcFreqPct() {
        if (freqs.isEmpty())
            return 0;
        long pres = freqs.stream().filter(Frequencia::isPresente).count();
        return (double) pres / freqs.size() * 100;
    }

    public boolean isAprovado() {
        return calcMedia() >= 6.0 && calcFreqPct() >= 75.0;
    }

    public int getId() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public Turma getTurma() {
        return turma;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDtMat() {
        return dtMatricula;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTel() {
        return telefone;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public List<Frequencia> getFreqs() {
        return freqs;
    }

    @Override
    public String toString() {
        return "Aluno[" + idAluno + "] " + nome;
    }
}
