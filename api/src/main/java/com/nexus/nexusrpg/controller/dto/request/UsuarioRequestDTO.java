package com.nexus.nexusrpg.controller.dto.request;

import com.nexus.nexusrpg.validator.EmailUnico;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record UsuarioRequestDTO(
        @Schema(description = "Nome de usuário")
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @Schema(description = "Endereço de email do usuário")
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        @EmailUnico(message = "E-mail já está sendo utilizado")
        String email,

        @Schema(description = "Senha de acesso do usuário")
        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        String senha
) {}
