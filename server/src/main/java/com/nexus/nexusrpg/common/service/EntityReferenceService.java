package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.mapper.task.TaskMapper;
import com.nexus.nexusrpg.domain.model.relation.execution.Executable;
import com.nexus.nexusrpg.domain.repository.relation.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class EntityReferenceService<UEntity extends Executable> {

    protected final Context context;
    protected final UserEntityRepository<UEntity> userEntityRepository;
    protected final TaskMapper<UEntity> taskMapper;

    @Transactional(readOnly = true)
    public TaskDTO getAll() {
        var user = context.getAuthenticatedUser();
        return taskMapper.map(userEntityRepository.findByUserId(user.getId()));
    }
}