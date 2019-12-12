package com.progetto.employeeservicedb.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectList {
    private List<EmployeeProject> lista;

    public EmployeeProjectList(){}



    public List<String> getEmployeeIDList(){                        //metodo che restituisce una lista di stringhe
        List<String> nuova = new ArrayList<>();                     //viene creata una nuova lista vuota, che viene popolata
        for(int i =0;i<lista.size();i++){                           //all'interno del ciclo for
            nuova.add(lista.get(i).getEmployeeID());                //per ogni elemento della lista (composta da istanze EmployeeProject)il
        }                                                           //metodo getEmployeeID estrapola solo l'employeeID e lo inserisce nella lista di stringhe, denominata ''nuova''
        return nuova;
    }

    public List<String> getProjectIDList(){
        List<String> nuova = new ArrayList<>();
        for(int i =0;i<lista.size();i++){
            nuova.add(lista.get(i).getProjectID());
        }
        return nuova;
    }

    public List<EmployeeProject> getLista() {
        return lista;
    }

    public void setLista(List<EmployeeProject> lista) {
        this.lista = lista;
    }
}
