package com.nexus.nexusrpg.domain.entity.resource.repository;

import com.nexus.nexusrpg.common.entity.UEntityRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserResourceRepository extends JpaRepository<UResource, Long>, UEntityRepository<UResource> {

    List<UResource> findByUserId(Long userId);

    @Override
    @Query("SELECT ur FROM UserResource ur WHERE ur.user.id = :userId AND ur.resource.id = :baseId")
    Optional<UResource> findByUserIdAndEntityId(@Param("userId") Long userId, @Param("baseId") Long baseId);

    default UResource findByUserIdAndResourceIdOrThrow(Long userId, Long resourceId) {

        return findByUserIdAndEntityId(userId, resourceId)
                .orElseThrow(() -> new BusinessException("Resource", "Nenhum registro encontrado", NOT_FOUND));
    }
}
