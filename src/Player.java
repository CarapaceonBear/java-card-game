public class Player {

    private final String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void incrementScore() {
        score++;
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}
