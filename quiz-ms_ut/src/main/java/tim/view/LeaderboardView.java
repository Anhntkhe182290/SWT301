package tim.view;

import tim.model.*;

import java.util.List;

public class LeaderboardView {
    public void displayLeaderboard(Quiz quiz, List<Score> scores) {
        System.out.println("Leaderboard for quiz: " + quiz.getTitle());
        scores.stream()
            .filter(score -> score.getQuiz().equals(quiz))
            .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
            .forEach(score -> System.out.println(score.getPlayer().getName() + ": " + score.getScore()));
    }
}
