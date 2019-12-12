package com.progetto.projectservicedb.resources;

import com.progetto.projectservicedb.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
public class ProjectResource {

    @Autowired
    private ProjectService projectService;

    @Autowired
    public RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("/overview/{projectID}")
    public String getOverview(@PathVariable  String projectID){                                                          //metodo che fornisce una overview complessiva: verrà stampato a video il progetto associato al projectID dato in input, insieme ai dati del manager del progetto
                                                                                                                         //con essi viene anche fornita a video la lista dei dipendenti assegnati al progetto
        String s ="Overview del progetto \n" + projectService.getProject(projectID).toString() + " \nManager: \n" ;

        Manager m =restTemplate.getForObject("http://manager-discovery/managers/"+ projectService.getProject(projectID).
                        getManagerID(),Manager.class);
                                                                                                                         //chiamata al microservizio managerservice, restituisce un'istanza della classe Manager
        try{
        m.isNull();
        s+= m.toString();
        }catch (NullPointerException e){
            s += " A questo progetto non è ancora stato assegnato alcun manager";
        }
                                                                                                                         //blocco try/catch per gestire l'eccezione NullPointerException, lanciata dal metodo isNull
                                                                                                                         //se l'eccezione non viene lanciata, vengono stampati a video i dati del manager
        s += " \nDipendenti assegnati al progetto: ";

        EmployeeIDList lista = restTemplate.getForObject("http://localhost:8082/employeeidlist/"+
                projectID,EmployeeIDList.class);

                                                                                                                         //chiamata al microservizio employeeservice, a cui è associata la tabella employeeproject, che contiene per ogni tupla una coppia employeeID,projectId
                                                                                                                         //poichè questa chiamata restituisce una lista di employeeID (String), è stato necessario creare una nuova classe, EmployeeIDList, per evitare gli errori dovuti al json
                                                                                                                         //con questa chiamata si crea quindi una istanza di EmployeeIDList
        if(lista.getSize()==0){
            s += "\n A questo progetto non è ancora stato assegnato alcun dipendente";
        }
                                                                                                                         //se la lista risulta vuota, significa che per quel determinato projectID non risultava alcun employeeID associato
        for(int i=0;i<lista.getSize();i++){
              s += "\n"+ restTemplate.getForObject("http://localhost:8082/employees/"+lista.getElement(i),
                      Employee.class).toString();
         }
                                                                                                                         //la stringa viene popolata tramite tante chiamate quanti sono gli elementi della EmployeeIDList
                                                                                                                         //per ogni chiamata infatti si fa riferimento ad un singolo employeeID, ottenuto tramite l'invocazione del metodo getElement, definito nella classe EmployeeIDList
                                                                                                                         //per ogni istanza della classe Employee viene quindi invocato il metodo toString per popolare la stringa
        return s;
    }

    @RequestMapping("/projects")
    public String getAllProjects(){
        return projectService.getAllProjects().toString();
    }

    @RequestMapping("/projects/{projectID}")
    public String getProject(@PathVariable String projectID){

        return projectService.getProject(projectID).toString();
    }


    @RequestMapping(method = RequestMethod.POST, value="/projects")
    public void addProject(@RequestBody final Progetto progetto){
        projectService.loadProject(progetto);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/projects/{projectID}")
    public void updateProject(@RequestBody Progetto progetto, @PathVariable String projectID){
       projectService.updateProject(projectID,progetto);

    }

    @RequestMapping(method = RequestMethod.DELETE, value="/projects/{projectID}")
    public void deleteProject(@PathVariable  String projectID){
        projectService.deleteProject(projectID);

    }


}
