package com.example.hotelbookingsystembackend.controller;

import com.example.hotelbookingsystembackend.model.Room;
import com.example.hotelbookingsystembackend.service.RoomService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/room")
@CrossOrigin
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/{hotelId}/rooms")
    public ResponseEntity<String> createRoomInHotel(@PathVariable int hotelId, @RequestBody Room newRoom){
        roomService.createRoomInHotel(hotelId, newRoom);
        return ResponseEntity.ok("Værelset er hermed oprettet");
    }
}
