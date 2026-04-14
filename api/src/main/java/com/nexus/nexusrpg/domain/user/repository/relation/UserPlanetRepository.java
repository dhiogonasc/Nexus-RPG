package com.nexus.nexusrpg.domain.user.repository.relation;

import com.nexus.nexusrpg.core.exception.BusinessException;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface UserPlanetRepository extends JpaRepository<UserPlanet, Long> {

    Optional<UserPlanet> findByUserIdAndPlanetId(Long userId, Long planetId);

    default UserPlanet findByUserIdAndPlanetIdOrThrow(Long userId, Long planetId){
        return findByUserIdAndPlanetId(userId, planetId)
                .orElseThrow(() -> new BusinessException("User - Planet", "Nenhum registro encontrado", HttpStatus.BAD_REQUEST));
    }

    Optional<UserPlanet> findByUserIdAndPlanetOrder(Long userId, int nextPlanetOrder);

    List<UserPlanet> findByUserId(Long userId);
}
