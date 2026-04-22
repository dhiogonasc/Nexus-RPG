package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.mapping.mapper.TaskMapper;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.mapping.mapper.ReferenceMapper;
import com.nexus.nexusrpg.common.repository.UEntityRepository;
import com.nexus.nexusrpg.common.mapping.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class GetEntity<Entity, UEntity, UEntityDTO, UEntityRDTO extends Task> {

    protected final Context context;
    protected final UEntityRepository<UEntity> userEntityRepository;
    protected final Mapper<UEntity, UEntityDTO> mapper;
    protected final ReferenceMapper<Entity, UEntity, UEntityRDTO> referenceMapper;
    private final TaskMapper<UEntityRDTO> taskMapper;

    @Transactional(readOnly = true)
    public UEntityDTO getById(Long id) {

        var userId = context.getAuthenticatedUser().getId();

        UEntity uEntity = userEntityRepository
                .findByUserIdAndEntityId(userId, id);

        validate(uEntity);

        return mapper.toDTO(uEntity);
    }

    @Transactional(readOnly = true)
    public TaskDTO<UEntityRDTO> getAll() {
        var userId = context.getAuthenticatedUser().getId();

        List<UEntity> userEntities = userEntityRepository.findByUserId(userId);

        List<UEntityRDTO> tasks = userEntities.stream()
                .map(referenceMapper::toRefDTO)
                .toList();

        return new TaskDTO<>(tasks, taskMapper.mapProgress(tasks));
    }

    protected abstract void validate(UEntity uEntity);
}