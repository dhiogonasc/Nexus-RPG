package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.enums.EntityStatus;
import com.nexus.nexusrpg.domain.model.relation.execution.UPlanetExec;
import com.nexus.nexusrpg.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

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
public class UPlanet implements Usable, Statable, Orientable {

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
    private UPlanetExec execution = new UPlanetExec();


    @Override
    public void unlock() {
        this.execution.unlock();
    }

    @Override
    public void complete() {
        this.execution.complete();
    }

    @Override
    public EntityStatus getStatus(){
        return this.execution.getStatus();
    }

    @Override
    public boolean isCurrent() {
        return this.execution.getIsCurrent();
    }

    public static UPlanet initialize(User user, Planet planet) {

        boolean isFirst = planet.getOrder() == 1;

        var initialStats = UPlanetExec.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .isCurrent(isFirst)
                .build();

        return UPlanet.builder()
                .user(user)
                .planet(planet)
                .execution(initialStats)
                .build();
    }

    public List<UMission> getUMissions() {
        return this.user.getMissions().stream()
                .filter(uMission -> uMission.getPlanet().equals(this.planet))
                .toList();
    }

    public long getXpBonus() {
        return this.planet.getXpBonus();
    }

    public Optional<UMission> getFirstMission() {
        return getUMissions().stream().findFirst();
    }

    @Override
    public int getOrder() {
        return this.planet.getOrder();
    }
}
