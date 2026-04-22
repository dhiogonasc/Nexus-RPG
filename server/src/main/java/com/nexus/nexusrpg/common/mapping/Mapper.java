package com.nexus.nexusrpg.common.mapping;

public interface Mapper<Entity, EntityDTO> {
    EntityDTO toDTO(Entity entity);
}
