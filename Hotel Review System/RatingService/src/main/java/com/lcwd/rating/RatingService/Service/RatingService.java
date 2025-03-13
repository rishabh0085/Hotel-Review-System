package com.lcwd.rating.RatingService.Service;

import com.lcwd.rating.RatingService.Entities.Rating;
import com.lcwd.rating.RatingService.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    //1.create Rating
    public String createRating(Rating rating)
    {
        Rating newRating = ratingRepository.save(rating);
        return "New Rating is created with rating Id : "+newRating.getRatingId();
    }

    //2.Get All Ratings
    public List<Rating> getAllRatings()
    {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingList;
    }

    //3. get All Rating By HotelId
    public List<Rating> getAllRatingByHotelId(String hotelId) throws Exception
    {
         List<Rating> ratingList = ratingRepository.findByHotelId(hotelId);
         return ratingList;
    }

    //4. get All Rating By UserId
    public List<Rating> getAllRatingByUserId(String userId)
    {
        List<Rating> ratingList = ratingRepository.findByUserId(userId);
        return ratingList;
    }

}
