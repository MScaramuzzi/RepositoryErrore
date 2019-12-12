package com.progetto.projectservicedb.models;

import java.util.ArrayList;
import java.util.List;

public class EmployeeIDList {

    private List<String> lista;

    public Integer getSize()
    {return lista.size();}

    public String getElement(int i){
        return lista.get(i);
    }
    public EmployeeIDList() {}

    public EmployeeIDList(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

}
