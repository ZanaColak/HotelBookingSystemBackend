package com.example.hotelbookingsystembackend.repository;

import com.example.hotelbookingsystembackend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
