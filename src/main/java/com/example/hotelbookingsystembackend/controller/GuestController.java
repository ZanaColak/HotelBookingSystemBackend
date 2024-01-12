package com.example.hotelbookingsystembackend.controller;

import com.example.hotelbookingsystembackend.model.Guest;
import com.example.hotelbookingsystembackend.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
@CrossOrigin(origins = "*")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping()
    public ResponseEntity<List<Guest>> getAllGuest(){
        List<Guest> guestList  = guestService.getAllGuest();
        return new ResponseEntity<>(guestList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest){
        Guest saveGuest = guestService.createGuest(guest);
        return new ResponseEntity<>(saveGuest, HttpStatus.CREATED);
    }

}
