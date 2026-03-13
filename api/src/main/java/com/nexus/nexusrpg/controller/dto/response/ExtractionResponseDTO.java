package com.nexus.nexusrpg.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta do servidor após a tentativa de extração do jogador")
public record ExtractionResponseDTO(

        @Schema(description = "Indica se o jogador escolheu o bloco de código correto")
        boolean correct,

        @Schema(description = "Mensagem de feedback geral sobre o tiro")
        String message,

        @Schema(description = "Dica construtiva da IA da nave (será nulo se o jogador acertar)")
        String feedbackTip,

        @Schema(description = "Quantidade de XP ganho na extração")
        int xpEarned,

        @Schema(description = "ID do nível atualizado do jogador")
        Long currentLevelId,

        @Schema(description = "Nome do recurso extraído e guardado no inventário (nulo se errar)")
        String extractedResourceName

) {}