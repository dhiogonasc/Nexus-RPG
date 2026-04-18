package com.nexus.nexusrpg.domain.entity.resource.repository;

import com.nexus.nexusrpg.common.entity.RelationRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserResourceRepository extends JpaRepository<UserResource, Long>, RelationRepository<UserResource> {

    List<UserResource> findByUserId(Long userId);

    @Override
    @Query("SELECT ur FROM UserResource ur WHERE ur.user.id = :userId AND ur.resource.id = :baseId")
    Optional<UserResource> findByUserIdAndBaseId(@Param("userId") Long userId, @Param("baseId") Long baseId);

    default UserResource findByUserIdAndResourceIdOrThrow(Long userId, Long resourceId) {

        return findByUserIdAndBaseId(userId, resourceId)
                .orElseThrow(() -> new BusinessException("Resource", "Nenhum registro encontrado", NOT_FOUND));
    }
}
