package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import tn.esprit.autoloc.service.interfaces.IPaiementService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Set<Paiement> retrieveAllPaiements() {
        return new HashSet<>(paiementRepository.findAll());
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement).get();
    }

    @Override
    public Paiement modifyPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }
}