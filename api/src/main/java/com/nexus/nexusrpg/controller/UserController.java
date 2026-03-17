package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.UserProfileDTO;
import com.nexus.nexusrpg.service.UserProfileService;
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

    private final UserProfileService userService;

    @GetMapping("/me")
    @Operation(summary = "Perfil de usuário")
    public ResponseEntity<UserProfileDTO> getMe() {

        return ResponseEntity.ok(userService.getMe());
    }
}
