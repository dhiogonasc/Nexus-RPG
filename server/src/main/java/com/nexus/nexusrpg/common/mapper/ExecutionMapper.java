package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.task.ExecutionDTO;
import com.nexus.nexusrpg.domain.model.relation.execution.Executable;
import org.springframework.stereotype.Component;

@Component
public class ExecutionMapper<T extends Executable> implements Mapper<T, ExecutionDTO> {

    @Override
    public ExecutionDTO map(T entity){
        return new ExecutionDTO(
                entity.getStatus(),
                entity.isCurrent()
        );
    }
}
