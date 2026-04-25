package com.nexus.nexusrpg.domain.mapper.task;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import com.nexus.nexusrpg.user.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class TaskMapper<Entity, UserEntity> {

    private final ReferenceMapper<Entity, UserEntity> referenceMapper;
    private final ProgressMapper progressMapper;

    public TaskDTO map(User user, List<Entity> entities) {
        var tasks = entities.stream()
                .map(e -> referenceMapper.map(user, e))
                .toList();

        return new TaskDTO(tasks, progressMapper.map(tasks));
    }
}
