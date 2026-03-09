package com.nexus.nexusrpg.controller.dto.request;

import jakarta.validation.constraints.*;

public record LoginDTO(
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        String senha
) {}