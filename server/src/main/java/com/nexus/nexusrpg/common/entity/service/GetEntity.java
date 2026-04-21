package com.nexus.nexusrpg.common.entity.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.mapper.RefMapper;
import com.nexus.nexusrpg.common.entity.repository.UEntityRepository;
import com.nexus.nexusrpg.common.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class GetEntity<Entity, UEntity, UEntityDTO, UEntityRDTO> {

    protected final Context context;
    protected final UEntityRepository<UEntity> userEntityRepository;
    protected final Mapper<UEntity, UEntityDTO> mapper;
    protected final RefMapper<Entity, UEntity, UEntityRDTO> refMapper;

    @Transactional(readOnly = true)
    public UEntityDTO getById(Long id) {

        var userId = context.getAuthenticatedUser().getId();

        UEntity uEntity = userEntityRepository
                .findByUserIdAndEntityId(userId, id);

        validate(uEntity);

        return mapper.toDTO(uEntity);
    }

    @Transactional(readOnly = true)
    public List<UEntityRDTO> getAll() {

        var userId = context.getAuthenticatedUser().getId();

        return userEntityRepository
                .findByUserId(userId).stream()
                .map(refMapper::toRefDTO)
                .toList();
    }

    protected abstract void validate(UEntity uEntity);
}