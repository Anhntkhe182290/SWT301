package tim.view;


import tim.model.*;

import java.util.Scanner;

public class PlayerView {
    public Score takeQuiz(Player player, Quiz quiz) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        for (Question question : quiz.getQuestions()) {
            System.out.println(question.getText());
            var options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getText());
            }
            
            int answer;
            while (true) {
                System.out.println("Enter your answer:");
                answer = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                if (answer < 1 || answer > options.size()) {
                    System.out.println("Invalid option. Please enter a number between 1 and " + options.size() + ".");
                } else {
                    break;
                }
            }
            
            if (options.get(answer - 1).equals(question.getCorrectOption())) {
                score++;
            }
        }
        
        Score playerScore = new Score(player, quiz, score);
        System.out.println("Quiz completed! " + player.getName() + " scored: " + score + "/" + quiz.getQuestions().size());
        return playerScore;
    }
}
