package com.nexus.nexusrpg.core.auth.controller;

import com.nexus.nexusrpg.core.auth.controller.dto.request.LoginRequestDTO;
import com.nexus.nexusrpg.core.auth.controller.dto.request.RegisterRequestDTO;
import com.nexus.nexusrpg.core.auth.controller.dto.response.LoginResponseDTO;
import com.nexus.nexusrpg.core.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequestDTO request) {
        authService.register(request);
        return ResponseEntity.status(CREATED).build();
    }
}
