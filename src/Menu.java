public class Menu {

    private String[] menuOptions = {"play snap", "play blackjack"};
    UserInput user = new UserInput("user");
    Snap snap = new Snap("snap", user);
    BlackJack blackJack = new BlackJack("blackjack", user);

    public Menu() {
    }

    public void runMenu() {
        boolean isActive = true;

        while(isActive) {
            printOptions();
            int response = user.getIntegerInput(menuOptions.length + 1);

            switch (response) {
                case 1:
                    snap.setup();
                    snap.runGame();
                    break;
                case 2:
                    blackJack.runGame();
                    break;
                default:
                    isActive = false;
            }
        }
    }

    public void printOptions() {
        for (int i = 0; i < menuOptions.length; i++) {
            user.printMessage(String.format("%d - %s", (i + 1), menuOptions[i]));
        }
        user.printMessage(String.format("%d - Exit program", menuOptions.length + 1));
    }
}
