package com.nexus.nexusrpg.domain.entity.planet.repository;

import com.nexus.nexusrpg.common.entity.UEntityRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserPlanetRepository extends JpaRepository<UPlanet, Long>, UEntityRepository<UPlanet> {

    List<UPlanet> findByUserId(Long userId);

    @Override
    @Query("SELECT up FROM UserPlanet up WHERE up.user.id = :userId AND up.planet.id = :baseId")
    Optional<UPlanet> findByUserIdAndEntityId(@Param("userId") Long userId, @Param("baseId") Long baseId);

    default UPlanet findByUserIdAndPlanetIdOrThrow(Long userId, Long planetId) {
        return findByUserIdAndEntityId(userId, planetId)
                .orElseThrow(() -> new BusinessException("Planet", "Nenhum registro encontrado", NOT_FOUND));
    }

    Optional<UPlanet> findByUserIdAndPlanetOrder(Long userId, int nextPlanetOrder);
}
