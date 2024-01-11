package com.example.hotelbookingsystembackend.repository;

import com.example.hotelbookingsystembackend.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findHotelByHotelId(int id);
}
