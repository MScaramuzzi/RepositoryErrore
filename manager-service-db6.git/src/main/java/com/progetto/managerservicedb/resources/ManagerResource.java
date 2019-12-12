package com.progetto.managerservicedb.resources;

import com.progetto.managerservicedb.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class ManagerResource {

    @Autowired
    private ManagerService managerService;



    @RequestMapping("/managers")
    public String getAllManagers(){

        return managerService.getAllManagers().toString();
    }


    @RequestMapping("/managers/{managerID}")
    public Manager getManager(@PathVariable String managerID) {
        try {
            return managerService.getManager(managerID);
        }catch (NoSuchElementException e){
            return new Manager();
        }

    }

    @RequestMapping(method = RequestMethod.POST, value="/managers")
    public void addManager(@RequestBody final Manager manager){
        managerService.loadManager(manager);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/managers/{managerID}")
    public void updateManager(@RequestBody Manager manager, @PathVariable String managerID){
        managerService.updateManager(managerID,manager);

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/managers/{managerID}")
    public void deleteManager(@PathVariable  String managerID){
        managerService.deleteManager(managerID);

    }
}
