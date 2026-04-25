package com.nexus.nexusrpg.common.mapper;

import com.nexus.nexusrpg.common.state.State;
import com.nexus.nexusrpg.common.task.ExecutionDTO;
import org.springframework.stereotype.Component;

@Component
public class ExecutionMapper<T extends State> {

    public ExecutionDTO map(T entity){
        return new ExecutionDTO(
                entity.getStatus(),
                entity.isCurrent()
        );
    }
}
