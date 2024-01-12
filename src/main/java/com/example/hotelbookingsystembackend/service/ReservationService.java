package com.example.hotelbookingsystembackend.service;
import com.example.hotelbookingsystembackend.model.Reservation;
import com.example.hotelbookingsystembackend.model.Room;
import com.example.hotelbookingsystembackend.repository.GuestRepository;
import com.example.hotelbookingsystembackend.repository.ReservationRepository;
import com.example.hotelbookingsystembackend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


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

    public Reservation createReservation(Reservation reservation) {
        int roomId = reservation.getRoom().getId();
        LocalDate checkInDate = reservation.getCheckInDate();
        LocalDate checkOutDate = reservation.getCheckOutDate();

        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Værelse ikke fundet"));
        List<Reservation> roomReservations = room.getReservations();

        if (isRoomAvailable(roomReservations, checkInDate, checkOutDate)) {
            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("Værelse er ikke tilgængelig for den specifikke dato.");
        }
    }

    private boolean isRoomAvailable(List<Reservation> roomReservations, LocalDate checkInDate, LocalDate checkOutDate) {
        for (Reservation existingReservation : roomReservations) {
            LocalDate existingCheckIn = existingReservation.getCheckInDate();
            LocalDate existingCheckOut = existingReservation.getCheckOutDate();

            if (existingCheckIn.isBefore(checkOutDate) && existingCheckOut.isAfter(checkInDate)) {
                return false;
            }
        }
        return true;
    }

    public void cancelReservation(int id) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);

        if (reservation != null) {
            reservationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Reservation ikke fundet.");
        }
    }
}
