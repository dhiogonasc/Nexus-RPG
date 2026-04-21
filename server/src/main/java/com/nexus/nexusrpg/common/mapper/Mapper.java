package com.nexus.nexusrpg.common.mapper;

public interface Mapper<Entity, EntityDTO> {
    EntityDTO toDTO(Entity entity);
}
