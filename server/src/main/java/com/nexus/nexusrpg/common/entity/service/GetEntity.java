package com.nexus.nexusrpg.common.entity.service;

import com.nexus.nexusrpg.common.MapTask;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.dto.Task;
import com.nexus.nexusrpg.common.dto.TaskDTO;
import com.nexus.nexusrpg.common.dto.ProgressDTO;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.common.mapper.ReferenceMapper;
import com.nexus.nexusrpg.common.entity.repository.UEntityRepository;
import com.nexus.nexusrpg.common.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class GetEntity<Entity, UEntity, UEntityDTO, UEntityRDTO extends Task> {

    protected final Context context;
    protected final UEntityRepository<UEntity> userEntityRepository;
    protected final Mapper<UEntity, UEntityDTO> mapper;
    protected final ReferenceMapper<Entity, UEntity, UEntityRDTO> referenceMapper;
    private final MapTask<UEntityRDTO> mapTask;

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

        return new TaskDTO<>(tasks, mapTask.mapProgress(tasks));
    }

    protected abstract void validate(UEntity uEntity);
}