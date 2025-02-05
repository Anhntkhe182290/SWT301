package tim.validation;

import tim.model.Question;

public class QuestionValidator {
    public boolean validate(Question question) {
        return question.getText() != null && !question.getText().isEmpty() &&
                   (question.getOptions() != null) && (question.getOptions().size() >= 2) &&
                   (question.getCorrectOption() != null);
    }
}
