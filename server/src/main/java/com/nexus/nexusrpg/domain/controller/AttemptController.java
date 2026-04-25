package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.AttemptStartDTO;
import com.nexus.nexusrpg.domain.controller.dto.response.AttemptResponseDTO;
import com.nexus.nexusrpg.domain.service.AttemptService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attempts")
@RequiredArgsConstructor
public class AttemptController {

    private final AttemptService attemptService;

    @PostMapping
    public ResponseEntity<AttemptResponseDTO> start(@Valid @RequestBody AttemptStartDTO request){
        return ResponseEntity.ok(attemptService.start(request));
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<AttemptResponseDTO> finish(
            @PathVariable Long id,
            @Valid @RequestBody List<AttemptRequestDTO> request){
        return ResponseEntity.ok(attemptService.finish(id, request));
    }
}