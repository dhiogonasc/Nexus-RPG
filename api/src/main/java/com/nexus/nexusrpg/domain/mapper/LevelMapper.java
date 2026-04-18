package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.domain.controller.dto.level.LevelDTO;
import com.nexus.nexusrpg.domain.controller.dto.level.LevelRefDTO;
import com.nexus.nexusrpg.domain.model.Level;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper {

    public LevelDTO toDTO(Level level) {

        return new LevelDTO(
                level.getId(),
                level.getName(),
                level.getDescription(),
                level.getOrder(),
                level.getXpBonus(),
                level.getXpRequired()
        );
    }

    public LevelRefDTO toReferenceDTO(Level level){

        return new LevelRefDTO(
                level.getId(),
                level.getName()
        );
    }

}