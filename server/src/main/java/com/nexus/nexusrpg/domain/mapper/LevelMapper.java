package com.nexus.nexusrpg.domain.mapper;

import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.controller.dto.level.LevelDTO;
import com.nexus.nexusrpg.domain.model.Level;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper implements Mapper<Level, LevelDTO> {

    @Override
    public LevelDTO toDTO(Level level) {

        return new LevelDTO(
                level.getId(),
                level.getName(),
                level.getDescription()
        );
    }
}