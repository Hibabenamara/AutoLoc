package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Contrat;

import java.util.Set;

public interface IContratService {

    Contrat addContrat(Contrat contrat);
    Set<Contrat> retrieveAllContrats();
    Contrat retrieveContrat(Long idContrat);
    Contrat modifyContrat(Contrat contrat);
    void removeContrat(Long idContrat);

}
