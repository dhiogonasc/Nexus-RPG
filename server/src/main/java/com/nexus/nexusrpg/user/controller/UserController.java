package com.nexus.nexusrpg.user.controller;

import com.nexus.nexusrpg.user.controller.dto.UserDTO;
import com.nexus.nexusrpg.common.context.Context;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/me")
@RequiredArgsConstructor
public class UserController {

    private final Context context;

    @GetMapping
    public ResponseEntity<UserDTO> getMe() {
        return ResponseEntity.ok(context.getProfile());
    }
}
