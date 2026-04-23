package com.nexus.nexusrpg.domain.mapper.reference;

import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ReferenceMapper<Entity, UserEntity> {

    public EntityReferenceDTO map(User user, Entity entity) {
        return toReferenceDTO(findRelation(user, entity));
    }

    public abstract EntityReferenceDTO toReferenceDTO(UserEntity userEntity);
    protected abstract UserEntity findRelation(User user, Entity entity);
}