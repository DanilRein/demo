package com.example.demo.service;

import com.example.demo.resourses.Reservation;
import com.example.demo.resourses.ReservationRepository;
import com.example.demo.resourses.Room;
import com.example.demo.resourses.RoomRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public List<Reservation> reservationInfo() {
        return reservationRepository.findAll();
    }

    public List<Room> roomInfo() {
        return roomRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        Optional<Reservation> reservationOptional = reservationRepository.findByNumberAndDate(reservation.getNumber(), reservation.getDate());
        if (reservationOptional.isPresent()) {
            throw new IllegalStateException("This room will be reserved");
        }
        Room room=roomRepository.findByNumber(reservation.getNumber())
                .orElseThrow(()-> new IllegalStateException("Room"+reservation.getNumber() +" does not exist"));
        reservation.setRoom(room);
        return reservationRepository.save(reservation);
    }
    public void delete(Long id){
        Optional<Reservation> reservationOptional= reservationRepository.findById(id);
        if(reservationOptional.isEmpty()){
            throw new IllegalStateException("Reservation with ID: "+id+" does not exist");
        }
        reservationRepository.deleteById(id);
    }
}
