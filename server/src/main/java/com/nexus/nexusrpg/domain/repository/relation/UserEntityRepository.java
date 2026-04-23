package com.nexus.nexusrpg.domain.repository.relation;

import java.util.List;

public interface UserEntityRepository<UserEntity> {
    List<UserEntity> findByUserId(Long userId);
    UserEntity findByUserIdAndEntityId(Long userId, Long entityId);
}