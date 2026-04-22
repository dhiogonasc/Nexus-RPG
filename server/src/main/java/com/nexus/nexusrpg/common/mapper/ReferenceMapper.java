package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.dto.ProgressDTO;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class ReferenceMapper<Entity, UserEntity, UserEntityRefDTO extends Task> {

    public UserEntityRefDTO mapReference(User user, Entity entity) {
        return toRefDTO(findRelation(user, entity));
    }

    public TaskDTO<UserEntityRefDTO> mapTasks(User user, List<Entity> entities) {

        var tasks = entities.stream()
                .map(e -> mapReference(user, e))
                .toList();

        var progress = new ProgressDTO(
                tasks.stream()
                        .filter(task -> task.getStatus() == EntityStatus.COMPLETED)
                        .count(),
                tasks.size()
        );

        return new TaskDTO<>(tasks, progress);
    }

    public abstract UserEntityRefDTO toRefDTO(UserEntity userEntity);
    protected abstract UserEntity findRelation(User user, Entity entity);
}