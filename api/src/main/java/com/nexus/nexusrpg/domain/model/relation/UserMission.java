package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.common.entity.enums.EntityStatus;
import com.nexus.nexusrpg.common.entity.interfaces.State;
import com.nexus.nexusrpg.domain.model.Mission;
import com.nexus.nexusrpg.domain.model.relation.execution.UserMissionExecution;
import com.nexus.nexusrpg.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.UNLOCKED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_mission\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_mission", columnNames = {"user_id", "mission_id"})
})
public class UserMission implements State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Embedded
    @Builder.Default
    private UserMissionExecution execution = new UserMissionExecution();

    public static UserMission initialize(User user, Mission mission) {

        boolean isFirst = mission.getOrder() == 1 & mission.getPlanet().getOrder() == 1;

        var initialStats = UserMissionExecution.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .isCurrent(isFirst)
                .build();

        return UserMission.builder()
                .user(user)
                .mission(mission)
                .execution(initialStats)
                .build();
    }

    @Override
    public EntityStatus getStatus() {
        return this.execution.getStatus();
    }

    public boolean isCurrent(){
        return this.execution.getIsCurrent();
    }

    public BigDecimal getResult(){
        return this.execution.getBestResult();
    }
}
