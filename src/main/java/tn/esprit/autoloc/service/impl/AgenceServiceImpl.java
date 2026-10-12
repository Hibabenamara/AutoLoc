package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.service.interfaces.IAgenceService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Set<Agence> retrieveAllAgences() {
        return new HashSet<>(agenceRepository.findAll());
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence).get();
    }

    @Override
    public Agence modifyAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }
}