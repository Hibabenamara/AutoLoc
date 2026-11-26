package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.util.Set;
import java.math.BigDecimal;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
    Set<Vehicule> findByMarque(String marque);
    Set<Vehicule> findByCategorie(CategorieVehicule categorie);
    Set<Vehicule> findByStatut(StatutVehicule statut);
    Set<Vehicule> findByMarqueContaining(String texte);
    Set<Vehicule> findByModeleStartingWith(String debut);
    Set<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    Set<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);
    Set<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);
    Set<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
    Set<Vehicule> findByCategorieOrCategorie(CategorieVehicule c1, CategorieVehicule c2);
    Set<Vehicule> findByMarqueAndTarifJournalierLessThan(String marque, BigDecimal tarif);
    Set<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);
    Set<Vehicule> findAllByOrderByTarifJournalierDesc();
}
