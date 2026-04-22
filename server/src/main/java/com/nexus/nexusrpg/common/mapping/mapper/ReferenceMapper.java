package com.nexus.nexusrpg.common.mapping.mapper;

import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class ReferenceMapper<Entity, UserEntity, UserEntityRefDTO extends Task> {

    private final TaskMapper<UserEntityRefDTO> taskMapper;

    public UserEntityRefDTO mapReference(User user, Entity entity) {
        return toRefDTO(findRelation(user, entity));
    }

    public TaskDTO<UserEntityRefDTO> mapTasks(User user, List<Entity> entities) {
        var tasks = entities.stream()
                .map(e -> mapReference(user, e))
                .toList();

        return new TaskDTO<>(tasks, taskMapper.mapProgress(tasks));
    }

    public abstract UserEntityRefDTO toRefDTO(UserEntity userEntity);
    protected abstract UserEntity findRelation(User user, Entity entity);
}