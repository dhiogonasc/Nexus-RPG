package com.nexus.nexusrpg.domain.resource.controller;

import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceDTO;
import com.nexus.nexusrpg.domain.user.controller.dto.resource.UserResourceReferenceDTO;
import com.nexus.nexusrpg.domain.resource.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<UserResourceReferenceDTO>> getResources() {

        return ResponseEntity.ok(resourceService.getResources());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResourceDTO> getResource(@PathVariable Long id) {

        return ResponseEntity.ok(resourceService.getResource(id));
    }
}