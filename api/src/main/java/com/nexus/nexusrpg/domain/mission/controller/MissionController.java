package com.nexus.nexusrpg.domain.mission.controller;

import com.nexus.nexusrpg.domain.mission.service.ExecuteMission;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionAttemptDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.mission.service.GetMission;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final GetMission getMission;
    private final ExecuteMission executeMission;

    @GetMapping
    public ResponseEntity<List<UserMissionReferenceDTO>> getMissions() {

        return ResponseEntity.ok(getMission.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMissionDTO> getMission(@PathVariable Long id) {

        return ResponseEntity.ok(getMission.getById(id));
    }

    @PostMapping("/{id}/attempts")
    public ResponseEntity<UserMissionAttemptDTO> start(@PathVariable Long id) {

        return ResponseEntity.ok(executeMission.start(id));
    }

    @PutMapping("attempts/{id}")
    public ResponseEntity<UserMissionAttemptDTO> finish(@PathVariable Long id) {

        return ResponseEntity.ok(executeMission.finish(id));
    }
}