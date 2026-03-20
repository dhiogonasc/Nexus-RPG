package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.UserDTO;
import com.nexus.nexusrpg.controller.dto.mission.UserMissionReferenceDTO;
import com.nexus.nexusrpg.controller.dto.planet.UserPlanetReferenceDTO;
import com.nexus.nexusrpg.service.AuthService;
import com.nexus.nexusrpg.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/me")
@RequiredArgsConstructor
@Tag(name = "User", description = "Endpoints para gerenciamento de usuário")
public class UserController {

    private final AuthService authService;
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Perfil de usuário")
    public ResponseEntity<UserDTO> getMe() {

        return ResponseEntity.ok(authService.getMe());
    }

    @GetMapping("/planets")
    public ResponseEntity<List<UserPlanetReferenceDTO>> getPlanets() {

        return ResponseEntity.ok(userService.getPlanets());
    }

    @GetMapping("/missions")
    public ResponseEntity<List<UserMissionReferenceDTO>> getMissions() {

        return ResponseEntity.ok(userService.getMissions());
    }
}
