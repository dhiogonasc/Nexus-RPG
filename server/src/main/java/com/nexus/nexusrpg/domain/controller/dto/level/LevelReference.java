package com.nexus.nexusrpg.domain.controller.dto.level;

public record LevelReference(
        Long id,
        String name,
        Long xpBonus,
        Long xpRequired
) {
}
