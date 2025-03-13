package com.lcwd.hotel.service.HotelService.Repository;

import com.lcwd.hotel.service.HotelService.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
}
