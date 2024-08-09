package org.amn.dao;

import org.amn.entity.Question;
import org.amn.repository.QuestionRepository;
import org.amn.utils.ApiResponse;
import org.amn.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {
    @Autowired
    private  QuestionRepository questionRepository;

    public ResponseEntity<ApiResponse> getAllQuestions(){
        return ResponseUtils.getOkResponse(questionRepository.findAll());
    }

    public ResponseEntity<ApiResponse> getQuestionsByCategory(String category) {
        return ResponseUtils.getOkResponse(questionRepository.findByCategory(category));
    }

    public ResponseEntity<ApiResponse> addQuestion(Question question) {
        return ResponseUtils.getCreatedResponse(questionRepository.save(question));
    }

    public List<Question> getLimitedQuestionsByCategory(String category,int numQ){
        return questionRepository.getLimitedQuestionsByCategory(category,numQ);
    }
}
