package org.example._1cacademy.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example._1cacademy.dto.QuestionResponseDto;
import org.example._1cacademy.dto.QuestionSaveDto;
import org.example._1cacademy.entity.Question;
import org.example._1cacademy.model.result.DataResult;
import org.example._1cacademy.model.result.Result;
import org.example._1cacademy.service.abstracts.IQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final IQuestionService questionService;

    @PostMapping
    public ResponseEntity<Result> createQuestion(@RequestBody QuestionSaveDto questionSaveDto) {
        return ResponseEntity.ok(questionService.saveQuestion(questionSaveDto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<DataResult<List<QuestionResponseDto>>> findAllQuestions() {
        return ResponseEntity.ok(this.questionService.getAllQuestions());
    }
}
