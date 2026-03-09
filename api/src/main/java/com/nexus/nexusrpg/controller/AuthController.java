package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.request.LoginDTO;
import com.nexus.nexusrpg.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Endpoints para gerenciamento de sessão de usuário")
public class AuthController {

    private final AuthService authService;

    @Operation(
            summary = "Realizar login",
            description = "Autentica o usuário através de email e senha e retorna um token JWT para acesso a rotas protegidas."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso. Retorna o token JWT."),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas ou usuário não autorizado."),
            @ApiResponse(responseCode = "400", description = "Erro de validação nos dados fornecidos.")
    })
    @PostMapping
    public ResponseEntity<String> login(
            @Parameter(description = "Credenciais de acesso")
            @RequestBody LoginDTO dto
    ) {

        String token = authService.autenticar(dto);

        return ResponseEntity.ok(token);
    }
}