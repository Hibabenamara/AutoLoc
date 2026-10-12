package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Agence;

import java.util.Set;

public interface IAgenceService {
    Agence addAgence(Agence agence);
    Set<Agence> retrieveAllAgences();
    Agence retrieveAgence(Long idAgence);
    Agence modifyAgence(Agence agence);
    void removeAgence(Long idAgence);
}
