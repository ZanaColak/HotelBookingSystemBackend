package com.example.hotelbookingsystembackend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ListHotelDto {
    private int id;
    private String hotelName;
    private String street;
    private int numberOfRooms;

}
