package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.MissionDTO;
import com.nexus.nexusrpg.domain.service.fetch.detail.MissionDetailService;
import com.nexus.nexusrpg.domain.service.fetch.reference.MissionReferenceService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionReferenceService referenceService;
    private final MissionDetailService detailService;

    @GetMapping
    public ResponseEntity<TaskDTO<EntityReferenceDTO>> getMissions() {
        return ResponseEntity.ok(referenceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> getMission(@PathVariable Long id) {
        return ResponseEntity.ok(detailService.getById(id));
    }
}