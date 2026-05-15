package core;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class Professor {
    final private int idProf;
    private String nome;
    private String telefone;
    private LocalDate dtAdm;
    private String discPrincipal;
    private List<Disciplina> discs;

    public Professor(int id, String nm, String tel, LocalDate dtAdmissao, String disc) {
        this.idProf = id;
        this.nome = nm;
        this.telefone = tel;
        this.dtAdm = dtAdmissao;
        this.discPrincipal = disc;
        this.discs = new ArrayList<>();
    }

    public void addDisc(Disciplina d) { discs.add(d); }

    public int getId() { return idProf; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    
    public String getDtAdm() { 
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dtFmt = dtAdm.format(fmt);
        
        return dtFmt;
    }
    public String getEmail() {
        return nome.toLowerCase().replace(" ", ".") + "@edumanager.com";
    }
    public String getDiscPrincipal() { return discPrincipal; }
    public List<Disciplina> getDiscs() { return discs; }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDtAdm(LocalDate dtAdm) {
        this.dtAdm = dtAdm;
    }

    public void setDiscPrincipal(String discPrincipal) {
        this.discPrincipal = discPrincipal;
    }

    public void setDiscs(List<Disciplina> discs) {
        this.discs = discs;
    }

    @Override
    public String toString() {
        return "Prof. " + nome + " (" + discPrincipal + ")";
    }
}
