package com.nexus.nexusrpg.common.mapping;

import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.common.task.ProgressDTO;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.COMPLETED;

@Component
public class ProgressMapper {

    public ProgressDTO map(List<EntityReferenceDTO> tasks) {
        var completedTasks = tasks.stream()
                .filter(task -> COMPLETED.equals(task.status()))
                .count();

        return new ProgressDTO(completedTasks, tasks.size());
    }
}