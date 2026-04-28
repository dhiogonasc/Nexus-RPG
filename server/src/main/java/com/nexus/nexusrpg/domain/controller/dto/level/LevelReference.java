package com.nexus.nexusrpg.domain.controller.dto.level;

import com.nexus.nexusrpg.domain.model.enums.LevelLabel;

public record LevelReference(
        Long id,
        LevelLabel name,
        Long xpBonus,
        Long xpRequired
) {
}
