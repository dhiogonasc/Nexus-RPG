package com.nexus.nexusrpg.domain.level.mapper;

import com.nexus.nexusrpg.domain.level.controller.dto.LevelDTO;
import com.nexus.nexusrpg.domain.level.model.Level;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    LevelDTO toDTO(Level level);
}