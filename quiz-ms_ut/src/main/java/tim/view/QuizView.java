package tim.view;

import tim.controller.QuizController;
import tim.model.Quiz;
import tim.model.Topic;
import tim.validation.InputValidator;

import java.util.Scanner;

public class QuizView {
    private QuizController controller;
    private InputValidator inputValidator;
    
    public QuizView(QuizController controller) {
        this.controller = controller;
        this.inputValidator = new InputValidator();
    }
    
    public void createQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter quiz ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (!inputValidator.validateQuizId(id, controller.getQuizzes())) {
            System.out.println("Quiz ID already exists or is invalid!");
            return;
        }
        
        System.out.println("Enter quiz title:");
        String title = scanner.nextLine();
        
        System.out.println("Enter quiz topic (MATH, SCIENCE, HISTORY, LITERATURE, GENERAL KNOWLEDGE, COMPUTER SCIENCE):");
        Topic topic = Topic.valueOf(scanner.nextLine().toUpperCase());
        
        Quiz quiz = new Quiz(id, title, topic);
        if (controller.addQuiz(quiz)) {
            System.out.println("Quiz created successfully!");
        } else {
            System.out.println("Quiz creation failed!");
        }
    }
    
    public void listQuizzes() {
        System.out.println("Available Quizzes:");
        for (Quiz quiz : controller.getQuizzes()) {
            System.out.println("- " + quiz.getTitle() + " (" + quiz.getTopic() + ") [ID: " + quiz.getId() + "]");
        }
    }
}
