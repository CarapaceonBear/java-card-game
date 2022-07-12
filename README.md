# Java Card Game

## Task

To create a simple command-line card game in Java.

The user can select to play snap or blackjack


## Component Tree

![tree](https://i.imgur.com/Pmia8ht.png)


## PsuedoCode

### Card
public Card(suit, symbol, value) {<br>
_String symbol;<br>
_int value;<br>
}<br>
@Override<br>
toString(){ suit + symbol }<br>

### CardGame
String name;<br>
String[ ] symbols = {2,3,4,5,6,7,8,9,10,J,Q,K,A}<br>
String[ ] values = {2,3,4,5,6,7,8,9,10,11,12,13,14}<br>
List<Card> deck = new ArrayList<>();<br>

public CardGame(name){<br>
_this.name = name;<br>

public void createDeck(){<br>
_for (suit of 4) {<br>
__for (value of 13) {<br>
___deck.add(new Card(suit, value))<br>
__}<br>
_}<br>

public String[] getDeck() {<br>
_String[ ] cardList = new String[52];<br>
_for (card in deck) {<br>
__add to cardList;<br>
_return cardList;<br>

public Card dealCard() {<br>
_Card result = deck.get(last);<br>
_deck.remove(last);<br>
_return result;<br>

public void sortDeckInNumberOrder() {<br>
_deck.sort( -> custom sort )<br>

public void sortDeckIntoSuits() {<br>
_deck.sort( -> custom sort )<br>

public void shuffleDeck() {<br>
_deck.sort( random )<br>
}

### Player
String name;<br>
int score;<br>
constructor(name) {}<br>
public void incrementScore() {<br>
_score++;<br>
}<br>

### Snap extends CardGame
Card previousCard;<br>
Card currentCard;<br>
Player playerOne = new Player();<br>
Player playerTwo = new player();<br>
int currentPlayer = 0;

public void startGame() {<br>
_currentCard = dealCard();<br>
}<br>

public void runGame() {<br>
_currentPlayer = 1;<br>
_while(active) {<br>
__UserInput.printMessage("Press enter to draw a card");<br>
__if (UserInput.getEnterPress()) {<br>
_ _previousCard = currentCard;<br>
_ _currentCard = dealCard();<br>
__}<br>
__if (currentCard.getSymbol.equals(previousCard.getSymbol)) {<br>
_ _String response = UserInput.getStringInput();<br>
_ _2 second timer {<br>
_  _response.equals("snap") ? currentPlayer wins : otherPlayer wins;<br>
_ _}<br>
_ _UserInput.printMessage( winner )<br>
_ _winning player.incrementScore();<br>
__}<br>
__currentPlayer == 1 ? currentPlayer = 2 : currentPlayer = 1;<br>
_}<br>

### UserInput
Scanner...<br>
public void printMessage(String) {<br>
_System.out.printLine(String);<br>
}<br>
public int getIntInput() {}<br>
public String getStringInput() {}<br>
public boolean getEnterPress() {}<br>
