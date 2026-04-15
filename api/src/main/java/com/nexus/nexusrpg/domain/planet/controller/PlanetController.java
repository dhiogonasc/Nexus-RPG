package com.nexus.nexusrpg.domain.planet.controller;

import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.domain.planet.service.PlanetService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    @GetMapping
    public ResponseEntity<List<UserPlanetReferenceDTO>> getPlanets() {

        return ResponseEntity.ok(planetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPlanetDTO> getPlanet(@PathVariable Long id) {

        return ResponseEntity.ok(planetService.getById(id));
    }
}
