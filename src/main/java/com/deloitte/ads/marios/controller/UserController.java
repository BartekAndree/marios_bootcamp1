package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.dto.MariosDTO;
import com.deloitte.ads.marios.dto.PublicUserDTO;
import com.deloitte.ads.marios.dto.UserDTO;
import com.deloitte.ads.marios.entity.User;
import com.deloitte.ads.marios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Set<PublicUserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userUuid}")
    public UserDTO getUserById(@PathVariable UUID userUuid) {
        return userService.showUser(userUuid);
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return userService.showUser(user.getUuid());
    }

    @DeleteMapping("/delete/{userUuid}")
    public void deleteUser(@PathVariable UUID userUuid) {
        userService.deleteUser(userUuid);
    }

    @GetMapping("/{userUuid}/received")
    public List<MariosDTO> getUserGivenMarios(@PathVariable UUID userUuid) {
        return userService.getUserReceivedMarios(userUuid);
    }

    @GetMapping("/{userUuid}/given")
    public List<MariosDTO> getUserReceivedMarios(@PathVariable UUID userUuid) {
        return userService.getUserGivenMarios(userUuid);
    }

    @GetMapping("/{userUuid}/marios")
    public List<MariosDTO> getUserAllMarios(@PathVariable UUID userUuid) {
        return userService.getUserAllMarios(userUuid);
    }
}
