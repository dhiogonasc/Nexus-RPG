package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UAttemptDTO;
import com.nexus.nexusrpg.domain.entity.mission.controller.dto.UserResponseDTO;
import com.nexus.nexusrpg.domain.entity.mission.service.ExecuteMission;
import com.nexus.nexusrpg.domain.controller.dto.UMissionDTO;
import com.nexus.nexusrpg.domain.service.get.MissionGetService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionGetService missionGetService;
    private final ExecuteMission executeMission;

    @GetMapping
    public ResponseEntity<TaskDTO<EntityReferenceDTO>> getMissions() {
        return ResponseEntity.ok(missionGetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UMissionDTO> getMission(@PathVariable Long id) {
        return ResponseEntity.ok(missionGetService.getById(id));
    }

    @PostMapping("/{id}/start")
    public ResponseEntity<UAttemptDTO> start(@PathVariable Long id) {
        return ResponseEntity.ok(executeMission.start(id));
    }

    @PostMapping("attempts/{id}/answer")
    public ResponseEntity<Void> answer(
            @PathVariable Long id,
            @Valid @RequestBody UserResponseDTO request
    ) {
        executeMission.answer(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("attempts/{id}/finish")
    public ResponseEntity<UAttemptDTO> finish(@PathVariable Long id) {
        return ResponseEntity.ok(executeMission.finish(id));
    }
}