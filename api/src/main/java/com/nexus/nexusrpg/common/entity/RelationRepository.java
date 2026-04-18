package com.nexus.nexusrpg.common.entity;

import java.util.List;
import java.util.Optional;

public interface RelationRepository<UserEntity> {

    List<UserEntity> findByUserId(Long userId);
    Optional<UserEntity> findByUserIdAndBaseId(Long userId, Long baseId);
}