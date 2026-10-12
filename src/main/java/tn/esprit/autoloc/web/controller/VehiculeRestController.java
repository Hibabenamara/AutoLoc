package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.interfaces.IVehiculeService;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    // http://localhost:8089/vehicule/retrieve-all-vehicules
    @GetMapping("/retrieve-all-vehicules")
    public Set<Vehicule> getVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    // http://localhost:8089/vehicule/retrieve-vehicule/1
    @GetMapping("/retrieve-vehicule/{vehicule-id}")
    public Vehicule retrieveVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        return vehiculeService.retrieveVehicule(vehiculeId);
    }

    // http://localhost:8089/vehicule/add-vehicule
    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule v) {
        return vehiculeService.addVehicule(v);
    }

    // http://localhost:8089/vehicule/remove-vehicule/1
    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        vehiculeService.removeVehicule(vehiculeId);
    }

    // http://localhost:8089/vehicule/modify-vehicule
    @PutMapping("/modify-vehicule")
    public Vehicule modifyVehicule(@RequestBody Vehicule v) {
        return vehiculeService.modifyVehicule(v);
    }
}