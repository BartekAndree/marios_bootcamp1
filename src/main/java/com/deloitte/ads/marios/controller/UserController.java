package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.dto.UserDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public Set<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/id/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/email/{userEmail}")
    public User getUserByEmail(@PathVariable String userEmail) {
        return userService.findUserByEmail(userEmail);
    }
    @PostMapping("/create")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

    @GetMapping("/id/{userId}/received")
    public List<Marios> getUserGivenMarios(@PathVariable Long userId) {
        return userService.getUserReceivedMarios(userId);
    }

    @GetMapping("/id/{userId}/given")
    public List<Marios> getUserReceivedMarios(@PathVariable Long userId) {
        return userService.getUserGivenMarios(userId);
    }
    @GetMapping("/id/{userId}/marios")
    public List<Marios> getUserAllMarios(@PathVariable Long userId) {
        return userService.getUserAllMarios(userId);
    }
}
