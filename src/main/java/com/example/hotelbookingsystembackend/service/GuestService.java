package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.model.Guest;
import com.example.hotelbookingsystembackend.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;
    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest updateGuest(int id, Guest updatedGuest) {
        if (guestRepository.existsById(id)) {
            updatedGuest.setGuestId(id);
            return guestRepository.save(updatedGuest);
        } else {
            return null;
        }
    }

    public void deleteGuest(int id) {
        guestRepository.deleteById(id);
    }
}
