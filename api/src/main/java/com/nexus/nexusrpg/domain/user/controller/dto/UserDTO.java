package com.nexus.nexusrpg.domain.user.controller.dto;

import com.nexus.nexusrpg.domain.level.controller.dto.LevelDTO;

public record UserDTO(

        Long id,
        String username,
        String email,
        LevelDTO level,
        long xp,
        int oxygen
) {
}
