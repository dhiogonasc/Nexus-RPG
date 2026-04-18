package com.nexus.nexusrpg.common.entity.interfaces;

public interface Mapper<Entity, EntityDTO> {

    EntityDTO toDTO(Entity entity);
}
