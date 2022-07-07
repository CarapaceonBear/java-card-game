import java.util.ArrayList;
import java.util.List;

public class BlackJack extends CardGame {

    List<Card> playerCards = new ArrayList<>();
    List<Card> dealerCards = new ArrayList<>();

    public BlackJack(String name, UserInput user) {
        super.setName(name);
        super.setUser(user);
        createDeck();
    }

    public void runGame() {
        return;
    }
}
