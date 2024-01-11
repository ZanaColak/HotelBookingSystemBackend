package com.example.hotelbookingsystembackend.repository;

import com.example.hotelbookingsystembackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
