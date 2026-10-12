package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.Set;

public interface IVehiculeService {

    Vehicule addVehicule(Vehicule vehicule);
    Set<Vehicule> retrieveAllVehicules();
    Vehicule retrieveVehicule(Long idVehicule);
    Vehicule modifyVehicule(Vehicule vehicule);
    void removeVehicule(Long idVehicule);
}
