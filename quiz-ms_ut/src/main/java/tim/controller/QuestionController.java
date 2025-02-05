package tim.controller;

import tim.model.Question;
import tim.model.Quiz;
import tim.validation.QuestionValidator;

public class QuestionController {
    private QuestionValidator validator;
    
    public QuestionController() {
        this.validator = new QuestionValidator();
    }
    
    public boolean addQuestionToQuiz(Question question, Quiz quiz) {
        if (validator.validate(question)) {
            quiz.addQuestion(question);
            return true;
        }
        return false;
    }
}
