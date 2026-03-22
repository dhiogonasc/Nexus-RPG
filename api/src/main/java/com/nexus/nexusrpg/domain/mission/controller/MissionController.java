package com.nexus.nexusrpg.domain.mission.controller;

import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionAttemptDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.mission.service.MissionService;
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

    @PostMapping("/{id}/attempts")
    public ResponseEntity<UserMissionAttemptDTO> start(@PathVariable Long id) {

        return ResponseEntity.ok(missionService.start(id));
    }

    @PutMapping("attempts/{id}")
    public ResponseEntity<UserMissionAttemptDTO> finish(@PathVariable Long id) {

        return ResponseEntity.ok(missionService.finish(id));
    }
}