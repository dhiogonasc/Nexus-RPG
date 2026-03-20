package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.service.MissionService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/{id}")
    public ResponseEntity<UserMissionDTO> getMission(@PathVariable Long id) {

        return ResponseEntity.ok(missionService.getMission(id));
    }
}