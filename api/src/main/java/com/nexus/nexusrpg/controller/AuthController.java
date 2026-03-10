package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.controller.dto.response.RegisterResponseDTO;
import com.nexus.nexusrpg.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/auth")
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
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Parameter(description = "Credenciais de acesso")
            @RequestBody LoginRequestDTO dto
    ) {

        LoginResponseDTO token = authService.auth(dto);

        return ResponseEntity
                .ok(token);
    }

    @PostMapping("/register")
    @Operation(summary = "Criar novo usuário", description = "Cadastra um novo usuário no sistema")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    public ResponseEntity<RegisterResponseDTO> criar(
            @Parameter(description = "Campos de cadastro de usuário")
            @Valid @RequestBody RegisterRequestDTO dto
    ) {

        return ResponseEntity
                .status(CREATED)
                .body(authService.create(dto));
    }
}