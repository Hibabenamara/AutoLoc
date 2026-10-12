package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.interfaces.IPaiementService;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementRestController {

    private final IPaiementService paiementService;

    // http://localhost:8089/paiement/retrieve-all-paiements
    @GetMapping("/retrieve-all-paiements")
    public Set<Paiement> getPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    // http://localhost:8089/paiement/retrieve-paiement/1
    @GetMapping("/retrieve-paiement/{paiement-id}")
    public Paiement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
        return paiementService.retrievePaiement(paiementId);
    }

    // http://localhost:8089/paiement/add-paiement
    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement p) {
        return paiementService.addPaiement(p);
    }

    // http://localhost:8089/paiement/remove-paiement/1
    @DeleteMapping("/remove-paiement/{paiement-id}")
    public void removePaiement(@PathVariable("paiement-id") Long paiementId) {
        paiementService.removePaiement(paiementId);
    }

    // http://localhost:8089/paiement/modify-paiement
    @PutMapping("/modify-paiement")
    public Paiement modifyPaiement(@RequestBody Paiement p) {
        return paiementService.modifyPaiement(p);
    }
}