package com.nexus.nexusrpg.controller.dto.auth.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.*;

@Tag(name = "Login Request DTO", description = "Credenciais de acesso")
public record LoginRequestDTO(

        @Schema(description = "Endereço de e-mail cadastrado")
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @Schema(description = "Senha de acesso vinculada ao endereço de email")
        @NotBlank(message = "A senha é obrigatória")
        String password
) {}