package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Maintenance;

import java.time.LocalDate;
import java.util.Set;

public interface IMaintenanceService {

    Maintenance addMaintenance(Maintenance maintenance);
    Set<Maintenance> retrieveAllMaintenances();
    Maintenance retrieveMaintenance(Long idMaintenance);
    Maintenance modifyMaintenance(Maintenance maintenance);
    void removeMaintenance(Long idMaintenance);
    Set<Maintenance> getByDateFinBetween(LocalDate debut, LocalDate fin);
}
