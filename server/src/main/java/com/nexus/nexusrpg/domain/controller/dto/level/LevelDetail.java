package com.nexus.nexusrpg.domain.controller.dto.level;

import com.nexus.nexusrpg.domain.model.enums.LevelLabel;

public record LevelDetail(
        Long id,
        LevelLabel name,
        String description,
        LevelReference next
) {
}
