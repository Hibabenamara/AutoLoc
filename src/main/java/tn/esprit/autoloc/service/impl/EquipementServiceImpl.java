package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.service.interfaces.IEquipementService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Set<Equipement> retrieveAllEquipements() {
        return new HashSet<>(equipementRepository.findAll());
    }

    @Override
    public Equipement retrieveEquipement(Long idEquipement) {
        return equipementRepository.findById(idEquipement).get();
    }

    @Override
    public Equipement modifyEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }
}