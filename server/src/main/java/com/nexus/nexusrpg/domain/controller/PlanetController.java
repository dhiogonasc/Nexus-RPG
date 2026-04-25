package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.controller.dto.PlanetDetail;
import com.nexus.nexusrpg.domain.service.fetch.detail.PlanetDetailService;
import com.nexus.nexusrpg.domain.service.fetch.reference.PlanetReferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planets")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetReferenceService referenceService;
    private final PlanetDetailService detailService;

    @GetMapping
    public ResponseEntity<TaskDTO> getPlanets() {
        return ResponseEntity.ok(referenceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDetail> getPlanet(@PathVariable Long id) {
        return ResponseEntity.ok(detailService.getById(id));
    }
}
