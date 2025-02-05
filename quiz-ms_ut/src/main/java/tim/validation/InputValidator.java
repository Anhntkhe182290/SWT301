package tim.validation;

import tim.model.Quiz;

import java.util.List;

public class InputValidator {
    public boolean validateQuizId(int id, List<Quiz> quizzes) {
        if (id < 0) {
            return false;
        }
        return quizzes.stream().noneMatch(quiz -> quiz.getId() == id);
    }
    
    public boolean validateNumberOfOptions(int numberOfOptions) {
        return numberOfOptions >= 2;
    }
}

