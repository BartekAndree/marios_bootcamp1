package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.dto.MariosDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.service.MariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marios")
public class MariosController {

    @Autowired
    private MariosService mariosService;

    @GetMapping("")
    public Iterable<Marios> getMarios() {
        return mariosService.getAllMarios();
    }
    @PostMapping("/create")
    public void createMarios(@RequestBody MariosDTO mariosDTO){
        mariosService.addMarios(mariosDTO);
    }
    @GetMapping("/{mariosId}")
    public Marios getMariosById(@PathVariable Long mariosId){
        return mariosService.findMariosById(mariosId);
    }

}