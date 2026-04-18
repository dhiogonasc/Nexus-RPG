package com.nexus.nexusrpg.common.entity;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class GetEntity<Entity, UEntity, UEntityDTO, UEntityRefDTO> {

    protected final Context context;
    protected final UEntityRepository<UEntity> userEntityRepository;
    protected final Mapper<UEntity, UEntityDTO> mapper;
    protected final RefMapper<Entity, UEntity, UEntityRefDTO> refMapper;

    @Transactional(readOnly = true)
    public UEntityDTO getById(Long id) {

        var userId = context.getAuthenticatedUser().getId();

        UEntity uEntity = userEntityRepository
                .findByUserIdAndEntityId(userId, id);

        validateAccess(uEntity);

        return mapper.toDTO(uEntity);
    }

    @Transactional(readOnly = true)
    public List<UEntityRefDTO> getAll() {

        var userId = context.getAuthenticatedUser().getId();

        return userEntityRepository
                .findByUserId(userId).stream()
                .map(refMapper::toRefDTO)
                .toList();
    }

    protected abstract void validateAccess(UEntity uEntity);
}