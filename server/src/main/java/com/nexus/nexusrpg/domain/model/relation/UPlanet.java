package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.common.state.State;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.execution.UPlanetExec;
import com.nexus.nexusrpg.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.nexus.nexusrpg.common.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.enums.EntityStatus.UNLOCKED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_planet\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_planet", columnNames = {"user_id", "planet_id"})
})
public class UPlanet implements State {

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


    public List<Resource> getResources(){
        return this.planet.getResources();
    }

    public List<Mission> getMissions(){
        return this.planet.getMissions();
    }
}
