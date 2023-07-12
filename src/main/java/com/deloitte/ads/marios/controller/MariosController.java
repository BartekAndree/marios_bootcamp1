package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.repository.Marios;
import com.deloitte.ads.marios.service.MyService;
import com.deloitte.ads.marios.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marios")
public class MariosController {

    @Autowired
    private MyService myService;

    @GetMapping("")
    public List<Marios> getMarios() {
        return myService.getAllMarios();
    }
    @PostMapping("/create")
    public void createMarios(@RequestBody MariosDTO mariosDTO){
        myService.addMarios(mariosDTO.getSenderId(),
                mariosDTO.getReceiverId(),
                mariosDTO.getType(),
                mariosDTO.getComment());
    }
    @GetMapping("/{mariosId}")
    public Marios getMariosById(@PathVariable int mariosId){
        return myService.findMariosById(mariosId);
    }

}