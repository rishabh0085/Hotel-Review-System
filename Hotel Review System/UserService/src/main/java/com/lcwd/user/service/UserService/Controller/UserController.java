package com.lcwd.user.service.UserService.Controller;

import com.lcwd.user.service.UserService.Entities.User;
import com.lcwd.user.service.UserService.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-service")
public class UserController {

    @Autowired
    private UserService userService;

    // 1. Create user
    @PostMapping("addUser")
    public ResponseEntity addUser(@RequestBody User user) {
        String result = userService.addUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 2. Get all users
    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    // 3. Get Single user from given userId
    @GetMapping("getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        try
        {
            User user = userService.getFromUserId(userId);
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // 4. Delete User from db
    @DeleteMapping("deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        try {
            String ans = userService.deleteUser(userId);
            return new ResponseEntity<>(ans, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // 5. Update user data

}

