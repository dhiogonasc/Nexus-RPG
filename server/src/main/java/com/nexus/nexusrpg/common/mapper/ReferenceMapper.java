package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.MapTask;
import com.nexus.nexusrpg.common.dto.ProgressDTO;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class ReferenceMapper<Entity, UserEntity, UserEntityRefDTO extends Task> {

    private final MapTask<UserEntityRefDTO> mapTask;

    public UserEntityRefDTO mapReference(User user, Entity entity) {
        return toRefDTO(findRelation(user, entity));
    }

    public TaskDTO<UserEntityRefDTO> mapTasks(User user, List<Entity> entities) {

        var tasks = entities.stream()
                .map(e -> mapReference(user, e))
                .toList();

        return new TaskDTO<>(tasks, mapTask.mapProgress(tasks));
    }

    public abstract UserEntityRefDTO toRefDTO(UserEntity userEntity);
    protected abstract UserEntity findRelation(User user, Entity entity);
}