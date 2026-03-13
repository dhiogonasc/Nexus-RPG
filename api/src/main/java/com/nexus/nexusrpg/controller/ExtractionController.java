package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.request.ExtractionRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.ExtractionResponseDTO;
import com.nexus.nexusrpg.service.extraction.ProcessExtractionUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/extraction")
@Tag(name = "Gameplay: Extração", description = "Endpoints da mecânica principal de coletar recursos nos planetas")
public class ExtractionController {

    private final ProcessExtractionUseCase processExtractionUseCase;

    public ExtractionController(ProcessExtractionUseCase processExtractionUseCase) {
        this.processExtractionUseCase = processExtractionUseCase;
    }

    @PostMapping("/attempt")
    @Operation(summary = "Tentar extrair um recurso", 
               description = "Recebe a ferramenta (código) escolhida pelo jogador e processa se a extração foi um sucesso, calculando XP e loot.")

    public ResponseEntity<ExtractionResponseDTO> attemptExtraction(@Valid @RequestBody ExtractionRequestDTO request) {
        
        ExtractionResponseDTO response = processExtractionUseCase.execute(request);
        
        return ResponseEntity.ok(response);
    }
}