package com.nexus.nexusrpg.domain.mapper.task;

import com.nexus.nexusrpg.common.mapper.DynamicReferenceMapper;
import com.nexus.nexusrpg.common.mapper.ProgressMapper;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.model.relation.execution.Executable;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class TaskMapper<UserEntity extends Executable> {

    private final DynamicReferenceMapper<UserEntity> referenceMapper;
    private final ProgressMapper progressMapper;

    public TaskDTO map(List<UserEntity> entities) {
        var tasks = entities.stream()
                .map(referenceMapper::map)
                .toList();

        var progress = progressMapper.map(tasks);

        return new TaskDTO(tasks, progress);
    }
}
