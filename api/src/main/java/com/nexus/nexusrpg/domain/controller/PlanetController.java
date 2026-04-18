package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.domain.entity.planet.service.GetPlanet;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.PlanetRefDTO;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetController {

    private final GetPlanet getPlanet;

    @GetMapping
    public ResponseEntity<List<PlanetRefDTO>> getPlanets() {

        return ResponseEntity.ok(getPlanet.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> getPlanet(@PathVariable Long id) {

        return ResponseEntity.ok(getPlanet.getById(id));
    }
}
