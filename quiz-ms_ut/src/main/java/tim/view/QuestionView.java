package tim.view;


import tim.controller.*;
import tim.model.*;
import tim.validation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionView {
    private QuestionController questionController;
    private QuizController quizController;
    private InputValidator inputValidator;
    
    public QuestionView(QuestionController questionController, QuizController quizController) {
        this.questionController = questionController;
        this.quizController = quizController;
        this.inputValidator = new InputValidator();
    }
    
    public void addQuestionToQuiz() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter quiz ID:");
        int quizId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Quiz quiz = quizController.getQuizById(quizId);
        
        if (quiz == null) {
            System.out.println("Quiz not found!");
            return;
        }
        
        System.out.println("Enter question text:");
        String questionText = scanner.nextLine();
        
        int numberOfOptions;
        while(true) {
            System.out.println("Enter number of options (at least 2):");
            numberOfOptions = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (!inputValidator.validateNumberOfOptions(numberOfOptions)) {
                System.out.println("A question must have at least 2 options.");
            } else {
                break;
            }
        }
        
        List<Option> options = new ArrayList<>();
        for (int i = 0; i < numberOfOptions; i++) {
            System.out.println("Enter option " + (i + 1) + ":");
            options.add(new Option(scanner.nextLine()));
        }
        
        int correctOptionNumber;
        while(true) {
            System.out.println("Enter correct option number:");
            correctOptionNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if(correctOptionNumber < 1 || correctOptionNumber > numberOfOptions){
                System.out.println("The correct option must be between 1 and " + (numberOfOptions+1));
                
            }else {
                break;
            }
            
        }
        
        Option correctOption = options.get(correctOptionNumber - 1);
        
        Question question = new Question(questionText, options, correctOption);
        if (questionController.addQuestionToQuiz(question, quiz)) {
            System.out.println("Question added successfully!");
        } else {
            System.out.println("Question addition failed!");
        }
    }
}
