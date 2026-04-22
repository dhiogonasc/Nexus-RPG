package com.nexus.nexusrpg.common.mapping.mapper;

import com.nexus.nexusrpg.common.dto.ProgressDTO;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper {

    public ProgressDTO mapProgress(List<EntityReferenceDTO> tasks) {
        var completedTasks = tasks.stream()
                .filter(task -> EntityStatus.COMPLETED.equals(task.status()))
                .count();

        return new ProgressDTO(completedTasks, tasks.size());
    }
}
