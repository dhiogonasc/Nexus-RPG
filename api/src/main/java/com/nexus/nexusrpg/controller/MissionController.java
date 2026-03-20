package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.service.MissionService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public ResponseEntity<List<UserMissionReferenceDTO>> getMissions() {

        return ResponseEntity.ok(missionService.getMissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMissionDTO> getMission(@PathVariable Long id) {

        return ResponseEntity.ok(missionService.getMission(id));
    }
}