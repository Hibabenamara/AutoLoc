package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Maintenance;

import java.time.LocalDate;
import java.util.Set;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
    Set<Maintenance> findByDateFinBetween(LocalDate debut, LocalDate fin);
}
