package com.lcwd.hotel.service.HotelService.Controller;

import com.lcwd.hotel.service.HotelService.Entities.Hotel;
import com.lcwd.hotel.service.HotelService.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // 1. Add New Hotel
    @PostMapping("/addHotel")
    public ResponseEntity<String> createHotel(@RequestBody Hotel hotel) {
        String response = hotelService.createHotel(hotel);
        return ResponseEntity.ok(response);
    }

    // 2. Get All Hotels
    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    // 3. Get Hotel by ID
    @GetMapping("getHotel/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        try {
            Hotel hotel = hotelService.getHotelById(hotelId);
            return ResponseEntity.ok(hotel);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // 4. Delete Hotel by ID
    @DeleteMapping("deleteHotel/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable String hotelId) {
        try {
            String response = hotelService.deleteHotel(hotelId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

