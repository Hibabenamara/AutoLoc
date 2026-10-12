package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.interfaces.IReservationService;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private final IReservationService reservationService;

    // http://localhost:8089/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public Set<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    // http://localhost:8089/reservation/retrieve-reservation/1
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    // http://localhost:8089/reservation/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    // http://localhost:8089/reservation/remove-reservation/1
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    // http://localhost:8089/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        return reservationService.modifyReservation(r);
    }
}