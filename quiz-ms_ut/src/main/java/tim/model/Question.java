package tim.model;

import java.util.List;

public class Question {
    private String text;
    private List<Option> options;
    private Option correctOption;
    
    public Question(String text, List<Option> options, Option correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }
    
    // Getters and setters
    public String getText() {
        return text;
    }
    
    public List<Option> getOptions() {
        return options;
    }
    
    public Option getCorrectOption() {
        return correctOption;
    }
}
