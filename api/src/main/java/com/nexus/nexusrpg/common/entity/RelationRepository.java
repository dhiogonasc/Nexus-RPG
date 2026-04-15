package com.nexus.nexusrpg.common.entity;

import java.util.List;
import java.util.Optional;

public interface RelationRepository<E> {

    List<E> findByUserId(Long userId);
    Optional<E> findByUserIdAndBaseId(Long userId, Long baseId);
}