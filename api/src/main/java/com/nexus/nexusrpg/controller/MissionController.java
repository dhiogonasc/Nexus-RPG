package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.mission.MissionDTO;
import com.nexus.nexusrpg.service.MissionService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public ResponseEntity<List<MissionDTO>> getAll() {

        return ResponseEntity.ok(missionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> getMission(@PathVariable Long id) {

        return ResponseEntity.ok(missionService.getPlanet(id));
    }
}