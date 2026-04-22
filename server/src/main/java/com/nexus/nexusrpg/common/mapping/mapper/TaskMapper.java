package com.nexus.nexusrpg.common.mapping.mapper;

import com.nexus.nexusrpg.common.dto.ProgressDTO;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper<Entity extends Task> {

    public ProgressDTO mapProgress(List<Entity> tasks) {
        var completedTasks = tasks.stream()
                .filter(task -> EntityStatus.COMPLETED.equals(task.status()))
                .count();

        return new ProgressDTO(completedTasks, tasks.size());
    }
}
