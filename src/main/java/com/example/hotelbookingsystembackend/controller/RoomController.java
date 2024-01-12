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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "*")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<Room> saveRoom(@RequestBody Room room){
        Room saveRoom = roomService.saveRoom(room);
        return new ResponseEntity<>(saveRoom, HttpStatus.OK);
    }
}
