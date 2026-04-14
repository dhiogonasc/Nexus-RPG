package com.nexus.nexusrpg.domain.user.controller;

import com.nexus.nexusrpg.domain.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.domain.user.service.UserFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/me")
@RequiredArgsConstructor
@Tag(name = "User", description = "Endpoints para gerenciamento de usuário")
public class UserController {

    private final UserFacade userFacade;

    @GetMapping
    @Operation(summary = "Perfil de usuário")
    public ResponseEntity<UserDTO> getMe() {

        return ResponseEntity.ok(userFacade.getAuthenticatedUserDTO());
    }
}
