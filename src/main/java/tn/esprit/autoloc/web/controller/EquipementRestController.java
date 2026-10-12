package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.interfaces.IEquipementService;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementRestController {

    private final IEquipementService equipementService;

    // http://localhost:8089/equipement/retrieve-all-equipements
    @GetMapping("/retrieve-all-equipements")
    public Set<Equipement> getEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    // http://localhost:8089/equipement/retrieve-equipement/1
    @GetMapping("/retrieve-equipement/{equipement-id}")
    public Equipement retrieveEquipement(@PathVariable("equipement-id") Long equipementId) {
        return equipementService.retrieveEquipement(equipementId);
    }

    // http://localhost:8089/equipement/add-equipement
    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement e) {
        return equipementService.addEquipement(e);
    }

    // http://localhost:8089/equipement/remove-equipement/1
    @DeleteMapping("/remove-equipement/{equipement-id}")
    public void removeEquipement(@PathVariable("equipement-id") Long equipementId) {
        equipementService.removeEquipement(equipementId);
    }

    // http://localhost:8089/equipement/modify-equipement
    @PutMapping("/modify-equipement")
    public Equipement modifyEquipement(@RequestBody Equipement e) {
        return equipementService.modifyEquipement(e);
    }
}