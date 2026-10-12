package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.service.interfaces.IContratService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepository contratRepository;

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Set<Contrat> retrieveAllContrats() {
        return new HashSet<>(contratRepository.findAll());
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public Contrat modifyContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void removeContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }
}