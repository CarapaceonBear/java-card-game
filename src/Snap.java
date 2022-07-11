import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    String[] playerNames = new String[2];
    Card previousCard;
    Card currentCard;
    boolean timerActive;

    public Snap(String name, UserInput user) {
        super.setName(name);
        super.setUser(user);
        createDeck();
    }

    public void setup() {
        playerOne = new Player(user.getStringInput("Who is the first player?"));
        playerNames[0] = playerOne.getName();
        playerTwo = new Player(user.getStringInput("Who is the second player?"));
        playerNames[1] = playerTwo.getName();
    }

    public void runGame() {
        boolean isActive = true;
        while (isActive) {
            shuffleDeck();
            currentCard = dealCard();
            user.printMessage(currentCard.toString());
            playGame();
            user.printMessage(String.format("%s : %d, %s : %d", playerOne.getName(), playerOne.getScore(), playerTwo.getName(), playerTwo.getScore()));
            String choice = user.getStringInput("Play again? y/n");
            if (choice.equals("n")) {
                isActive = false;
            }
        }
    }

    private void playGame() {
        boolean isActive = true;
        int turn = 0;
        while (isActive) {
            previousCard = currentCard;
            user.printMessage(String.format("%s's turn, press enter to draw a card", playerNames[turn]));
            user.getEnterPress();
            currentCard = dealCard();
            user.printMessage(currentCard.toString());
            if (currentCard.getSymbol().equals(previousCard.getSymbol())) {
                isActive = false;
                timerActive = true;
                runTimer(turn);
            }
            if (turn == 0) {
                turn = 1;
            } else {
                turn = 0;
            }
        }
    }

    private void runTimer(int turn) {
        TimerTask task = new TimerTask() {
            public void run() {
            if (turn == 0) {
                playerTwo.incrementScore();
                user.printMessage(String.format("%s wins", playerNames[1]));
            } else {
                playerOne.incrementScore();
                user.printMessage(String.format("%s wins", playerNames[0]));
            }
            user.setActive(false);
            timerActive = false;
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 3000L;
        timer.schedule(task, delay);
        while (timerActive) {
            String response = user.getStringInput("It's a match");
            if (timerActive && response.equals("snap")) {
                if (turn == 0) {
                    playerOne.incrementScore();
                } else {
                    playerTwo.incrementScore();
                }
                user.printMessage(String.format("%s wins", playerNames[turn]));
                timerActive = false;
                timer.cancel();
            } else {
                user.printMessage("Too slow!");
            }
        }
    }
}
