package com.nexus.nexusrpg.domain.repository.relation;

import com.nexus.nexusrpg.common.entity.repository.UEntityRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UPlanetRepository extends JpaRepository<UPlanet, Long>, UEntityRepository<UPlanet> {

    @Override
    List<UPlanet> findByUserId(Long userId);

    @Override
    default UPlanet findByUserIdAndEntityId(Long userId, Long entityId){
        return findUEntity(userId, entityId)
                .orElseThrow(() -> new BusinessException(
                        "Planet",
                        "Nenhum registro encontrado",
                        NOT_FOUND)
                );
    }

    @Query("SELECT up " +
            "FROM UPlanet up " +
            "JOIN FETCH up.planet " +
            "WHERE up.user.id = :userId " +
            "AND up.planet.id = :entityId")
    Optional<UPlanet> findUEntity(@Param("userId") Long userId, @Param("entityId") Long entityId);

    @Override
    @Query("SELECT COUNT(up) " +
            "FROM UPlanet up " +
            "WHERE up.user.id = :userId " +
            "AND up.execution.status = 'COMPLETED'")
    long countCompletedTasks(@Param("userId") Long userId);

    Optional<UPlanet> findByUserIdAndPlanetOrder(Long userId, int nextPlanetOrder);
}
