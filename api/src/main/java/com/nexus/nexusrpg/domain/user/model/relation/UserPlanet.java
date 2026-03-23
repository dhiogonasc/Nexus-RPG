package com.nexus.nexusrpg.domain.user.model.relation;

import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.entity.User;
import com.nexus.nexusrpg.common.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.math.BigDecimal;

import static com.nexus.nexusrpg.common.enums.EntityStatus.*;

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
    @Column(name = "is_accessible", nullable = false)
    private Boolean isAccessible = false;

    @Builder.Default
    @Column(name = "\"progress\"", nullable = false, columnDefinition = "progress")
    private BigDecimal progress = BigDecimal.ZERO;

    public void unlock(){
        this.setStatus(UNLOCKED);
        this.setIsAccessible(true);
    }

    public void complete(){
        this.setStatus(COMPLETED);
        this.getUser().setXp(this.getUser().getXp() + this.getPlanet().getXpBonus());
    }
}
