package com.nexus.nexusrpg.mapper;

import com.nexus.nexusrpg.controller.dto.global.level.LevelDTO;
import com.nexus.nexusrpg.model.entity.Level;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    LevelDTO toDTO(Level level);
}