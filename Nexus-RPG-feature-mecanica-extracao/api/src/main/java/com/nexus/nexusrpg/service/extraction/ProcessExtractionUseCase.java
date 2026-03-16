package com.nexus.nexusrpg.service.extraction;

import com.nexus.nexusrpg.controller.dto.request.ExtractionRequestDTO;
import com.nexus.nexusrpg.controller.dto.response.ExtractionResponseDTO;
import com.nexus.nexusrpg.model.entity.Alternative;
import com.nexus.nexusrpg.model.entity.UserStat;
import com.nexus.nexusrpg.repository.AlternativeRepository;
import com.nexus.nexusrpg.repository.UserStatExtractionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcessExtractionUseCase {

    private final AlternativeRepository alternativeRepository;
    private final UserStatExtractionRepository userStatRepository;
    private final ProgressionService progressionService;
    private final InventoryService inventoryService;
    private final HistoryService historyService;

    public ProcessExtractionUseCase(AlternativeRepository alternativeRepository, UserStatExtractionRepository userStatRepository, ProgressionService progressionService, InventoryService inventoryService,  HistoryService historyService) {

        this.alternativeRepository = alternativeRepository;
        this.userStatRepository = userStatRepository;
        this.progressionService = progressionService;
        this.inventoryService = inventoryService;
        this.historyService = historyService;

    }

    @Transactional
    public ExtractionResponseDTO execute(ExtractionRequestDTO request) {
        
        Alternative alternative = alternativeRepository.findById(request.alternativeId())
                .orElseThrow(() -> new RuntimeException("Ferramenta/Alternativa não encontrada na base."));
                
        UserStat userStat = userStatRepository.findByUserId(request.userId())
                .orElseThrow(() -> new RuntimeException("Status do Explorador não encontrado."));

        boolean isCorrect = alternative.getIsCorrect();
        int xpEarned = 0;
        String extractedResourceName = null;

        if (isCorrect) {
            xpEarned = progressionService.applyVictory(userStat, alternative);
            extractedResourceName = inventoryService.storeLoot(request.userId(), alternative);
        } else {
            progressionService.applyDefeat(userStat);
        }

        userStatRepository.save(userStat);

        historyService.recordAttempt(request.userId(), alternative, isCorrect);

        String message = isCorrect ? "Extração bem-sucedida!" : "Falha na extração. O recurso evaporou.";
        String feedbackTip = isCorrect ? null : alternative.getFeedbackTip();

        return new ExtractionResponseDTO(
                isCorrect, 
                message, 
                feedbackTip, 
                xpEarned, 
                userStat.getLevel().getId(),
                extractedResourceName
        );
    }
}