package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Equipement;

import java.util.Set;

public interface IEquipementService {

    Equipement addEquipement(Equipement equipement);
    Set<Equipement> retrieveAllEquipements();
    Equipement retrieveEquipement(Long idEquipement);
    Equipement modifyEquipement(Equipement equipement);
    void removeEquipement(Long idEquipement);
}
