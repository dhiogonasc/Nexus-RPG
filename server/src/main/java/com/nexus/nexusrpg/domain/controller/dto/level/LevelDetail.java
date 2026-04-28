package com.nexus.nexusrpg.domain.controller.dto.level;

public record LevelDetail(
        Long id,
        String name,
        String description,
        LevelReference next
) {
}
