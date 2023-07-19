package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.dto.MariosDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.service.MariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/marios")
public class MariosController {

    private final MariosService mariosService;

    @Autowired
    public MariosController(MariosService mariosService) {
        this.mariosService = mariosService;
    }

    @GetMapping("")
    public Set<MariosDTO> getAllMarios() {
        return mariosService.getAllMarios();
    }

    @GetMapping("/{mariosId}")
    public Marios getMariosById(@PathVariable Long mariosId) {
        return mariosService.findMariosById(mariosId);
    }

    @PostMapping("/create")
    public void createMarios(@RequestBody MariosDTO mariosDTO) {
        mariosService.addMarios(mariosDTO);
    }

    @DeleteMapping("/delete/{mariosId}")
    public void deleteMarios(@PathVariable Long mariosId) {
        mariosService.deleteMarios(mariosId);
    }
}