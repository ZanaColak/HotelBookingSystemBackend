package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.model.Hotel;
import com.example.hotelbookingsystembackend.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(int id, Hotel updatedHotel) {
        if (hotelRepository.existsById(id)) {
            updatedHotel.setHotelId(id);
            return hotelRepository.save(updatedHotel);
        } else {
            return null;
        }
    }

    public void deleteHotel(int id) {
        hotelRepository.deleteById(id);
    }
}
