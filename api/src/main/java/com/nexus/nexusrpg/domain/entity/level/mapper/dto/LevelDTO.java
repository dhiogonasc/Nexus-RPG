package com.nexus.nexusrpg.domain.entity.level.mapper.dto;

import com.nexus.nexusrpg.domain.entity.level.model.enums.LevelLabel;

public record LevelDTO(

        Long id,
        LevelLabel name,
        String description,
        int order,
        long xpRequired
) {}
