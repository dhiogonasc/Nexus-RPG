package com.nexus.nexusrpg.domain.repository.relation;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.model.relation.UPlanet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public interface UserPlanetRepository extends JpaRepository<UPlanet, Long>, UserEntityRepository<UPlanet> {

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

    @Query("SELECT up " +
            "FROM UPlanet up " +
            "JOIN FETCH up.planet " +
            "WHERE up.user.id = :userId " +
            "AND up.planet.order = :planetOrder")
    Optional<UPlanet> findByUserIdAndPlanetOrder(@Param("userId") Long userId, @Param("planetOrder") int planetOrder);
}
