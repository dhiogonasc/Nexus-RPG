package com.nexus.nexusrpg.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.*;

@Tag(name = "Login DTO", description = "Credenciais de acesso")
public record LoginDTO(

        @Schema(name = "Email", description = "Endereço de email cadastrado")
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @Schema(name = "Senha",  description = "Senha de acesso vinculada ao endereço de email")
        @NotBlank(message = "A senha é obrigatória")
        String senha
) {}