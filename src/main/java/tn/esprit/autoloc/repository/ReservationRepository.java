package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Reservation;

import java.time.LocalDate;
import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    Set<Reservation> findByDateDebutAfter(LocalDate date);
    Set<Reservation> findByDateFinBefore(LocalDate date);
}
