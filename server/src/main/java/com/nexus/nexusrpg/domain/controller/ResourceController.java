package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.controller.dto.UResourceDTO;
import com.nexus.nexusrpg.domain.service.get.ResourceGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceGetService resourceGetService;

    @GetMapping
    public ResponseEntity<TaskDTO<EntityReferenceDTO>> getResources() {
        return ResponseEntity.ok(resourceGetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UResourceDTO> getResource(@PathVariable Long id) {
        return ResponseEntity.ok(resourceGetService.getById(id));
    }
}