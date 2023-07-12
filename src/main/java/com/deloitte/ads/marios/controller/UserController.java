package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.repository.Marios;
import com.deloitte.ads.marios.repository.User;
import com.deloitte.ads.marios.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyService myService;

    @GetMapping("")
    public Set<User> getAllUsers(){
        return this.myService.getAllUsers();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDTO userDTO) {
        myService.addUser(userDTO.getFirstName(),
                userDTO.getLastName());
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId){
        return myService.findUserById(userId);
    }

    @GetMapping("/{userId}/received")
    public List<Marios> getReceivedMariosByUserId(@PathVariable int userId) {
        return myService.getUserReceivedMarios(userId);
    }

    @GetMapping("/{userId}/given")
    public List<Marios> getGivenMariosByUserId(@PathVariable int userId) {
        return myService.getUserGivenMarios(userId);
    }
}
