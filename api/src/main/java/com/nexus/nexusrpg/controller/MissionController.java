package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.service.MissionService;
import lombok.*;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping
    public ResponseEntity<Page<UserMissionReferenceDTO>> getMissions(
            @RequestParam(required = false) Long planetId,
            @ParameterObject Pageable pageable) {

        Page<UserMissionReferenceDTO> missions = missionService.getMissions(planetId, pageable);
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMissionDTO> getMission(@PathVariable Long id) {

        return ResponseEntity.ok(missionService.getMission(id));
    }
}