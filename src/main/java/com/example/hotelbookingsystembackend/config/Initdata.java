package com.example.hotelbookingsystembackend.config;

import com.example.hotelbookingsystembackend.model.Hotel;
import com.example.hotelbookingsystembackend.model.Room;
import com.example.hotelbookingsystembackend.repository.HotelRepository;
import com.example.hotelbookingsystembackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class Initdata implements CommandLineRunner {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    @Autowired
    public Initdata(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        generateDummyData(250, 10, 40, 1, 4);
    }

    private void generateDummyData(int numHotels, int minRooms, int maxRooms, int minBeds, int maxBeds) {
        for (int i = 0; i < numHotels; i++) {
            Hotel hotel = new Hotel();
            // Set hotel properties
            hotel.setHotelName("Hotel " + i); // Adjust as needed
            hotel.setCountry("Country " + i);
            hotel.setCity("City " + i);
            hotel.setStreet("Street " + i);
            hotel.setZip(i);
            hotel.setCreated(LocalDateTime.now());
            hotel.setUpdated(LocalDateTime.now());

            // Save the hotel first
            hotel = hotelRepository.save(hotel);

            Set<Room> rooms = generateRooms(minRooms, maxRooms, minBeds, maxBeds, hotel);
            hotel.setRooms(rooms);

            // Update and save the hotel with associated rooms
            hotelRepository.save(hotel);
        }
    }


    private Set<Room> generateRooms(int minRooms, int maxRooms, int minBeds, int maxBeds, Hotel hotel) {
        Random random = new Random();
        int numRooms = random.nextInt(maxRooms - minRooms + 1) + minRooms;

        Set<Room> rooms = new HashSet<>();
        for (int i = 0; i < numRooms; i++) {
            Room room = new Room();
            // Set room properties
            room.setRoomNumber(i + 1); // Adjust as needed
            room.setNumberOfBeds(random.nextInt(maxBeds - minBeds + 1) + minBeds);
            room.setRoomPrice(random.nextDouble() * 100); // Adjust as needed
            room.setHotel(hotel);
            room.setCreated(LocalDateTime.now());
            room.setUpdated(LocalDateTime.now());

            rooms.add(roomRepository.save(room));
        }

        return rooms;
    }
}

