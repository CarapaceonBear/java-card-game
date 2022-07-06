import java.util.Scanner;

public class UserInput {

    private final Scanner scanner = new Scanner(System.in);
    private final String name;

    public UserInput(String name) {
        this.name = name;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int getIntegerInput(int max) {
        int input = 0;
        boolean isActive = true;

        while (isActive) {
            printMessage(String.format("Enter a number between 1 - %d", max));
            int response = scanner.nextInt();

            if (response > 0 && response <= max) {
                isActive = false;
                input = response;
            } else {
                printMessage("Invalid response");
            }
        }
        scanner.nextLine();
        return input;
    }

    public String getStringInput(String prompt) {
        String input = "";
        boolean isActive = true;

        while (isActive) {
            printMessage(prompt);
            String response = scanner.nextLine();

            if (!response.equals("")) {
                isActive = false;
                input = response;
            } else {
                printMessage("Invalid response");
            }
        }
        return input;
    }

    public void getEnterPress() {
        boolean isActive = true;

        while (isActive) {
            String response = scanner.nextLine();
            if (response.equals("")) {
                isActive = false;
            }
        }
    }
}
