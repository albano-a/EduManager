package core;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    final private int idProf;
    final private String nome;
    final private String discPrincipal;
    final private List<Disciplina> discs;

    public Professor(int id, String nm, String disc) {
        this.idProf = id;
        this.nome = nm;
        this.discPrincipal = disc;
        this.discs = new ArrayList<>();
    }

    public void addDisc(Disciplina d) { discs.add(d); }

    public int getId() { return idProf; }
    public String getNome() { return nome; }
    public String getDiscPrincipal() { return discPrincipal; }
    public List<Disciplina> getDiscs() { return discs; }

    @Override
    public String toString() {
        return "Prof. " + nome + " (" + discPrincipal + ")";
    }
}
