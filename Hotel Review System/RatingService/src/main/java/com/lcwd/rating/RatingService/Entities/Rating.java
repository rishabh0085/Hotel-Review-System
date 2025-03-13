package com.lcwd.rating.RatingService.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rating")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ratingId;

    private String userId;

    private String hotelId;

    private int rating;

    private String feedback;

}
