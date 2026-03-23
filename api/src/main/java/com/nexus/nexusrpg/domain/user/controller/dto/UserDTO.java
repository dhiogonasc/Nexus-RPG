package com.nexus.nexusrpg.domain.user.controller.dto;

import com.nexus.nexusrpg.domain.level.controller.dto.LevelDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User DTO")
public record UserDTO(

        @Schema(description = "Identificador do usuário")
        Long id,

        @Schema(description = "Nome de usuário")
        String username,

        @Schema(description = "Endereço de email")
        String email,

        @Schema(description = "Nível atual")
        LevelDTO level,

        @Schema(description = "Xp total do usuário")
        long xp,

        @Schema(description = "Quantidade de oxigênio disponível")
        int oxygen
) {
}
