package org.amn.service;

import lombok.RequiredArgsConstructor;
import org.amn.dao.QuestionDao;
import org.amn.dao.QuizDao;
import org.amn.entity.Question;
import org.amn.entity.Quiz;
import org.amn.entity.dto.QuestionWrapper;
import org.amn.entity.dto.Result;
import org.amn.utils.ApiResponse;
import org.amn.utils.ResponseUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizDao quizDao;

    private final QuestionDao questionDao;

    private final ModelMapper modelMapper;

    public ResponseEntity<ApiResponse> createQuiz(String category,int numQ,String title) {
        List<Question> questions=questionDao.getLimitedQuestionsByCategory(category,numQ);
        Quiz quiz=Quiz.builder()
                .title(title)
                .questions(questions)
                .build();
        return quizDao.createQuiz(quiz);
    }

    public ResponseEntity<ApiResponse> getQuiz(Integer quizId) {
        Quiz quiz=quizDao.getQuiz(quizId);
        List<Question> questions=quiz.getQuestions();
        List<QuestionWrapper> userQuestions=new ArrayList<>();
        for(Question qw:questions){
            QuestionWrapper  questionWrapper=modelMapper.map(qw,QuestionWrapper.class);
            userQuestions.add(questionWrapper);
        }
        return ResponseUtils.getOkResponse(userQuestions);
    }

    public ResponseEntity<ApiResponse> caliclateResult(Integer quizId, List<Result> answers) {
        Quiz quiz=quizDao.getQuiz(quizId);
        List<Question> questions=quiz.getQuestions();
        int score=0;
        for(Question question:questions){
            for(Result result:answers){
                if(question.getId()==result.getId()&&question.getCorrectAnswer().equalsIgnoreCase(result.getAnswer())){
                    score++;
                }
            }
        }
        return ResponseUtils.getOkResponse(score);

    }
}
