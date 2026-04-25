package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.dto.EntityDynamicReference;
import com.nexus.nexusrpg.common.task.ProgressDTO;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.COMPLETED;

@Component
public class ProgressMapper implements Mapper<List<EntityDynamicReference>, ProgressDTO>{

    @Override
    public ProgressDTO map(List<EntityDynamicReference> tasks) {
        var completedTasks = tasks.stream()
                .filter(task -> COMPLETED.equals(task.status()))
                .count();

        return new ProgressDTO(completedTasks, tasks.size());
    }
}