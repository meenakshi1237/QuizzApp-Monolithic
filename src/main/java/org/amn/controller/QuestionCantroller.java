package org.amn.controller;

import lombok.RequiredArgsConstructor;
import org.amn.entity.Question;
import org.amn.service.QuestionService;
import org.amn.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questions")
@RequiredArgsConstructor
public class QuestionCantroller {
    private final QuestionService questionService;
    @GetMapping("allquestions")
    public ResponseEntity<ApiResponse> allQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<ApiResponse> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestiosByCategory(category);
    }
    @PostMapping("addquestion")
    public ResponseEntity<ApiResponse> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
