package com.nexus.nexusrpg.common.mapping.mapper;

import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class ReferenceMapper<Entity, UserEntity> {

    private final TaskMapper taskMapper;

    public EntityReferenceDTO mapReference(User user, Entity entity) {
        return toReferenceDTO(findRelation(user, entity));
    }

    public TaskDTO<EntityReferenceDTO> mapTasks(User user, List<Entity> entities) {
        var tasks = entities.stream()
                .map(e -> mapReference(user, e))
                .toList();

        return new TaskDTO<>(tasks, taskMapper.mapProgress(tasks));
    }

    public abstract EntityReferenceDTO toReferenceDTO(UserEntity userEntity);
    protected abstract UserEntity findRelation(User user, Entity entity);
}