package com.example.hotelbookingsystembackend.service;

import com.example.hotelbookingsystembackend.model.Booking;
import com.example.hotelbookingsystembackend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateCustomer(int id, Booking updatedBooking) {
        if (bookingRepository.existsById(id)) {
            updatedBooking.setBookingId(id);
            return bookingRepository.save(updatedBooking);
        } else {
            return null;
        }
    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }
}
