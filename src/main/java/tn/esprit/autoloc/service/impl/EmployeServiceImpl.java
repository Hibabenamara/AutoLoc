package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.service.interfaces.IEmployeService;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Set<Employe> retrieveAllEmployes() {
        return new HashSet<>(employeRepository.findAll());
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return employeRepository.findById(idEmploye).get();
    }

    @Override
    public Employe modifyEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe e = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new IllegalArgumentException("Employé introuvable : " + idEmploye));
        e.setAgence(null);
        return employeRepository.save(e);
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe e = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new IllegalArgumentException("Employé introuvable : " + idEmploye));
        Agence a = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new IllegalArgumentException("Agence introuvable : " + idAgence));
        if (e.getAgence() != null) {
            throw new IllegalStateException("Employé déjà affecté : désaffectez-le d'abord.");
        }
        e.setAgence(a);
        return employeRepository.save(e);
    }
}