package com.example.hotelbookingsystembackend.service;
import com.example.hotelbookingsystembackend.repository.GuestRepository;
import com.example.hotelbookingsystembackend.repository.ReservationRepository;
import com.example.hotelbookingsystembackend.repository.RoomRepository;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

}
