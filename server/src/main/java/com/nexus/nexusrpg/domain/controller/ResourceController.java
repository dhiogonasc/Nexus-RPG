package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceDTO;
import com.nexus.nexusrpg.domain.controller.dto.resource.UResourceRDTO;
import com.nexus.nexusrpg.domain.entity.resource.service.GetResource;
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

    private final GetResource getResource;

    @GetMapping
    public ResponseEntity<List<UResourceRDTO>> getResources() {
        return ResponseEntity.ok(getResource.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UResourceDTO> getResource(@PathVariable Long id) {
        return ResponseEntity.ok(getResource.getById(id));
    }
}