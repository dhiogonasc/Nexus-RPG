package com.nexus.nexusrpg.domain.entity.mission.controller;

import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserResponseDTO;
import com.nexus.nexusrpg.domain.entity.mission.service.ExecuteMission;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserAttemptDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserMissionReferenceDTO;
import com.nexus.nexusrpg.domain.entity.mission.service.GetMission;
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
    public ResponseEntity<UserAttemptDTO> start(@PathVariable Long id) {

        return ResponseEntity.ok(executeMission.start(id));
    }

    @PutMapping("attempts/{id}/answer")
    public ResponseEntity<Void> finish(@PathVariable Long id, UserResponseDTO request) {

        return ResponseEntity.ok(executeMission.answer(id, request));
    }

    @PutMapping("attempts/{id}")
    public ResponseEntity<UserAttemptDTO> finish(@PathVariable Long id) {

        return ResponseEntity.ok(executeMission.finish(id));
    }
}