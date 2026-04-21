package com.nexus.nexusrpg.domain.model.relation;

import com.nexus.nexusrpg.common.enums.EntityStatus;
import com.nexus.nexusrpg.common.state.State;
import com.nexus.nexusrpg.domain.model.Planet;
import com.nexus.nexusrpg.domain.model.Resource;
import com.nexus.nexusrpg.domain.model.relation.execution.UResourceExec;
import com.nexus.nexusrpg.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import static com.nexus.nexusrpg.common.enums.EntityStatus.LOCKED;
import static com.nexus.nexusrpg.common.enums.EntityStatus.UNLOCKED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_resource\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_resource", columnNames = {"user_id", "resource_id"})
})
public class UResource implements State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @Embedded
    @Builder.Default
    private UResourceExec execution = new UResourceExec();

    @Override
    public void unlock() {
        this.execution.unlock();
    }

    @Override
    public void complete() {
        this.execution.complete();
    }

    @Override
    public EntityStatus getStatus() {
        return this.execution.getStatus();
    }

    @Override
    public boolean isCurrent() {
        return this.execution.getIsCurrent();
    }

    public static UResource initialize(User user, Resource resource){

        boolean isFirst = resource.getPlanet().getOrder() == 1;

        var initialStats = UResourceExec.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .isCurrent(true)
                .build();

        return UResource.builder()
                .user(user)
                .resource(resource)
                .execution(initialStats)
                .build();
    }


    public Planet getPlanet(){
        return this.resource.getPlanet();
    }

}
