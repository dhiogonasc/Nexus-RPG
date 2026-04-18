package com.nexus.nexusrpg.domain.entity.planet.repository;

import com.nexus.nexusrpg.common.entity.RelationRepository;
import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.UserPlanet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserPlanetRepository extends JpaRepository<UserPlanet, Long>, RelationRepository<UserPlanet> {

    List<UserPlanet> findByUserId(Long userId);

    @Override
    @Query("SELECT up FROM UserPlanet up WHERE up.user.id = :userId AND up.planet.id = :baseId")
    Optional<UserPlanet> findByUserIdAndBaseId(@Param("userId") Long userId, @Param("baseId") Long baseId);

    default UserPlanet findByUserIdAndPlanetIdOrThrow(Long userId, Long planetId) {
        return findByUserIdAndBaseId(userId, planetId)
                .orElseThrow(() -> new BusinessException("Planet", "Nenhum registro encontrado", NOT_FOUND));
    }

    Optional<UserPlanet> findByUserIdAndPlanetOrder(Long userId, int nextPlanetOrder);
}
