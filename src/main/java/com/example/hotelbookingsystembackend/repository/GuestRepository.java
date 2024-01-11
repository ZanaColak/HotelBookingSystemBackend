package com.example.hotelbookingsystembackend.repository;

import com.example.hotelbookingsystembackend.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
