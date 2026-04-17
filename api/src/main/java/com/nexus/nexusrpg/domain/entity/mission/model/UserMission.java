package com.nexus.nexusrpg.domain.entity.mission.model;

import com.nexus.nexusrpg.common.entity.interfaces.Statable;
import com.nexus.nexusrpg.domain.user.model.User;
import jakarta.persistence.*;
import lombok.*;

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
public class UserMission implements Statable {

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
                .isAccessible(isFirst)
                .isCurrent(isFirst)
                .build();

        return UserMission.builder()
                .user(user)
                .mission(mission)
                .execution(initialStats)
                .build();
    }
}
