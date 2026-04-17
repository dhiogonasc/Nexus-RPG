package com.nexus.nexusrpg.domain.entity.resource.model;

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
@Table(name = "\"user_resource\"", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_resource", columnNames = {"user_id", "resource_id"})
})
public class UserResource implements Statable {

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
    private UserResourceExecution execution = new UserResourceExecution();

    public static UserResource initialize(User user, Resource resource){

        boolean isFirst = resource.getPlanet().getOrder() == 1;

        var initialStats = UserResourceExecution.builder()
                .status(isFirst ? UNLOCKED : LOCKED)
                .isAccessible(isFirst)
                .isCurrent(isFirst)
                .build();

        return UserResource.builder()
                .user(user)
                .resource(resource)
                .execution(initialStats)
                .build();
    }
}
