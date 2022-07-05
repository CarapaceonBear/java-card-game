import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserInput user = new UserInput();
        Player playerOne = new Player();
        Player playerTwo = new Player();
//        Snap game = new Snap(playerOne, playerTwo);
        CardGame game = new CardGame("snap");
        System.out.println(Arrays.toString(game.suits));
        System.out.println(Arrays.toString(game.getDeck()));

//        game.runGame();
    }
}