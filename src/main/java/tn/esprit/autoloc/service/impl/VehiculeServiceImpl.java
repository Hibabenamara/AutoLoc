package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.*;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.service.interfaces.IVehiculeService;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;
    private final EquipementRepository equipementRepository;


    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Set<Vehicule> retrieveAllVehicules() {
        return new HashSet<>(vehiculeRepository.findAll());
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule).get();
    }

    @Override
    public Vehicule modifyVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }
    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule v = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable : " + idVehicule));
        Agence a = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new IllegalArgumentException("Agence introuvable : " + idAgence));
        v.setAgence(a);
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable : " + idVehicule));
        Equipement eq = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new IllegalArgumentException("Équipement introuvable : " + idEquipement));
        if (v.getEquipements() == null) {
            v.setEquipements(new HashSet<>());
        }
        v.getEquipements().add(eq);
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable : " + idVehicule));
        Equipement eq = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new IllegalArgumentException("Équipement introuvable : " + idEquipement));
        if (v.getEquipements() != null) {
            v.getEquipements().remove(eq);
        }
        return vehiculeRepository.save(v);
    }

    @Override public Set<Vehicule> getByMarque(String m) {
        return vehiculeRepository.findByMarque(m);
    }
    @Override public Set<Vehicule> getByCategorie(CategorieVehicule c) {
        return vehiculeRepository.findByCategorie(c);
    }
    @Override public Set<Vehicule> getByStatut(StatutVehicule s) {
        return vehiculeRepository.findByStatut(s);
    }
    @Override public Set<Vehicule> getByMarqueContaining(String t) {
        return vehiculeRepository.findByMarqueContaining(t);
    }
    @Override public Set<Vehicule> getByModeleStartingWith(String d) {
        return vehiculeRepository.findByModeleStartingWith(d);
    }
    @Override public Set<Vehicule> getByTarifGreaterThan(BigDecimal t) {
        return vehiculeRepository.findByTarifJournalierGreaterThan(t);
    }
    @Override public Set<Vehicule> getByTarifLessThan(BigDecimal t) {
        return vehiculeRepository.findByTarifJournalierLessThan(t);
    }
    @Override public Set<Vehicule> getByTarifGreaterThanEqual(BigDecimal t) {
        return vehiculeRepository.findByTarifJournalierGreaterThanEqual(t);
    }
    @Override public Set<Vehicule> getByMarqueAndStatut(String m, StatutVehicule s) {
        return vehiculeRepository.findByMarqueAndStatut(m, s);
    }
    @Override public Set<Vehicule> getByCategorieOrCategorie(CategorieVehicule c1, CategorieVehicule c2) {
        return vehiculeRepository.findByCategorieOrCategorie(c1, c2);
    }
    @Override public Set<Vehicule> getByMarqueAndTarifLessThan(String m, BigDecimal t) {
        return vehiculeRepository.findByMarqueAndTarifJournalierLessThan(m, t);
    }
    @Override public Set<Vehicule> getDisponiblesOrderByTarifAsc() {
        return vehiculeRepository.findByStatutOrderByTarifJournalierAsc(StatutVehicule.DISPONIBLE);
    }
    @Override public Set<Vehicule> getAllOrderByTarifDesc() {
        return vehiculeRepository.findAllByOrderByTarifJournalierDesc();
    }
}