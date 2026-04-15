package com.nexus.nexusrpg.domain.user.controller;

import com.nexus.nexusrpg.domain.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.common.context.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/me")
@RequiredArgsConstructor
public class UserController {

    private final UserContext userContext;

    @GetMapping
    public ResponseEntity<UserDTO> getMe() {

        return ResponseEntity.ok(userContext.getProfile());
    }
}
