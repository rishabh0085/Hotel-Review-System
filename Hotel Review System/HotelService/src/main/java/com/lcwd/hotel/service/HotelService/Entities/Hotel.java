package com.lcwd.hotel.service.HotelService.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String hotelId;

    private String hotelName;

    private String hotelLocation;

    private String about;

}
