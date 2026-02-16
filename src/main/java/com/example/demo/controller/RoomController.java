package com.example.demo.controller;

import com.example.demo.resourses.Reservation;
import com.example.demo.resourses.Room;
import com.example.demo.service.ReservationService;
import jakarta.persistence.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/hotel/rooms")
public class RoomController {
    private final ReservationService reservationService;
    public RoomController(ReservationService reservationService){
        this.reservationService=reservationService;
    }
    @GetMapping
    public List<Room> roomList(){
        return reservationService.roomInfo();
    }

}
