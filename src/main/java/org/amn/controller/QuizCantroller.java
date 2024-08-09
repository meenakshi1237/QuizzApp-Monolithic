package org.amn.controller;

import lombok.RequiredArgsConstructor;
import org.amn.entity.Quiz;
import org.amn.entity.dto.Result;
import org.amn.service.QuizService;
import org.amn.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("quiz")
public class QuizCantroller {
    private final QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<ApiResponse> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{quizId}")
    public ResponseEntity<ApiResponse> getQuiz(@PathVariable Integer quizId){
        return quizService.getQuiz(quizId);
    }
    @PostMapping("submit/{quizId}")
    public ResponseEntity<ApiResponse> submitQuiz(@PathVariable Integer quizId,@RequestBody List<Result>  answers){
        return quizService.caliclateResult(quizId,answers);
    }
}
