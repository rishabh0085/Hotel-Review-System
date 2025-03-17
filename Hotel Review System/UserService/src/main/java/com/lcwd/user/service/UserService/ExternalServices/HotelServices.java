package com.lcwd.user.service.UserService.ExternalServices;

import com.lcwd.user.service.UserService.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelServices {

    @GetMapping("/hotels/getHotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId); //its implementation will be done automatically by springBoot on run time!!! you do not need to implement this.

}
