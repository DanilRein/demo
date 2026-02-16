package com.example.demo.resourses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(value = "SELECT * FROM reservations WHERE number = :number AND date = :date", nativeQuery = true)
    Optional<Reservation> findByNumberAndDate(Long number, LocalDate date);
}
