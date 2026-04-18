package com.nexus.nexusrpg.common.entity;

import com.nexus.nexusrpg.user.model.User;

import java.util.List;

public abstract class RefMapper<Entity, UserEntity, UserEntityRefDTO> {

    public UserEntityRefDTO map(User user, Entity entity) {
        if (entity == null) return null;
        return toRefDTO(findRelation(user, entity));
    }

    public List<UserEntityRefDTO> map(User user, List<Entity> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                .map(e -> map(user, e))
                .toList();
    }

    protected abstract UserEntityRefDTO toRefDTO(UserEntity userEntity);
    protected abstract UserEntity findRelation(User user, Entity entity);
}