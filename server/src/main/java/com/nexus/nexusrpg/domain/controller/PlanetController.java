package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.service.get.PlanetGetService;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDTO;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetGetService planetGetService;

    @GetMapping
    public ResponseEntity<TaskDTO<EntityReferenceDTO>> getPlanets() {
        return ResponseEntity.ok(planetGetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> getPlanet(@PathVariable Long id) {
        return ResponseEntity.ok(planetGetService.getById(id));
    }
}
