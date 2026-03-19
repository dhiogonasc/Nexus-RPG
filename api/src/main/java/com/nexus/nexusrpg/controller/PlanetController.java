package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.service.PlanetService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    @GetMapping
    public ResponseEntity<List<PlanetDTO>> getAll() {

        return ResponseEntity.ok(planetService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(planetService.getPlanet(id));
    }
}
