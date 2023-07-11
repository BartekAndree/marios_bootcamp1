package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.repository.Marios;
import com.deloitte.ads.marios.service.MariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marios")
public class MariosController {

    @Autowired
    private MariosService mariosService;

    @GetMapping("")
    public List<Marios> getMarios() {
        return mariosService.getAllMarios();
    }
    @GetMapping("/{userId}/received")
    public List<Marios> getReceivedMariosByUserId(@PathVariable int userId) {
        return mariosService.getUserReceivedMarios(userId);
    }
    @GetMapping("/{userId}/given")
    public List<Marios> getGivenMariosByUserId(@PathVariable int userId) {
        return mariosService.getUserGivenMarios(userId);
    }


}
