package com.nexus.nexusrpg.domain.entity.planet.controller;

import com.nexus.nexusrpg.domain.entity.planet.service.GetPlanet;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetDTO;
import com.nexus.nexusrpg.domain.entity.planet.controller.dto.UserPlanetReferenceDTO;

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
    public ResponseEntity<List<UserPlanetReferenceDTO>> getPlanets() {

        return ResponseEntity.ok(getPlanet.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPlanetDTO> getPlanet(@PathVariable Long id) {

        return ResponseEntity.ok(getPlanet.getById(id));
    }
}
