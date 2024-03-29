package com.example.hotelbookingsystembackend.controller;

import com.example.hotelbookingsystembackend.dto.ListHotelDto;
import com.example.hotelbookingsystembackend.model.Hotel;
import com.example.hotelbookingsystembackend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "*")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping()
    public ResponseEntity<Page<ListHotelDto>> getAllHotel(Pageable pageable) {
        Page<ListHotelDto> hotelPage = hotelService.getAllHotelDTOs(pageable);
        return new ResponseEntity<>(hotelPage, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ListHotelDto>> findByHotelId(@PathVariable int id){
        List<ListHotelDto> hotelList = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotelList, HttpStatus.OK);
    }

    @GetMapping("/byType/{classificationType}")
    public ResponseEntity<List<Hotel>> getHotelsByType(@PathVariable String classificationType) {
        List<Hotel> hotels = hotelService.getHotelsByClassificationType(classificationType);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel saveHotel = hotelService.saveHotel(hotel);
        return new ResponseEntity<>(saveHotel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel updatedHotel){
        Hotel updated = hotelService.updateHotel(id, updatedHotel);
        if (updated != null){
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable int id){
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
