package com.progetto.employeeservicedb.resources;

import com.progetto.employeeservicedb.models.Employee;
import com.progetto.employeeservicedb.models.EmployeeIDList;
import com.progetto.employeeservicedb.models.EmployeeProject;
import com.progetto.employeeservicedb.models.EmployeeProjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class EmployeeResource {


    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/employees")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employeeidlist/{projectID}")
        public EmployeeIDList getEmployeeIDList(@PathVariable String projectID){
            EmployeeProjectList list = new EmployeeProjectList();
            list.setLista(employeeService.getEmployeeProjectList(projectID));
            return new EmployeeIDList(list.getEmployeeIDList());
    }


    @RequestMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable String employeeID){

        return employeeService.getEmployee(employeeID);

    }


    @RequestMapping(method = RequestMethod.POST, value="/employees")
    public void addEmployee(@RequestBody final Employee employee){
        employeeService.loadEmployee(employee);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/employees/{employeeID}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String employeeID){
        employeeService.updateEmployee(employeeID,employee);

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/employees/{employeeID}")
    public void deleteEmployee(@PathVariable  String employeeID){
        employeeService.deleteEmployee(employeeID);

    }
    @RequestMapping("/employeeproject/{projectID}")
    public List<EmployeeProject> getEmployeeProjectList(@PathVariable String projectID){
        return employeeService.getEmployeeProjectList(projectID);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/employeeproject/{projectID}")
    public void updateEmployeeProject(@RequestBody EmployeeProject employeeProject, @PathVariable String projectID){
        List<String> lista = new ArrayList<>();                                                                         //in questo metodo è presente un controllo che impedisca di inserire un employeeID
        for(int i=0;i<employeeService.getAllEmployees().size();i++){                                                    //che non sia presente nella tabella employee
            lista.add(employeeService.getAllEmployees().get(i).getEmployeeID());
        }
        if(lista.contains(employeeProject.getEmployeeID())){                                                            //se l'employeeID è presente nella lista allora si procede con la modifica/inserimento
        employeeService.updateEmployeeProject(projectID,employeeProject);}                                              //se invece non è presente non viene effettuata alcuna azione
    }















}
