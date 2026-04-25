package com.nexus.nexusrpg.domain.controller.dto.attempt;

import jakarta.validation.constraints.NotEmpty;

public record AttemptRequestDTO(

        @NotEmpty
        Long questionId,
        
        @NotEmpty
        Long alternativeId
) {
}
