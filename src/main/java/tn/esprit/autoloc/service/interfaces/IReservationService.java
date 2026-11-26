package tn.esprit.autoloc.service.interfaces;

import tn.esprit.autoloc.domain.Reservation;

import java.time.LocalDate;
import java.util.Set;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);
    Set<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(Long idReservation);
    Reservation modifyReservation(Reservation reservation);
    void removeReservation(Long idReservation);
    Set<Reservation> getByDateDebutAfter(LocalDate date);
    Set<Reservation> getByDateFinBefore(LocalDate date);
}
