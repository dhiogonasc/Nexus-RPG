package com.nexus.nexusrpg.user.model;

import com.nexus.nexusrpg.domain.model.Level;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {

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

    @Builder.Default
    @Column(name = "\"xp\"", nullable = false, columnDefinition = "xp")
    private long xp = 0;

    @Builder.Default
    @Column(name = "\"oxygen\"", nullable = false, columnDefinition = "oxygen")
    private int oxygen = 10;

    public void addXp(long xp) {
        this.xp += xp;
    }

    public void consumeOxygen(){
        this.oxygen -= 1;
    }

    public void levelUp(Level nextLevel) {

        if (nextLevel == null) return;

        if (this.xp >= this.level.getXpRequired()) {
            this.level = nextLevel;
            this.oxygen = 10;
        }
    }
}
