package com.nexus.nexusrpg.domain.entity.level.mapper.dto;

import com.nexus.nexusrpg.domain.entity.level.model.enums.LevelLabel;

public record LevelReferenceDTO(

        Long id,
        LevelLabel name
) {}
