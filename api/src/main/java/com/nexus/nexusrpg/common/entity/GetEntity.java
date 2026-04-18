package com.nexus.nexusrpg.common.entity;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.common.entity.interfaces.Mapper;
import com.nexus.nexusrpg.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
public abstract class GetEntity<Entity, UserEntity, UserEntityDTO, UserEntityRefDTO> {

    protected final Context context;
    protected final String domainName;
    protected final RelationRepository<UserEntity> userEntityRepository;
    protected final Mapper<UserEntity, UserEntityDTO> mapper;
    protected final RefMapper<Entity, UserEntity, UserEntityRefDTO> refMapper;

    @Transactional(readOnly = true)
    public UserEntityDTO getById(Long id) {

        var userId = context.getAuthenticatedUser().getId();

        UserEntity userEntity = userEntityRepository
                .findByUserIdAndBaseId(userId, id)
                .orElseThrow(() -> new BusinessException(
                        domainName,
                        "Registro não encontrado",
                        NOT_FOUND
                ));

        validateAccess(userEntity);

        return mapper.toDTO(userEntity);
    }

    @Transactional(readOnly = true)
    public List<UserEntityRefDTO> getAll() {

        var userId = context.getAuthenticatedUser().getId();

        return userEntityRepository
                .findByUserId(userId).stream()
                .map(refMapper::toRefDTO)
                .toList();
    }

    protected abstract void validateAccess(UserEntity userEntity);
}