package tim.validation;

import tim.model.Quiz;

import java.util.List;

public class QuizValidator {
    public boolean validate(Quiz quiz, List<Quiz> existingQuizzes) {
        return quiz.getTitle() != null && !quiz.getTitle().isEmpty() && quiz.getTopic() != null &&
                   existingQuizzes.stream().noneMatch(existingQuiz -> existingQuiz.getId() == quiz.getId());
    }
}
