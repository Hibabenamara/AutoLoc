package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.interfaces.IEmployeService;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeRestController {

    private final IEmployeService employeService;

    // http://localhost:8089/employe/retrieve-all-employes
    @GetMapping("/retrieve-all-employes")
    public Set<Employe> getEmployes() {
        return employeService.retrieveAllEmployes();
    }

    // http://localhost:8089/employe/retrieve-employe/1
    @GetMapping("/retrieve-employe/{employe-id}")
    public Employe retrieveEmploye(@PathVariable("employe-id") Long employeId) {
        return employeService.retrieveEmploye(employeId);
    }

    // http://localhost:8089/employe/add-employe
    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe e) {
        return employeService.addEmploye(e);
    }

    // http://localhost:8089/employe/remove-employe/1
    @DeleteMapping("/remove-employe/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") Long employeId) {
        employeService.removeEmploye(employeId);
    }

    // http://localhost:8089/employe/modify-employe
    @PutMapping("/modify-employe")
    public Employe modifyEmploye(@RequestBody Employe e) {
        return employeService.modifyEmploye(e);
    }
}