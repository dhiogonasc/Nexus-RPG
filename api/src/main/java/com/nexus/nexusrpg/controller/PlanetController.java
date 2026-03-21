package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.user.planet.UserPlanetDTO;
import com.nexus.nexusrpg.controller.dto.user.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.service.PlanetService;
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

        return ResponseEntity.ok(planetService.getPlanets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPlanetDTO> getPlanet(@PathVariable Long id) {

        return ResponseEntity.ok(planetService.getPlanet(id));
    }
}
