package com.nexus.nexusrpg.model.relation;

import com.nexus.nexusrpg.model.entity.Alternative;
import com.nexus.nexusrpg.model.entity.Question;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user_response\"")
public class UserResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attempt_id", nullable = false)
    private UserMissionAttempt attempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "question_id", 
                        referencedColumnName = "question_id", 
                        insertable = false, 
                        updatable = false
                       ),
            @JoinColumn(name = "alternative_id", referencedColumnName = "id")
    })
    private Alternative alternative;
}
