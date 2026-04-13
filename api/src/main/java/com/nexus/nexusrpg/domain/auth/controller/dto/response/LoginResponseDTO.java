package com.nexus.nexusrpg.domain.auth.controller.dto.response;

import java.time.Instant;

public record LoginResponseDTO (

        String accessToken,
        Long expiresIn,
        Instant loggedInAt
) {
}
