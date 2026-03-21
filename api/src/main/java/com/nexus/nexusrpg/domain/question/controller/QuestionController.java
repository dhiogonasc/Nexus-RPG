package com.nexus.nexusrpg.domain.question.controller;

import com.nexus.nexusrpg.domain.question.controller.dto.QuestionDTO;
import com.nexus.nexusrpg.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestion(@PathVariable Long id) {

        return ResponseEntity.ok(questionService.getQuestion(id));
    }
}