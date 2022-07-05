import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class CardGame {

    private String name;
    String[] suits = {"\u2666", "\u2665", "\u2664", "\u2667"};
    String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    List<Card> deck = new ArrayList<>();

    public CardGame(String name) {
        this.name = name;
        createDeck();
    }

    public CardGame(){}

    public void createDeck() {
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

    public Card dealCard() {
        Card dealtCard = deck.get(deck.size() - 1);
        deck.remove(dealtCard);
        return dealtCard;
    }

    public void sortDeckInNumberOrder() {
        Collections.sort(deck);
    }

    public void sortDeckIntoSuits() {
        deck.sort(Comparator.comparing(Card::getSuit));
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void setName(String name) {
        this.name = name;
    }
}
