package com.nexus.nexusrpg.common.mapper;

public interface Mapper<Entity, EntityDTO> {
    EntityDTO map(Entity entity);
}
