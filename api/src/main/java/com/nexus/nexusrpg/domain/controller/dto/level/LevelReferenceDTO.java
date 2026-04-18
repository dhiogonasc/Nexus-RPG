package com.nexus.nexusrpg.domain.controller.dto.level;

import com.nexus.nexusrpg.domain.model.enums.LevelLabel;

public record LevelReferenceDTO(

        Long id,
        LevelLabel name
) {}
