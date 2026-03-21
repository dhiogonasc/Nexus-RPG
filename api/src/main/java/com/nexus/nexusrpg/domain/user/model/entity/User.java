package com.nexus.nexusrpg.domain.user.model.entity;

import com.nexus.nexusrpg.domain.level.model.Level;
import com.nexus.nexusrpg.domain.mission.model.Mission;
import com.nexus.nexusrpg.domain.planet.model.Planet;
import com.nexus.nexusrpg.domain.user.model.relation.UserMission;
import com.nexus.nexusrpg.domain.user.model.relation.UserPlanet;
import com.nexus.nexusrpg.domain.user.model.relation.UserResource;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"username\"", nullable = false)
    private String username;

    @Column(name = "\"email\"", nullable = false, unique = true)
    private String email;

    @Column(name = "\"password\"", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Planet currentPlanet;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission currentMission;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserPlanet> planets = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> missions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserResource> resources = new ArrayList<>();

    @Builder.Default
    @Column(name = "\"xp\"", nullable = false, columnDefinition = "xp")
    private long xp = 0;

    @Builder.Default
    @Column(name = "\"oxygen\"", nullable = false, columnDefinition = "oxygen")
    private int oxygen = 10;


    @Override
    public String getUsername() { return this.email; }

    @Override
    public String getPassword() { return this.password; }

    @Override public boolean isAccountNonExpired() { return true; }

    @Override public boolean isAccountNonLocked() { return true; }

    @Override public boolean isCredentialsNonExpired() { return true; }

    @Override public boolean isEnabled() { return true; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
