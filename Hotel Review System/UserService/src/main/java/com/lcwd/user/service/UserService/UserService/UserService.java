package com.lcwd.user.service.UserService.UserService;

import com.lcwd.user.service.UserService.Entities.Hotel;
import com.lcwd.user.service.UserService.Entities.Rating;
import com.lcwd.user.service.UserService.Entities.User;
import com.lcwd.user.service.UserService.ExternalServices.HotelServices;
import com.lcwd.user.service.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //All User-Operations -

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;

    //1.create user
    public String addUser(User user)
    {
        User newUser = userRepository.save(user);
        return "New User has been added in UserDB";
    }

    //2.Get all users
    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    //3.Get Single user from given userId
    public User getFromUserId(String userId) throws Exception
    {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty())
        {
             throw new Exception("User not Found!!!");
        }

        User user = optionalUser.get(); //when user found

        //fetch Ratings of the above user from Rating-Service
        //http://localhost:8084/ratings/getAllHotelsByUserId/12345
        //1.Using Rest Template
        //ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8084/ratings/getAllHotelsByUserId/12345", ArrayList.class); //static way fixed user id

        //dynamic userId

        Rating[] ratingsArray = restTemplate.getForObject(
                "http://RATINGSERVICE/ratings/getAllHotelsByUserId/" + user.getUserId(),
                Rating[].class);


        List<Rating> ratings = Arrays.asList(ratingsArray);

        // Fetch Hotel from Rating
        ratings.forEach(rating -> {

//            Hotel hotel = restTemplate.getForObject(
//                    "http://HOTELSERVICE/hotels/getHotel/" + rating.getHotelId(),
//                    Hotel.class);

            Hotel hotel = hotelServices.getHotel(rating.getHotelId()); //using feign client
            rating.setHotel(hotel);
        });

        // Set ratings to user
        user.setRatings(ratings);
        return user;

    }

    //4.Delete User from db
    public String deleteUser(String userId) throws Exception
    {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty())
        {
            throw new Exception("User not Found!!!");
        }

        User user = optionalUser.get(); //when user found
        userRepository.delete(user);

        return "user has been deleted succesfully from db!!!";
    }

    //5.Update user data...make it later
}
