package com.nexus.nexusrpg.user.controller.dto;

public record UserDTO(
        Long id,
        String username,
        String email,
        long xp,
        int oxygen,
        UserProgressionDTO progression
) {
}
