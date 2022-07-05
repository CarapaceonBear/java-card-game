public class Card implements Comparable<Card> {

    private final String suit;
    private final String symbol;
    private final int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return (symbol + suit);
    }

    @Override
    public int compareTo(Card card) {
        return value - card.getValue();
    }

    public String getSuit() {
        return suit;
    }
    public String getSymbol() {
        return symbol;
    }
    public int getValue() {
        return value;
    }
}
