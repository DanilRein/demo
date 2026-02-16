package com.example.demo.controller;

import com.example.demo.resourses.Reservation;
import com.example.demo.resourses.ReservationRepository;
import com.example.demo.resourses.Room;
import com.example.demo.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/hotel/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationService reservationService,
                                 ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
    }
    @GetMapping
    public List<Reservation> reservationList(){
        return reservationService.reservationInfo();
    }
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationService.createReservation(reservation);
    }
    @DeleteMapping(path = "{id}")
    public void cancelReservation(@PathVariable(name = "id") Long id){
        reservationService.delete(id);
    }

}
