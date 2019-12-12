package com.progetto.projectservicedb.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



public class Employee {


    private String employeeID;

    private String nome;

    private String cognome;

    private float stipendio;

    private String ruolo;

    public Employee() {}

    public Employee(String nome, String cognome, String employeeID, float stipendio, String ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.employeeID = employeeID;
        this.stipendio = stipendio;
        this.ruolo = ruolo;
    }


    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCognome() {return cognome;}

    public void setCognome(String cognome) {this.cognome = cognome;}

    public String getEmployeeID() {return employeeID;}

    public void setEmployeeID(String employeeID) {this.employeeID = employeeID;}

    public float getStipendio() {return stipendio;}

    public void setStipendio(float stipendio) {this.stipendio = stipendio;}

    public String getRuolo() {return ruolo;}

    public void setRuolo(String ruolo) {this.ruolo = ruolo;}


    @Override
    public String toString() {
        return
                " Nome: " + nome +
                ", Cognome: " + cognome +
                ", Ruolo: " + ruolo +
                ", Stipendio: " + stipendio +
                ", employeeID: " + employeeID;
    }
}

/*

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("002","Fabio","Bianchi", "Programmatore",1500);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("003","Lucia","Neri", "Tecnico informatico",2000);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("004","Marco","Colucci", "Sviluppatore web",2500);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("005","Gianluca","Degaetano", "Tecnico",1500);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("006","Antonio","Verdi", "Programmatore",1000);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("007","Giacomo","Legame", "Specialista",3500);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("008","Rosa","Attili", "Sviluppatore web",2000);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("009","Marilena","Laurenti", "Programmatore",1500);

INSERT INTO employee(employeeID,nome,cognome,ruolo,stipendio)
VALUES("010","Francesco","Beneventi", "Tecnico",2500);
* */
