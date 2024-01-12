package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.dto.ListHotelDto;
import com.example.hotelbookingsystembackend.model.Hotel;
import com.example.hotelbookingsystembackend.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ListHotelDto> getAllHotelDTOs(Pageable pageable) {
        Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
        return hotelPage.map(this::convertToDto);

    }

    private ListHotelDto convertToDto(Hotel hotel) {
        ListHotelDto listHotelDto = new ListHotelDto();
        listHotelDto.setId(hotel.getHotelId());
        listHotelDto.setHotelName(hotel.getHotelName());
        listHotelDto.setStreet(hotel.getStreet());
        listHotelDto.setNumberOfRooms(hotel.getRooms().size());
        return listHotelDto;
    }

    public List<ListHotelDto> getHotelById(int id) {
        List<Hotel> hotelList = hotelRepository.findHotelByHotelId(id);
        return hotelList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public List<Hotel> getHotelsByClassificationType(String classificationType) {
        return hotelRepository.findHotelByClassificationTypeContaining(classificationType);
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
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            if (hotel.getRooms().stream().anyMatch(room -> !room.getReservations().isEmpty())) {
                throw new RuntimeException("Hotel kan ikke slettes fordi at der er reserverede værelser.");
            } else {
                hotelRepository.deleteById(id);
            }
        }
    }
}
