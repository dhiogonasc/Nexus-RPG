package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.task.ExecutionDTO;
import com.nexus.nexusrpg.domain.model.relation.execution.Execution;
import org.springframework.stereotype.Component;

@Component
public class ExecutionMapper<T extends Execution> implements Mapper<T, ExecutionDTO> {

    @Override
    public ExecutionDTO map(T entity){
        return new ExecutionDTO(
                entity.getStatus(),
                entity.isCurrent()
        );
    }
}
