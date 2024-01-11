package com.example.hotelbookingsystembackend.repository;

import com.example.hotelbookingsystembackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
