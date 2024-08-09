package org.amn.dao;

import lombok.RequiredArgsConstructor;
import org.amn.Exception.QuestionNotFoundException;
import org.amn.entity.Quiz;
import org.amn.repository.QuizRepository;
import org.amn.utils.ApiResponse;
import org.amn.utils.ResponseUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QuizDao {

    private final QuizRepository quizRepository;

    public ResponseEntity<ApiResponse> createQuiz(Quiz quiz) {
        return ResponseUtils.getCreatedResponse(quizRepository.save(quiz));
    }

    public Quiz getQuiz(Integer quizId) {
        return quizRepository.findById(quizId).orElseThrow(()->new QuestionNotFoundException());
    }
}
