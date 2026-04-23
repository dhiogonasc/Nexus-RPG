package com.nexus.nexusrpg.domain.service.get;

import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.mapper.reference.ReferenceMapper;
import com.nexus.nexusrpg.common.task.EntityReferenceDTO;
import com.nexus.nexusrpg.domain.repository.relation.UserEntityRepository;
import com.nexus.nexusrpg.common.mapping.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class GetService<Entity, UEntity, UEntityDTO> {

    protected final Context context;
    protected final UserEntityRepository<UEntity> userEntityRepository;
    protected final Mapper<UEntity, UEntityDTO> mapper;
    protected final ReferenceMapper<Entity, UEntity> referenceMapper;
    private final ProgressMapper progressMapper;

    @Transactional(readOnly = true)
    public UEntityDTO getById(Long id) {

        var userId = context.getAuthenticatedUser().getId();

        UEntity uEntity = userEntityRepository
                .findByUserIdAndEntityId(userId, id);

        validate(uEntity);

        return mapper.toDTO(uEntity);
    }

    @Transactional(readOnly = true)
    public TaskDTO<EntityReferenceDTO> getAll() {
        var userId = context.getAuthenticatedUser().getId();

        List<UEntity> userEntities = userEntityRepository.findByUserId(userId);

        List<EntityReferenceDTO> tasks = userEntities.stream()
                .map(referenceMapper::toReferenceDTO)
                .toList();

        return new TaskDTO<>(tasks, progressMapper.map(tasks));
    }

    protected abstract void validate(UEntity uEntity);
}