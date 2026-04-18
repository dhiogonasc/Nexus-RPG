package com.nexus.nexusrpg.common.entity;

import java.util.List;
import java.util.Optional;

public interface UEntityRepository<UEntity> {

    List<UEntity> findByUserId(Long userId);
    UEntity findByUserIdAndEntityId(Long userId, Long entityId);
}