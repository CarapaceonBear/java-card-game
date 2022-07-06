import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserInput user = new UserInput("user");
        Snap game = new Snap("snap", user);
        game.setup();
        game.runGame();
    }
}