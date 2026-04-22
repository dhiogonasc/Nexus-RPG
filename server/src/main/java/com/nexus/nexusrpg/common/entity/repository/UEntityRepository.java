package com.nexus.nexusrpg.common.entity.repository;

import java.util.List;

public interface UEntityRepository<UEntity> {
    List<UEntity> findByUserId(Long userId);
    UEntity findByUserIdAndEntityId(Long userId, Long entityId);
    long countCompletedTasks(Long userId);
}