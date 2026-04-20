package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.domain.entity.planet.service.GetPlanet;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTO;
import com.nexus.nexusrpg.domain.controller.dto.planet.UPlanetDTOR;

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
    public ResponseEntity<List<UPlanetDTOR>> getPlanets() {
        return ResponseEntity.ok(getPlanet.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UPlanetDTO> getPlanet(@PathVariable Long id) {
        return ResponseEntity.ok(getPlanet.getById(id));
    }
}
