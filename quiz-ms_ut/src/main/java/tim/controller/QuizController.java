package tim.controller;

import tim.model.Quiz;
import tim.validation.QuizValidator;

import java.util.ArrayList;
import java.util.List;

public class QuizController {
    private List<Quiz> quizzes;
    private QuizValidator validator;
    
    public QuizController() {
        this.quizzes = new ArrayList<>();
        this.validator = new QuizValidator();
    }
    
    public boolean addQuiz(Quiz quiz) {
        if (validator.validate(quiz, quizzes)) {
            quizzes.add(quiz);
            return true;
        }
        return false;
    }
    
    public List<Quiz> getQuizzes() {
        return quizzes;
    }
    
    public Quiz getQuizById(int id) {
        return quizzes.stream().filter(quiz -> quiz.getId() == id).findFirst().orElse(null);
    }
}
