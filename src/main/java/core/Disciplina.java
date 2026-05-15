package core;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int idDisc;
    private String nomeDisc;
    private Professor prof;
    private int cargaHoraria;
    private List<Nota> notas;

    public Disciplina(int id, String nm, Professor p, int ch) {
        this.idDisc = id;
        this.nomeDisc = nm;
        this.prof = p;
        this.cargaHoraria = ch;
        this.notas = new ArrayList<>();
    }

    public void addNota(Nota n) {
        notas.add(n);
    }

    public int getId() {
        return idDisc;
    }

    public String getNome() {
        return nomeDisc;
    }

    public Professor getProf() {
        return prof;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Nota> getNotas() {
        return notas;
    }
    
    public void setNome(String nomeDisc) {
        this.nomeDisc = nomeDisc;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return nomeDisc;
    }
}
