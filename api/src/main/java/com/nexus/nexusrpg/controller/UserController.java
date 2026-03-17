package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Endpoints para gerenciamento de usuários")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    @Operation(summary = "Perfil de usuário")
    public ResponseEntity<UserResponseDTO> getMe() {

        UserResponseDTO me = userService.getMe();

        return ResponseEntity.ok(me);
    }
}
