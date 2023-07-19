package com.deloitte.ads.marios.controller;

import com.deloitte.ads.marios.dto.MariosDTO;
import com.deloitte.ads.marios.entity.Marios;
import com.deloitte.ads.marios.service.MariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

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

    @GetMapping("/{mariosUuid}")
    public MariosDTO getMariosById(@PathVariable UUID mariosUuid) {
        return mariosService.findMariosById(mariosUuid);
    }

    @PostMapping("/create")
    public MariosDTO createMarios(@RequestBody MariosDTO mariosDTO) {
        Marios marios = mariosService.createMarios(mariosDTO);
        return mariosService.findMariosById(marios.getUuid());
    }

    @DeleteMapping("/delete/{mariosUuid}")
    public void deleteMarios(@PathVariable UUID mariosUuid) {
        mariosService.deleteMarios(mariosUuid);
    }
}