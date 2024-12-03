import java.util.*;
import java.util.Scanner;

public class Gametestsim {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("@---------------@\nSLAY THE PASSWORD\n@----------------@");

        try {
            for (int difficulty = 1; difficulty <= 8; difficulty++) {
                System.out.println("\nStarting difficulty: " + difficulty);

                // Create a password for the current difficulty
                Password password = new Password(difficulty);
                password.displayConditions();

                System.out.print("Enter your password: ");
                String userInput = scanner.nextLine();

                try {
                    password.validate(userInput);
                    System.out.println("Password accepted! Moving to the next difficulty.");
                } catch (AssertionError e) {
                    System.out.println(e.getMessage());
                    System.out.println("You failed at difficulty: " + difficulty);
                    break;
                }
            }

            System.out.println("Game over. Thanks for playing!");
        } finally {
            scanner.close();
        }
    }

}
