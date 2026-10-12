package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.interfaces.IContratService;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

    private final IContratService contratService;

    // http://localhost:8089/contrat/retrieve-all-contrats
    @GetMapping("/retrieve-all-contrats")
    public Set<Contrat> getContrats() {
        return contratService.retrieveAllContrats();
    }

    // http://localhost:8089/contrat/retrieve-contrat/1
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        return contratService.retrieveContrat(contratId);
    }

    // http://localhost:8089/contrat/add-contrat
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat c) {
        return contratService.addContrat(c);
    }

    // http://localhost:8089/contrat/remove-contrat/1
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.removeContrat(contratId);
    }

    // http://localhost:8081/contrat/modify-contrat
    @PutMapping("/modify-contrat")
    public Contrat modifyContrat(@RequestBody Contrat c) {
        return contratService.modifyContrat(c);
    }
}