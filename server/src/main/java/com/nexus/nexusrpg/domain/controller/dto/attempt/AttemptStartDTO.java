package com.nexus.nexusrpg.domain.controller.dto.attempt;

import jakarta.validation.constraints.NotNull;

public record AttemptStartDTO(
        @NotNull(message = "Campo obrigatório")
        Long missionId
) {
}
