package com.lcwd.rating.RatingService.Controller;

import com.lcwd.rating.RatingService.Entities.Rating;
import com.lcwd.rating.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // Create a new rating
    @PostMapping("createRating")
    public ResponseEntity<String> createRating(@RequestBody Rating rating) {
        String response = ratingService.createRating(rating);
        return ResponseEntity.ok(response);
    }

    // Get all ratings
    @GetMapping("getAllRatings")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    // Get ratings by hotel ID
    @GetMapping("/getAllHotelsByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) throws Exception {
        List<Rating> ratings = ratingService.getAllRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratings);
    }

    // Get ratings by user ID
    @GetMapping("/getAllHotelsByUserId/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = ratingService.getAllRatingByUserId(userId);
        return ResponseEntity.ok(ratings);
    }
}

