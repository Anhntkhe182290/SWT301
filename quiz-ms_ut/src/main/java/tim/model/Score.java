package tim.model;

public class Score {
    private Player player;
    private Quiz quiz;
    private int score;
    
    public Score(Player player, Quiz quiz, int score) {
        this.player = player;
        this.quiz = quiz;
        this.score = score;
    }
    
    // Getters and setters
    public Player getPlayer() {
        return player;
    }
    
    public Quiz getQuiz() {
        return quiz;
    }
    
    public int getScore() {
        return score;
    }
}
