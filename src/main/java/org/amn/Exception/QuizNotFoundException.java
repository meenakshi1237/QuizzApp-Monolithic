package org.amn.Exception;

public class QuizNotFoundException extends RuntimeException{

    public String getMessage(){
        return "Quiz Not Found";
    }
}
