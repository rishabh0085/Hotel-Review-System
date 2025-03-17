package com.lcwd.rating.RatingService.Repository;

import com.lcwd.rating.RatingService.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {

    List<Rating> findByHotelId(String hotelId);
    List<Rating> findByUserId(String userId);

}
