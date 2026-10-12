package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Paiement;

import java.util.Set;

public interface IPaiementService {

    Paiement addPaiement(Paiement paiement);
    Set<Paiement> retrieveAllPaiements();
    Paiement retrievePaiement(Long idPaiement);
    Paiement modifyPaiement(Paiement paiement);
    void removePaiement(Long idPaiement);
}
