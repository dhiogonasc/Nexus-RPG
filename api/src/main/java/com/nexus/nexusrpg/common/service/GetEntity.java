package com.nexus.nexusrpg.common.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class GetEntity<A, B, C> {

    protected final UserContextService userContextService;

    @Transactional(readOnly = true)
    public B getById(Long id) {

        var userId = userContextService.getAuthenticatedUser().getId();

        A entity = findById(userId, id);
        validateAccess(entity);

        return mapToDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<C> getAll() {

        var userId = userContextService.getAuthenticatedUser().getId();

        return findAll(userId).stream()
                .map(this::mapToReferenceDTO)
                .toList();
    }

    protected abstract List<A> findAll(Long userId);
    protected abstract A findById(Long userId, Long id);
    protected abstract B mapToDTO(A entity);
    protected abstract C mapToReferenceDTO(A entity);
    protected abstract void validateAccess(A entity);
}