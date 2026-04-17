package com.nexus.nexusrpg.domain.entity.level.mapper;

import com.nexus.nexusrpg.domain.entity.level.mapper.dto.LevelDTO;
import com.nexus.nexusrpg.domain.entity.level.mapper.dto.LevelReferenceDTO;
import com.nexus.nexusrpg.domain.entity.level.model.Level;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    LevelDTO toDTO(Level level);
    LevelReferenceDTO toReferenceDTO(Level level);

}