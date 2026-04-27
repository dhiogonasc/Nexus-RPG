package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
import com.nexus.nexusrpg.domain.model.relation.execution.Execution;
import com.nexus.nexusrpg.domain.model.relation.execution.UPlanetExecution;
import com.nexus.nexusrpg.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.domain.model.enums.EntityStatus.UNLOCKED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_planet\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_planet", columnNames = {"user_id", "planet_id"})
})
public class UPlanet implements Usable, Orientable, Execution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @Embedded @Builder.Default
    private UPlanetExecution execution = new UPlanetExecution();

    public static UPlanet initialize(User user, Planet planet) {

        boolean isFirst = planet.getOrder() == 1;

        var initialStats = UPlanetExecution.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .current(isFirst)
                .build();

        return UPlanet.builder()
                .user(user)
                .planet(planet)
                .execution(initialStats)
                .build();
    }

    @Override
    public EntityStatus getStatus() {
        return this.execution.getStatus();
    }

    @Override
    public boolean isCurrent() {
        return this.execution.isCurrent();
    }

    @Override
    public void unlock() {
        this.execution.unlock();
    }

    @Override
    public void complete() {
        this.execution.complete();
    }

    public List<UMission> getUMissions() {
        return this.user.getMissions().stream()
                .filter(uMission -> uMission.getPlanet().equals(this.planet))
                .toList();
    }

    public long getXpBonus() {
        return this.planet.getXpBonus();
    }

    public UMission getFirstMission() {
        return getUMissions().stream()
                .filter(UMission::isFirst)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getOrder() {
        return this.planet.getOrder();
    }

    @Override
    public boolean isLast() {
        return this.planet.isLast();
    }


}
