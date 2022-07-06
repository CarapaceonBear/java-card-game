public class Snap extends CardGame {

    String[] playerNames = new String[2];
    Card previousCard;
    Card currentCard;

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
        shuffleDeck();
        currentCard = dealCard();
        user.printMessage(currentCard.toString());
        boolean isActive = true;
        int turn = 0;
        while (isActive) {
            previousCard = currentCard;
            user.printMessage(String.format("%s's turn, press enter to draw a card", playerNames[turn]));
            user.getEnterPress();
            currentCard = dealCard();
            user.printMessage(currentCard.toString());
            if (currentCard.getSymbol().equals(previousCard.getSymbol())) {
//                timer
                if (user.getStringInput("It's a match!").equals("snap")) {
                    if (turn == 0) {
                        playerOne.incrementScore();
                    } else {
                        playerTwo.incrementScore();
                    }
                    user.printMessage(String.format("%s wins", playerNames[turn]));
                } else {
                    if (turn == 0) {
                        playerTwo.incrementScore();
                        user.printMessage(String.format("%s wins", playerNames[1]));
                    } else {
                        playerOne.incrementScore();
                        user.printMessage(String.format("%s wins", playerNames[0]));
                    }
                }
                isActive = false;
            }
            if (turn == 0) {
                turn = 1;
            } else {
                turn = 0;
            }
        }
    }

}
