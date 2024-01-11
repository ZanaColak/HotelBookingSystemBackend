package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.dto.ListHotelDto;
import com.example.hotelbookingsystembackend.model.Hotel;
import com.example.hotelbookingsystembackend.repository.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<ListHotelDto> getAllHotelDTOs() {
        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ListHotelDto convertToDto(Hotel hotel){
        ListHotelDto listHotelDto = new ListHotelDto();
        listHotelDto.setId(hotel.getHotelId());
        listHotelDto.setHotelName(hotel.getHotelName());
        listHotelDto.setStreet(hotel.getStreet());
        listHotelDto.setNumberOfRooms(hotel.getRooms().size());
        return listHotelDto;
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
