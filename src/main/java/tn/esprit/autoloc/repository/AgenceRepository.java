package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Agence;

import java.util.Set;

public interface AgenceRepository extends JpaRepository<Agence, Long>{
    Set<Agence> findByVille(String ville);
    Set<Agence> findByNomEndingWith(String fin);
}
