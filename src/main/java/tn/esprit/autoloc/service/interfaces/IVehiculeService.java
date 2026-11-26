package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;

import java.math.BigDecimal;
import java.util.Set;

public interface IVehiculeService {

    Vehicule addVehicule(Vehicule vehicule);
    Set<Vehicule> retrieveAllVehicules();
    Vehicule retrieveVehicule(Long idVehicule);
    Vehicule modifyVehicule(Vehicule vehicule);
    void removeVehicule(Long idVehicule);
    Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
    Set<Vehicule> getByMarque(String marque);
    Set<Vehicule> getByCategorie(CategorieVehicule categorie);
    Set<Vehicule> getByStatut(StatutVehicule statut);
    Set<Vehicule> getByMarqueContaining(String texte);
    Set<Vehicule> getByModeleStartingWith(String debut);
    Set<Vehicule> getByTarifGreaterThan(BigDecimal tarif);
    Set<Vehicule> getByTarifLessThan(BigDecimal tarif);
    Set<Vehicule> getByTarifGreaterThanEqual(BigDecimal tarif);
    Set<Vehicule> getByMarqueAndStatut(String marque, StatutVehicule statut);
    Set<Vehicule> getByCategorieOrCategorie(CategorieVehicule c1, CategorieVehicule c2);
    Set<Vehicule> getByMarqueAndTarifLessThan(String marque, BigDecimal tarif);
    Set<Vehicule> getDisponiblesOrderByTarifAsc();
    Set<Vehicule> getAllOrderByTarifDesc();
}
