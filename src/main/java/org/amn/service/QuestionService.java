package org.amn.service;

import lombok.RequiredArgsConstructor;
import org.amn.dao.QuestionDao;
import org.amn.entity.Question;
import org.amn.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionDao  questionDao;
    public ResponseEntity<ApiResponse> getAllQuestions(){
        return questionDao.getAllQuestions();
    }

    public ResponseEntity<ApiResponse> getQuestiosByCategory(String category) {
        return questionDao.getQuestionsByCategory(category);
    }

    public ResponseEntity<ApiResponse> addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }
}
