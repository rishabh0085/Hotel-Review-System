package com.lcwd.user.service.UserService.Entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    //for getting HotelId
    private Hotel hotel;

}
