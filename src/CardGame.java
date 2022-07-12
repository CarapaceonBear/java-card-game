import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class CardGame {

    private final String[] suits = {"\u2666", "\u2665", "\u2664", "\u2667"};
    private final String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
    protected List<Card> deck = new ArrayList<>();
    protected UserInput user;
    protected Player playerOne;
    protected Player playerTwo;

    public CardGame(UserInput user) {
        this.user = user;
    }

    public CardGame(){}

    protected void createDeck() {
        for (String suit : suits) {
            for (int i = 0; i < 13; i++) {
                deck.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public String[] getDeck() {
        String[] cardList = new String[deck.size()];
        for (int i = 0; i < deck.size(); i++) {
            cardList[i] = deck.get(i).toString();
        }
        return cardList;
    }

    protected Card dealCard() {
        Card dealtCard;
        if (deck.size() == 0) {
            dealtCard = new Card("empty", "empty", 0);
        } else {
            dealtCard = deck.get(deck.size() - 1);
            deck.remove(dealtCard);
        }
        return dealtCard;
    }

    protected void sortDeckInNumberOrder() {
        Collections.sort(deck);
    }

    protected void sortDeckIntoSuits() {
        deck.sort(Comparator.comparing(Card::getSuit));
    }

    protected void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void setUser(UserInput user) {
        this.user = user;
    }
}
