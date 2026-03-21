package com.nexus.nexusrpg.controller.dto.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record QuestionDTO(

        Long id,
        Long missionId,
        String description,
        String codeSnippet,
        Integer order
) {
}