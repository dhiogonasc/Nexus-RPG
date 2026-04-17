package com.nexus.nexusrpg.domain.entity.planet.model;

import com.nexus.nexusrpg.common.entity.interfaces.Statable;
import com.nexus.nexusrpg.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.UNLOCKED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_planet\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_planet", columnNames = {"user_id", "planet_id"})
})
public class UserPlanet implements Statable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @Embedded
    @Builder.Default
    private UserPlanetExecution execution = new UserPlanetExecution();

    public static UserPlanet initialize(User user, Planet planet) {

        boolean isFirst = planet.getOrder() == 1;

        var initialStats = UserPlanetExecution.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .isAccessible(isFirst)
                .isCurrent(isFirst)
                .build();

        return UserPlanet.builder()
                .user(user)
                .planet(planet)
                .execution(initialStats)
                .build();
    }
}
