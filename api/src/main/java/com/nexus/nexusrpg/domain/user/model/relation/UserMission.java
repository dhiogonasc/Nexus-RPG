package com.nexus.nexusrpg.domain.user.model.relation;

import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.math.BigDecimal;

import static com.nexus.nexusrpg.common.enums.EntityStatus.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_mission\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_mission", columnNames = {"user_id", "mission_id"})
})
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "\"status\"", nullable = false, columnDefinition = "entity_status")
    private EntityStatus status = LOCKED;

    @Builder.Default
    @Column(name = "is_accessible", nullable = false)
    private Boolean isAccessible = false;

    @Builder.Default
    @Column(name = "\"is_current\"", nullable = false)
    private Boolean isCurrent = false;

    @Builder.Default
    @Column(name = "\"best_result\"", nullable = false, columnDefinition = "score")
    private BigDecimal bestResult = BigDecimal.ZERO;

    @Builder.Default
    @Column(name = "\"progress\"", nullable = false, columnDefinition = "progress")
    private BigDecimal progress = BigDecimal.ZERO;

    public static UserMission initialize(User user, Mission mission) {

            boolean isFirst = mission.getOrder() == 1;

            return UserMission.builder()
                    .user(user)
                    .mission(mission)
                    .status(isFirst ? UNLOCKED : LOCKED)
                    .isAccessible(isFirst)
                    .isCurrent(isFirst)
                    .build();
    }

    public void unlock() {
        this.status = UNLOCKED;
        this.isAccessible = true;
        this.isCurrent = true;
    }

    public void complete() {
        this.status = EntityStatus.COMPLETED;
        this.isCurrent = false;
    }
}
