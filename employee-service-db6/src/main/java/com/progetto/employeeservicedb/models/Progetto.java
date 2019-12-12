package com.progetto.employeeservicedb.models;

public class Progetto {

    private String nomeProgetto;
    private String descrizione;
    private float budget;

    public Progetto() {}

    public Progetto(String nomeProgetto, String descrizione, float budget) {
        this.nomeProgetto = nomeProgetto;
        this.descrizione = descrizione;
        this.budget = budget;
    }

    public String getNomeProgetto() {
        return nomeProgetto;
    }

    public void setNomeProgetto(String nomeProgetto) {
        this.nomeProgetto = nomeProgetto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return
                "nomeProgetto='" + nomeProgetto +
                ", descrizione='" + descrizione +
                ", budget=" + budget ;
    }
}
