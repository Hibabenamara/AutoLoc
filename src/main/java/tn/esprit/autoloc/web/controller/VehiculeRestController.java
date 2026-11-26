package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.interfaces.IVehiculeService;

import java.math.BigDecimal;
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
    // http://localhost:8089/vehicule/affecter-vehicule/1/2
    @PutMapping("/affecter-vehicule/{vehicule-id}/{agence-id}")
    public Vehicule affecterVehicule(@PathVariable("vehicule-id") Long vehiculeId,
                                     @PathVariable("agence-id") Long agenceId) {
        return vehiculeService.affecterVehicule(vehiculeId, agenceId);
    }

    // http://localhost:8089/vehicule/affecter-equipement/1/3
    @PutMapping("/affecter-equipement/{vehicule-id}/{equipement-id}")
    public Vehicule affecterEquipement(@PathVariable("vehicule-id") Long vehiculeId,
                                       @PathVariable("equipement-id") Long equipementId) {
        return vehiculeService.affecterEquipement(vehiculeId, equipementId);
    }

    // http://localhost:8089/vehicule/desaffecter-equipement/1/3
    @PutMapping("/desaffecter-equipement/{vehicule-id}/{equipement-id}")
    public Vehicule desaffecterEquipement(@PathVariable("vehicule-id") Long vehiculeId,
                                          @PathVariable("equipement-id") Long equipementId) {
        return vehiculeService.desaffecterEquipement(vehiculeId, equipementId);
    }

    // http://localhost:8089/vehicule/by-marque?marque=Peugeot
    @GetMapping("/by-marque")
    public Set<Vehicule> byMarque(@RequestParam String marque) { return vehiculeService.getByMarque(marque); }

    // http://localhost:8089/vehicule/by-categorie?categorie=SUV
    @GetMapping("/by-categorie")
    public Set<Vehicule> byCategorie(@RequestParam CategorieVehicule categorie) { return vehiculeService.getByCategorie(categorie); }

    // http://localhost:8089/vehicule/disponibles
    @GetMapping("/disponibles")
    public Set<Vehicule> disponibles() { return vehiculeService.getByStatut(StatutVehicule.DISPONIBLE); }

    // http://localhost:8089/vehicule/marque-contient?texte=pe
    @GetMapping("/marque-contient")
    public Set<Vehicule> marqueContient(@RequestParam String texte) { return vehiculeService.getByMarqueContaining(texte); }

    // http://localhost:8089/vehicule/modele-commence?debut=Cl
    @GetMapping("/modele-commence")
    public Set<Vehicule> modeleCommence(@RequestParam String debut) { return vehiculeService.getByModeleStartingWith(debut); }

    // http://localhost:8089/vehicule/tarif-sup-100
    @GetMapping("/tarif-sup-100")
    public Set<Vehicule> tarifSup100() { return vehiculeService.getByTarifGreaterThan(new BigDecimal("100")); }

    // http://localhost:8089/vehicule/tarif-inf-50
    @GetMapping("/tarif-inf-50")
    public Set<Vehicule> tarifInf50() { return vehiculeService.getByTarifLessThan(new BigDecimal("50")); }

    // http://localhost:8089/vehicule/tarif-sup-egal-80
    @GetMapping("/tarif-sup-egal-80")
    public Set<Vehicule> tarifSupEgal80() { return vehiculeService.getByTarifGreaterThanEqual(new BigDecimal("80")); }

    // http://localhost:8089/vehicule/marque-disponible?marque=Peugeot
    @GetMapping("/marque-disponible")
    public Set<Vehicule> marqueDisponible(@RequestParam String marque) { return vehiculeService.getByMarqueAndStatut(marque, StatutVehicule.DISPONIBLE); }

    // http://localhost:8089/vehicule/suv-ou-berline
    @GetMapping("/suv-ou-berline")
    public Set<Vehicule> suvOuBerline() { return vehiculeService.getByCategorieOrCategorie(CategorieVehicule.SUV, CategorieVehicule.BERLINE); }

    // http://localhost:8089/vehicule/marque-tarif-inf-100?marque=Peugeot
    @GetMapping("/marque-tarif-inf-100")
    public Set<Vehicule> marqueTarifInf100(@RequestParam String marque) { return vehiculeService.getByMarqueAndTarifLessThan(marque, new BigDecimal("100")); }

    // http://localhost:8089/vehicule/disponibles-tarif-asc
    @GetMapping("/disponibles-tarif-asc")
    public Set<Vehicule> disponiblesTarifAsc() { return vehiculeService.getDisponiblesOrderByTarifAsc(); }

    // http://localhost:8089/vehicule/tarif-desc
    @GetMapping("/tarif-desc")
    public Set<Vehicule> tarifDesc() { return vehiculeService.getAllOrderByTarifDesc(); }
}