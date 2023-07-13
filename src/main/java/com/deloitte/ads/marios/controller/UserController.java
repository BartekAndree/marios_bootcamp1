package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.dto.UserDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public Iterable<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/{userId}/received")
    public List<Marios> getReceivedMariosByUserId(@PathVariable Long userId) {
        return userService.getUserReceivedMarios(userId);
    }

    @GetMapping("/{userId}/given")
    public List<Marios> getGivenMariosByUserId(@PathVariable Long userId) {
        return userService.getUserGivenMarios(userId);
    }
}
