package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.model.Room;
import com.example.hotelbookingsystembackend.repository.HotelRepository;
import com.example.hotelbookingsystembackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }
}
