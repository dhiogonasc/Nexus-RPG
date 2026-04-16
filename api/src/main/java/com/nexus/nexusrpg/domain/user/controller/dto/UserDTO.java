package com.nexus.nexusrpg.domain.user.controller.dto;

public record UserDTO(

        Long id,
        String username,
        String email,
        CurrentDTO current,
        long xp,
        int oxygen
) {
}
