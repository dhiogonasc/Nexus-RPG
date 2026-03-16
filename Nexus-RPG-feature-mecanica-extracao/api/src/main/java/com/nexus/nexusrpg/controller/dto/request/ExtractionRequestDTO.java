package com.nexus.nexusrpg.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Dados enviados pelo app para tentar extrair um recurso")
public record ExtractionRequestDTO(

        @Schema(description = "ID do explorador (usuário) que está jogando")
        @NotNull(message = "O ID do usuário é obrigatório")
        Long userId,

        @Schema(description = "ID da ferramenta (alternativa) escolhida para a extração")
        @NotNull(message = "O ID da alternativa é obrigatório")
        Long alternativeId

) {}