package tim;

import tim.controller.*;
import tim.model.*;
import tim.view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuizController quizController = new QuizController();
        QuizView quizView = new QuizView(quizController);
        
        QuestionController questionController = new QuestionController();
        QuestionView questionView = new QuestionView(questionController, quizController);
        
        PlayerView playerView = new PlayerView();
        LeaderboardView leaderboardView = new LeaderboardView();
        
        List<Score> scores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        // Adding sample data
        addSampleData(quizController, questionController);
        
        while (true) {
            System.out.println("1. Create a quiz");
            System.out.println("2. Add questions to a quiz");
            System.out.println("3. Play a quiz");
            System.out.println("4. View leaderboard");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    quizView.createQuiz();
                    break;
                case 2:
                    questionView.addQuestionToQuiz();
                    break;
                case 3:
                    System.out.println("Enter player name:");
                    String playerName = scanner.nextLine();
                    Player player = new Player(playerName);
                    
                    quizView.listQuizzes();
                    System.out.println("Enter quiz ID:");
                    int quizId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Quiz quiz = quizController.getQuizById(quizId);
                    
                    if (quiz == null) {
                        System.out.println("Quiz not found!");
                        break;
                    }
                    
                    Score score = playerView.takeQuiz(player, quiz);
                    scores.add(score);
                    break;
                case 4:
                    quizView.listQuizzes();
                    System.out.println("Enter quiz ID:");
                    quizId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    quiz = quizController.getQuizById(quizId);
                    
                    if (quiz == null) {
                        System.out.println("Quiz not found!");
                        break;
                    }
                    
                    leaderboardView.displayLeaderboard(quiz, scores);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void addSampleData(QuizController quizController, QuestionController questionController) {
        Quiz mathQuiz = new Quiz(1, "Math Basics", Topic.MATH);
        Quiz scienceQuiz = new Quiz(2, "Science Basics", Topic.SCIENCE);
        Quiz generalQuiz = new Quiz(3, "General Knowledge", Topic.GENERAL);
        quizController.addQuiz(mathQuiz);
        quizController.addQuiz(scienceQuiz);
        quizController.addQuiz(generalQuiz);
        
        List<Option> mathOptions1 = List.of(new Option("2"), new Option("3"), new Option("4"));
        Question mathQuestion1 = new Question("What is 1 + 1?", mathOptions1, mathOptions1.get(0));
        
        List<Option> mathOptions2 = List.of(new Option("3"), new Option("4"), new Option("5"));
        Question mathQuestion2 = new Question("What is 2 + 2?", mathOptions2, mathOptions2.get(1));
        
        List<Option> mathOptions3 = List.of(new Option("5"), new Option("6"), new Option("7"));
        Question mathQuestion3 = new Question("What is 3 + 3?", mathOptions3, mathOptions3.get(1));
        
        List<Option> mathOptions4 = List.of(new Option("7"), new Option("8"), new Option("9"));
        Question mathQuestion4 = new Question("What is 4 + 4?", mathOptions4, mathOptions4.get(1));
        
        List<Option> mathOptions5 = List.of(new Option("9"), new Option("10"), new Option("11"));
        Question mathQuestion5 = new Question("What is 5 + 5?", mathOptions5, mathOptions5.get(1));
        
        List<Option> scienceOptions1 = List.of(new Option("Oxygen"), new Option("Hydrogen"), new Option("Carbon"));
        Question scienceQuestion1 = new Question("What is the chemical symbol for water?", scienceOptions1, scienceOptions1.get(1));
        
        List<Option> scienceOptions2 = List.of(new Option("Sun"), new Option("Earth"), new Option("Moon"));
        Question scienceQuestion2 = new Question("Which is the closest planet to the sun?", scienceOptions2, scienceOptions2.get(0));
        
        List<Option> scienceOptions3 = List.of(new Option("3"), new Option("4"), new Option("5"));
        Question scienceQuestion3 = new Question("How many states of matter are there?", scienceOptions3, scienceOptions3.get(2));
        
        List<Option> scienceOptions4 = List.of(new Option("Solid"), new Option("Liquid"), new Option("Gas"));
        Question scienceQuestion4 = new Question("Which is not a state of matter?", scienceOptions4, scienceOptions4.get(0));
        
        List<Option> scienceOptions5 = List.of(new Option("Photosynthesis"), new Option("Respiration"), new Option("Transpiration"));
        Question scienceQuestion5 = new Question("What process do plants use to make food?", scienceOptions5, scienceOptions5.get(0));
        
        List<Option> generalOptions1 = List.of(new Option("Finland"), new Option("France"), new Option("Italy"), new Option("Colombia"));
        Question generalQuestion1 = new Question("Which country drinks the most amount of coffee per person?", generalOptions1, generalOptions1.get(0));
        
        
        
        questionController.addQuestionToQuiz(mathQuestion1, mathQuiz);
        questionController.addQuestionToQuiz(mathQuestion2, mathQuiz);
        questionController.addQuestionToQuiz(mathQuestion3, mathQuiz);
        questionController.addQuestionToQuiz(mathQuestion4, mathQuiz);
        questionController.addQuestionToQuiz(mathQuestion5, mathQuiz);
        
        questionController.addQuestionToQuiz(scienceQuestion1, scienceQuiz);
        questionController.addQuestionToQuiz(scienceQuestion2, scienceQuiz);
        questionController.addQuestionToQuiz(scienceQuestion3, scienceQuiz);
        questionController.addQuestionToQuiz(scienceQuestion4, scienceQuiz);
        questionController.addQuestionToQuiz(scienceQuestion5, scienceQuiz);
        
        questionController.addQuestionToQuiz(generalQuestion1, generalQuiz);
    }
}

