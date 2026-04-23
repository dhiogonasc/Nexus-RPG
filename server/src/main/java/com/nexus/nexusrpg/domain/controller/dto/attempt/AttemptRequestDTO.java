package com.nexus.nexusrpg.domain.controller.dto.attempt;

public record AttemptRequestDTO(
        Long questionId,
        Long alternativeId
) {
}
