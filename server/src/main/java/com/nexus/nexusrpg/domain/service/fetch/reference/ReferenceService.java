package com.nexus.nexusrpg.domain.service.fetch.reference;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.mapping.Mapper;
import com.nexus.nexusrpg.common.mapping.ProgressMapper;
import com.nexus.nexusrpg.common.state.State;
import com.nexus.nexusrpg.common.task.TaskDTO;
import com.nexus.nexusrpg.domain.mapper.reference.dynamics.DynamicReferenceMapper;
import com.nexus.nexusrpg.domain.repository.relation.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class ReferenceService<UEntity extends State, UEntityDTO> {

    protected final Context context;
    protected final UserEntityRepository<UEntity> userEntityRepository;
    protected final Mapper<UEntity, UEntityDTO> mapper;
    protected final DynamicReferenceMapper<UEntity> referenceMapper;
    private final ProgressMapper progressMapper;

    @Transactional(readOnly = true)
    public TaskDTO getAll() {
        var userId = context.getAuthenticatedUser().getId();

        List<UEntity> userEntities = userEntityRepository.findByUserId(userId);

        var tasks = userEntities.stream()
                .map(referenceMapper::map)
                .toList();

        var progress = progressMapper.map(tasks);

        return new TaskDTO(tasks, progress);
    }
}