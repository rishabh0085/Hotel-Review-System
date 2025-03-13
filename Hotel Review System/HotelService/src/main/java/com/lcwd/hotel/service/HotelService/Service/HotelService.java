package com.lcwd.hotel.service.HotelService.Service;

import com.lcwd.hotel.service.HotelService.Entities.Hotel;
import com.lcwd.hotel.service.HotelService.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    //1.Add New Hotel Api
    public String createHotel(Hotel hotel)
    {
        Hotel newHotel = hotelRepository.save(hotel);
        return "New Hotel has been added in db with hotel id : "+newHotel.getHotelId();
    }

    //2.Get All Hotels List
    public List<Hotel> getAllHotels()
    {
        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList;
    }

    //3.Get Hotel By hotelId
    public Hotel getHotelById(String hotelId) throws Exception
    {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if(optionalHotel.isEmpty())
        {
            throw new Exception("Hotel not Found!!!");
        }

        Hotel hotel = optionalHotel.get();
        return hotel;

    }

    //4. Delete Hotel by HotelId
    public String deleteHotel(String hotelId) throws Exception
    {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        if(optionalHotel.isEmpty())
        {
            throw new Exception("Hotel not Found!!!");
        }

        Hotel hotel = optionalHotel.get();

        hotelRepository.delete(hotel);

        return "Hotel with ID : "+hotelId+" has been deleted successfully from db!!!";
    }

}
