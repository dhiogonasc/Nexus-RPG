package com.nexus.nexusrpg.domain.controller.dto.attempt;
import jakarta.validation.constraints.NotNull;

public record AttemptRequestDTO(

        @NotNull(message = "Campo obrigatório")
        Long questionId,

        @NotNull(message = "Campo obrigatório")
        Long alternativeId
) {
}
