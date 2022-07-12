import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    private final String[] playerNames = new String[2];
    private Card currentCard;
    private boolean timerActive;

    public Snap(UserInput user) {
        super.setUser(user);
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
            createDeck();
            shuffleDeck();
            currentCard = dealCard();
            user.printMessage(currentCard.toString());
            playRound();
            user.printMessage(String.format("%s : %d, %s : %d", playerOne.getName(), playerOne.getScore(), playerTwo.getName(), playerTwo.getScore()));
            String choice = user.getStringInput("Play again? y/n");
            if (choice.equals("n")) {
                isActive = false;
            }
        }
    }

    private void playRound() {
        boolean isActive = true;
        int turn = 0;
        while (isActive) {
            Card previousCard = currentCard;
            user.printMessage(String.format("%s's turn, press enter to draw a card", playerNames[turn]));
            user.getEnterPress();
            currentCard = dealCard();
            if (currentCard.getValue() == 0) {
                user.printMessage("The deck is finished");
                return;
            }
            user.printMessage(currentCard.toString());
            if (currentCard.getSymbol().equals(previousCard.getSymbol())) {
                isActive = false;
                timerActive = true;
                runTimer(turn);
            }
            turn = (turn == 0) ? 1 : 0;
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
        timer.schedule(task, 2500L);
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
