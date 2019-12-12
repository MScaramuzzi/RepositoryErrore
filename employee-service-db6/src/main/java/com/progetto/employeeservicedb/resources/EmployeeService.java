package com.progetto.employeeservicedb.resources;

import com.progetto.employeeservicedb.models.Employee;
import com.progetto.employeeservicedb.models.EmployeeIDList;
import com.progetto.employeeservicedb.models.EmployeeProject;
import com.progetto.employeeservicedb.repository.EmployeeProjectRepository;
import com.progetto.employeeservicedb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeProjectRepository employeeProjectRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    public List<EmployeeProject> getEmployeeProjectList(String projectID) {
        return employeeProjectRepository.findByProjectID(projectID);

    }



    public void updateEmployeeProject(String employeeID,EmployeeProject employeeProject){
        employeeProjectRepository.save(employeeProject);
    }



    public Employee getEmployee(String employeeID) {
        return employeeRepository.findById(employeeID).get();

    }


    public void loadEmployee(@RequestBody final Employee employee){
        employeeRepository.save(employee);

    }

    public void updateEmployee(String employeeID, Employee emp){
        employeeRepository.save(emp);
    }

    public void deleteEmployee(String employeeID){
        employeeRepository.deleteById(employeeID);
    }


}
