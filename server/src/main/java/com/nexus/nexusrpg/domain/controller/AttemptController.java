package com.nexus.nexusrpg.domain.controller;

import com.nexus.nexusrpg.domain.controller.dto.attempt.request.AttemptAnswerRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.request.AttemptStartRequestDTO;
import com.nexus.nexusrpg.domain.controller.dto.attempt.response.AttemptResponseDTO;
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
    public ResponseEntity<AttemptResponseDTO> start(@Valid @RequestBody AttemptStartRequestDTO request){
        return ResponseEntity.ok(attemptService.start(request));
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<AttemptResponseDTO> finish(
            @PathVariable Long id,
            @Valid @RequestBody List<AttemptAnswerRequestDTO> request){
        return ResponseEntity.ok(attemptService.finish(id, request));
    }
}