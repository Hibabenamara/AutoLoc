package tn.esprit.autoloc.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.service.interfaces.IEmployeService;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;

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
}