package com.nexus.nexusrpg.common.entity.mapper;

public interface Mapper<Entity, EntityDTO> {

    EntityDTO toDTO(Entity entity);
}
