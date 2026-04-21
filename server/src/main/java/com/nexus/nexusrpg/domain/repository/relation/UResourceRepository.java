package com.nexus.nexusrpg.domain.repository.relation;

import com.nexus.nexusrpg.common.entity.repository.UEntityRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UResourceRepository extends JpaRepository<UResource, Long>, UEntityRepository<UResource> {

    @Override
    List<UResource> findByUserId(Long userId);

    @Override
    default UResource findByUserIdAndEntityId(Long userId, Long entityId){
        return findUEntity(userId, entityId)
                .orElseThrow(() -> new BusinessException(
                        "Resource",
                        "Nenhum registro encontrado",
                        NOT_FOUND)
                );
    }

    @Query("SELECT ur " +
            "FROM UResource ur " +
            "JOIN FETCH ur.resource " +
            "WHERE ur.user.id = :userId " +
            "AND ur.resource.id = :entityId")
    Optional<UResource> findUEntity(@Param("userId") Long userId, @Param("entityId") Long entityId);

    @Override
    @Query("SELECT COUNT(ur) " +
            "FROM UResource ur " +
            "WHERE ur.user.id = :userId ")
    long countTotalTasks(@Param("userId") Long userId);

    @Override
    @Query("SELECT COUNT(ur) " +
            "FROM UResource ur " +
            "WHERE ur.user.id = :userId " +
            "AND ur.execution.status = 'COMPLETED'")
    long countCompletedTasks(@Param("userId") Long userId);

}
