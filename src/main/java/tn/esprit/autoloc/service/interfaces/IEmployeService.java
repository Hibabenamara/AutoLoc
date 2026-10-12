package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Employe;

import java.util.Set;

public interface IEmployeService {

    Employe addEmploye(Employe employe);
    Set<Employe> retrieveAllEmployes();
    Employe retrieveEmploye(Long idEmploye);
    Employe modifyEmploye(Employe employe);
    void removeEmploye(Long idEmploye);
}
