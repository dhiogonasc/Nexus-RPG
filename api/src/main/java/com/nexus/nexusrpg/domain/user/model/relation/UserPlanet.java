package com.nexus.nexusrpg.domain.user.model.relation;

import com.nexus.nexusrpg.domain.entity.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.User;
import com.nexus.nexusrpg.common.entity.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.math.BigDecimal;

import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.entity.enums.EntityStatus.UNLOCKED;
import static java.math.RoundingMode.HALF_UP;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_planet\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_planet", columnNames = {"user_id", "planet_id"})
})
public class UserPlanet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "\"status\"", nullable = false, columnDefinition = "entity_status")
    private EntityStatus status = LOCKED;

    @Builder.Default
    @Column(name = "\"is_accessible\"", nullable = false)
    private Boolean isAccessible = false;

    @Builder.Default
    @Column(name = "\"is_current\"", nullable = false)
    private Boolean isCurrent = false;

    @Builder.Default
    @Column(name = "\"progress\"", nullable = false, columnDefinition = "progress")
    private BigDecimal progress = BigDecimal.ZERO;

    public static UserPlanet initialize(User user, Planet planet){

        boolean isFirst = planet.getOrder() == 1;

        return UserPlanet.builder()
                .user(user)
                .planet(planet)
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

    public void updateProgress(int completedMissions, int totalMissions) {
        if (totalMissions == 0) return;
        this.progress = BigDecimal.valueOf(completedMissions)
                .divide(BigDecimal.valueOf(totalMissions), 2, HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }
}
