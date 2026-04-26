package com.nexus.nexusrpg.domain.controller.dto.attempt.request;

import jakarta.validation.constraints.NotNull;

public record AttemptStartRequestDTO(

        @NotNull(message = "Campo obrigatório")
        Long missionId
) {
}
