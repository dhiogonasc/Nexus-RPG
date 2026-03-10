package com.nexus.nexusrpg.controller.dto.response;

import com.nexus.nexusrpg.controller.dto.LevelDTO;
import com.nexus.nexusrpg.controller.dto.UserDTO;
import com.nexus.nexusrpg.controller.dto.UserStatDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User Response DTO", description = "Retorno dos dados de usuário")
public record UserResponseDTO(

        @Schema(description = "Dados de usuário")
        UserDTO user,

        @Schema(description = "Level atual do usuário")
        LevelDTO level,

        @Schema(description = "Estatísticas de jogo")
        UserStatDTO stats
) {}
