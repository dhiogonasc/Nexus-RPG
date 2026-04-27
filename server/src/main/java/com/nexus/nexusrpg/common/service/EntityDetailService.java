package com.nexus.nexusrpg.common.service;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.mapper.Mapper;
import com.nexus.nexusrpg.domain.repository.relation.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class EntityDetailService<UEntity, UEntityDTO> {

    protected final Context context;
    protected final UserEntityRepository<UEntity> userEntityRepository;
    protected final Mapper<UEntity, UEntityDTO> mapper;

    @Transactional(readOnly = true)
    public UEntityDTO getById(Long id) {

        var user = context.getAuthenticatedUser();

        UEntity uEntity = userEntityRepository
                .findByUserIdAndEntityId(user.getId(), id);

        validate(uEntity);

        return mapper.map(uEntity);
    }

    protected abstract void validate(UEntity uEntity);
}