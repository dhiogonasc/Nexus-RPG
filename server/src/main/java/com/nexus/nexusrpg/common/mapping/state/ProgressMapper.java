package com.nexus.nexusrpg.common.mapping.state;

import com.nexus.nexusrpg.common.dto.EntityReferenceDTO;
import com.nexus.nexusrpg.common.dto.ProgressDTO;
import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProgressMapper {

    public ProgressDTO map(List<EntityReferenceDTO> tasks) {
        var completedTasks = tasks.stream()
                .filter(task -> EntityStatus.COMPLETED.equals(task.status()))
                .count();

        return new ProgressDTO(completedTasks, tasks.size());
    }
}