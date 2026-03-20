package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.planet.PlanetDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetDTO;
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


    @GetMapping("/{id}")
    public ResponseEntity<UserPlanetDTO> getPlanet(@PathVariable Long id) {

        return ResponseEntity.ok(planetService.getPlanet(id));
    }
}
