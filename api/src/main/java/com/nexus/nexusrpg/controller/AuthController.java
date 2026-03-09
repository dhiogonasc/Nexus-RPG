package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.request.LoginDTO;
import com.nexus.nexusrpg.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Endpoints para gerenciamento de sessão de usuário")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

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
            @Parameter(description = "Campos de login: credenciais")
            @RequestBody LoginDTO dto
    ) {

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        Authentication auth = authenticationManager.authenticate(authToken);

        String token = tokenService.gerarToken(auth.getName());

        return ResponseEntity.ok(token);
    }
}