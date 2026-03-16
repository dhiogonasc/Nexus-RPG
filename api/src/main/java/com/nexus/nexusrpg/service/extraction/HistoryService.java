package com.nexus.nexusrpg.service.extraction;

import com.nexus.nexusrpg.model.entity.Alternative;
import com.nexus.nexusrpg.model.relation.UserMissionAttempt;
import com.nexus.nexusrpg.model.relation.UserResponse;
import com.nexus.nexusrpg.repository.UserMissionAttemptRepository;
import com.nexus.nexusrpg.repository.UserResponseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Duration;

@Service
public class HistoryService {

    private final UserResponseRepository userResponseRepository;
    private final UserMissionAttemptRepository userMissionAttemptRepository;

    public HistoryService(UserResponseRepository userResponseRepository, 
                          UserMissionAttemptRepository userMissionAttemptRepository) {
        this.userResponseRepository = userResponseRepository;
        this.userMissionAttemptRepository = userMissionAttemptRepository;
    }

    public void recordAttempt(Long userId, Alternative alternative, boolean isCorrect) {
        
        UserResponse responseLog = new UserResponse();
        responseLog.setUserId(userId);

        responseLog.setQuestion(alternative.getQuestion()); 
        responseLog.setAlternative(alternative);
        responseLog.setResponseTime(LocalDateTime.now());
        responseLog.setIsCorrect(isCorrect);
        
        userResponseRepository.save(responseLog);

        try {
            Long missionId = alternative.getQuestion().getMission().getId();
            
            UserMissionAttempt attemptLog = new UserMissionAttempt();
            attemptLog.setUserId(userId);
            attemptLog.setMissionId(missionId);
            attemptLog.setStartTime(LocalDateTime.now().minusMinutes(2)); 

            attemptLog.setEndTime(LocalDateTime.now());
            
            long durationInSeconds = Duration.between(attemptLog.getStartTime(), attemptLog.getEndTime()).getSeconds();

            attemptLog.setDuration((int) durationInSeconds);
            
            attemptLog.setResult(isCorrect ? "SUCCESS" : "FAILED");
            
            userMissionAttemptRepository.save(attemptLog);
            
        } catch (Exception e) {

            System.err.println("Aviso: Não foi possível atrelar o clique a uma missão específica.");

        }
    }
}