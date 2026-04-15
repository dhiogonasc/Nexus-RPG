package com.nexus.nexusrpg.common.entity;

import com.nexus.nexusrpg.common.context.Context;
import com.nexus.nexusrpg.core.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
public abstract class GetEntity<A, B, C> {

    protected final Context context;
    protected final String domainName;
    protected final RelationRepository<A> repository;

    @Transactional(readOnly = true)
    public B getById(Long id) {

        var userId = context.getAuthenticatedUser().getId();

        A entity = repository.findByUserIdAndBaseId(userId, id)
                .orElseThrow(() -> new BusinessException(domainName, "Registro não encontrado", NOT_FOUND));

        validateAccess(entity);
        return mapToDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<C> getAll() {

        var userId = context.getAuthenticatedUser().getId();

        return repository.findByUserId(userId).stream()
                .map(this::mapToReferenceDTO)
                .toList();
    }

    protected abstract B mapToDTO(A entity);
    protected abstract C mapToReferenceDTO(A entity);
    protected abstract void validateAccess(A entity);
}