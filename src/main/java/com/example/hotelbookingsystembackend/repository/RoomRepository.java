package com.example.hotelbookingsystembackend.repository;

import com.example.hotelbookingsystembackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
