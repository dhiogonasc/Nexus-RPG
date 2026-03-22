package com.nexus.nexusrpg.domain.mission.controller;

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
    public ResponseEntity<Void> start(@PathVariable Long id) {

        missionService.start(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("attempts/{id}")
    public ResponseEntity<Void> finish(@PathVariable Long id) {

        missionService.finish(id);

        return ResponseEntity.ok().build();
    }
}