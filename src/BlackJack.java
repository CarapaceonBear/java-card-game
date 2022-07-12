import java.util.ArrayList;
import java.util.List;

public class BlackJack extends CardGame {

    private final List<Card> playerCards = new ArrayList<>();
    private final List<Card> dealerCards = new ArrayList<>();

    public BlackJack(UserInput user) {
        super.setUser(user);
        createDeck();
    }

    public void setup() {
        playerOne = new Player(user.getStringInput("Who is playing?"));
    }

    public void runGame() {
        boolean isActive = true;
        while (isActive) {
            shuffleDeck();
            dealerCards.add(dealCard());
            user.printMessage(String.format("Dealer's card : %s", dealerCards.get(0).toString()));
            playerCards.add(dealCard());
            user.printMessage(String.format("Player's card : %s", playerCards.get(0).toString()));

            playRound();

            String choice = user.getStringInput("Play again? y/n");
            if (choice.equals("n")) {
                isActive = false;
            }

            reset();
        }
    }

    private void playRound() {
        boolean isActive = true;
        while (isActive) {
            printOptions();
            int choice = user.getIntegerInput(3);
            int total = 0;
            switch (choice) {
                case 1:
                    isActive = hit(total);
                    break;
                case 2:
                    stand(total);
                    isActive = false;
                    break;
                case 3:
                    user.printMessage("Dealer wins");
                    isActive = false;
                    break;
            }
        }
    }

    private boolean hit(int total) {
        playerCards.add(dealCard());
        user.printMessage("Your hand:");
        for (Card card : playerCards) {
            user.printMessage(card.toString());
            total += card.getValue();
        }
        if ( total > 21) {
            user.printMessage("Your total exceeds 21, you lose");
            return false;
        }
        return true;
    }

    private void stand(int total) {
        for (Card card : playerCards) {
            user.printMessage(card.toString());
            total += card.getValue();
        }
        user.printMessage(String.format("Your total : %d", total));
        int dealerTotal = dealerCards.get(0).getValue();
        while (dealerTotal <= 17) {
            dealerCards.add(dealCard());
            dealerTotal += dealerCards.get(dealerCards.size() - 1).getValue();
        }
        user.printMessage("Dealer's hand:");
        for (Card card : dealerCards) {
            user.printMessage(card.toString());
        }
        if ((dealerTotal <= 21) && (dealerTotal >= total))  {
            user.printMessage("Dealer wins");
        } else {
            user.printMessage("You win");
        }
    }

    private void printOptions() {
        user.printMessage("1 - hit");
        user.printMessage("2 - stand");
        user.printMessage("3 - surrender");
    }

    private void reset() {
        playerCards.clear();
        dealerCards.clear();
        deck.clear();
        createDeck();
    }
}
