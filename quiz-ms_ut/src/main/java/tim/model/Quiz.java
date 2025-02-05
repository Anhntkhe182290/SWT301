package tim.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int id;
    private String title;
    private Topic topic;
    private List<Question> questions;
    
    public Quiz(int id, String title, Topic topic) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.questions = new ArrayList<>();
    }
    
    // Getters and setters
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Topic getTopic() {
        return topic;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }
    
    public void addQuestion(Question question) {
        this.questions.add(question);
    }
}
