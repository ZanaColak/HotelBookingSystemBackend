package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.model.Hotel;
import com.example.hotelbookingsystembackend.model.Room;
import com.example.hotelbookingsystembackend.repository.HotelRepository;
import com.example.hotelbookingsystembackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public void createRoomInHotel(int hotelId, Room newRom){
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);

        if (hotel != null){
            newRom.setHotel(hotel);
            roomRepository.save(newRom);
        }else {
            throw new RuntimeException("Hotel ikke fundet på dette id " + hotelId);
        }
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }
}
