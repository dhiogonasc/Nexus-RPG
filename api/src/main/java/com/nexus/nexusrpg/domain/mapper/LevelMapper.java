package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelDTO;
import com.nexus.nexusrpg.domain.controller.dto.level.LevelReferenceDTO;
import com.nexus.nexusrpg.domain.model.Level;

public class LevelMapper {

    public static LevelDTO toDTO(Level level) {

        return new LevelDTO(
                level.getId(),
                level.getName(),
                level.getDescription(),
                level.getOrder(),
                level.getXpBonus(),
                level.getXpRequired()
        );
    }

    public static LevelReferenceDTO toReferenceDTO(Level level){

        return new LevelReferenceDTO(
                level.getId(),
                level.getName()
        );
    }

}