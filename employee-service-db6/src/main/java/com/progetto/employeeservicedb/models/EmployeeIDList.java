package com.progetto.employeeservicedb.models;

import java.util.List;

public class EmployeeIDList {

    private List<String> lista;

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
