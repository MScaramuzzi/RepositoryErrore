package com.progetto.projectservicedb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Manager {


    private String managerID;

    private String nome;

    private String cognome;

    private float stipendio;

    public Manager() {}

    public Manager(String managerID, String nome, String cognome, float stipendio) {
        this.managerID = managerID;
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public float getStipendio() {
        return stipendio;
    }

    public void setStipendio(float stipendio) {
        this.stipendio = stipendio;
    }

    public boolean isNull() throws NullPointerException{
        boolean vuoto = false;
        if(nome.equals(null) && cognome.equals(null) && stipendio==0.0 && managerID.equals(null)){
            vuoto = true;}
            return vuoto;
    }
                                                                                                                         //l'invocazione di questo metodo nel ProjectResource genera un'eccezione nel caso in cui al progetto scelto non corrisponda alcun manager
                                                                                                                         //la chiamata al microservizio managerservice restituisce infatti un'istanza della classe manager con tutti i campi settati a null, tranne stipendio
                                                                                                                         //ciò accade perchè il metodo getManager presente nel managerservice restituisce un'istanza generata con un costruttore vuoto (tutti i campi a null, tranne
                                                                                                                         // stipendo che,in quanto float, viene settato a 0.0

    @Override
    public String toString() {
        return   " Nome: " + nome +
                ", Cognome: " + cognome +
                ", Stipendio: " + stipendio +
                ", managerID: " + managerID;

    }

    /*
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("001","Gianfranco","Cavalcanti",5000);
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("002","Giuseppe","Larato",4500);
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("003","Mauro","La Rocca",6000);
    INSERT INTO managers(managerID,nome,cognome,stipendio)
    VALUES("004","Paolo","Rossi",5500);
    * */
}
