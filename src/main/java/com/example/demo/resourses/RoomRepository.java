package com.example.demo.resourses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "SELECT * FROM room WHERE number = :number", nativeQuery = true)
    Optional<Room> findByNumber(Long number);
}
