package com.nexus.nexusrpg.controller;

import com.nexus.nexusrpg.controller.dto.global.question.QuestionDTO;
import com.nexus.nexusrpg.service.QuestionService;
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