/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private int idAluno;
    private String nome;
    private LocalDate dtNasc;
    private Turma turma;
    private LocalDate dtMatricula;
    private String cpf;
    private String telefone;
    private List<Nota> notas;

    public Aluno(int id, String nm, LocalDate dt, LocalDate dtm, String cpf, String tel, Turma t) {
        this.idAluno = id;
        this.nome = nm;
        this.dtMatricula = dtm;
        this.cpf = cpf;
        this.telefone = tel;
        this.dtNasc = dt;
        this.turma = t;
        this.notas = new ArrayList<>();
    }

    public void addNota(Nota n) {
        notas.add(n);
    }

    public String createEmail(String nome) {
        return nome.toLowerCase().replace(" ", ".") + "@student.com";
    }

    public double calcMedia() {
        if (notas.isEmpty())
            return 0;
        double soma = 0;
        for (Nota n : notas)
            soma += n.getNota();
        return soma / notas.size();
    }

    public boolean isAprovado() {
        return calcMedia() >= 6.0;
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

    public String getDtNascFormatada() {
        DateTimeFormatter fmt =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return dtNasc.format(fmt);
    }

    public Turma getTurma() {
        return turma;
    }
    
    public String getEmail() {
        return nome.toLowerCase().replace(" ", ".") + "@student.com";
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
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setDtMat(LocalDate dtMatricula) {
        this.dtMatricula = dtMatricula;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTel(String telefone) {
        this.telefone = telefone;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }


    @Override
    public String toString() {
        return nome;
    }
}
