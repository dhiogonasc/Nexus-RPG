package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.auth.request.LoginRequestDTO;
import com.nexus.nexusrpg.controller.dto.auth.request.RegisterRequestDTO;
import com.nexus.nexusrpg.controller.dto.auth.response.LoginResponseDTO;
import com.nexus.nexusrpg.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    @Operation(summary = "Cadastro")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequestDTO request) {

        authService.register(request);

        return ResponseEntity.status(CREATED).build();
    }
}
