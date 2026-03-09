package com.nexus.nexusrpg.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record LoginDTO(

        @Schema(description = "Endereço de email cadastrado")
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @Schema(description = "Senha de acesso vinculada ao endereço de email")
        @NotBlank(message = "A senha é obrigatória")
        String senha
) {}