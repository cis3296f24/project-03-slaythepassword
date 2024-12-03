import java.util.Scanner;

/**
 * Class containing the main game loop. The user
 * is thrown into a loop and given the objective
 * of submitting the correct password based on a
 * hint.
 * <p>
 * If the user submits the correct password, they
 * gain health; if the password is incorrect, they
 * lose health. The game ends when the user's HP
 * is zero.
 */
public class Game {

    private User user;
    private Password password;
    private String userInput;
    private int level;

    public Game()
    {
        user = new UserImpl();
        password = new Password();
        userInput = "";
        level = 1;
    }

    public User getUser()
    {
        return user;
    }

    public Password getPassword()
    {
        return password;
    }

    public String getUserInput()
    {
        return userInput;
    }

    public int getLevel()
    {
        return level;
    }

    public int raiseLevel()
    {
        level++;
    }

    public void validateUserInput()
    {
        // Validate that the password is correct
        try {
            this.password.validate(this.userInput);
        }
        catch (AssertionError e) { // Wrong password submitted
            // Hint will be displayed again when AssertionError is thrown
            System.out.println(e.getMessage() + "\n");
            this.user.losehp(1);

            if (this.user.getHealth() == 0)
            {
                System.out.println("You lost! Game Over.");
            }
        }
        // Move to next level and restore some health
        System.out.println("Correct!\n");
        lvl++;
        this.user.restorehp(1);
        this.password = new Password();
    }

    /*public static void main(String[] args) throws InterruptedException {
        User user = new UserImpl();
        Password password;
        int lvl = 1;
        Scanner scanner = new Scanner(System.in);
        String input;

        // Opening formalities
        System.out.println("@---------------@\nSLAY THE PASSWORD\n@----------------@");
        Thread.sleep(2000);
        System.out.println("Please enter your username: !");
        Thread.sleep(2000);
        input = scanner.nextLine();
        User user = new UserImpl(input);
        System.out.println("Submit the correct passwords and win!");
        Thread.sleep(2000);

        // Game loop, which ends when the player's HP is 0
        while (user.getHealth() > 0) {
            int targetDifficulty = getDifficultyLevel(lvl);
            password = new Password(targetDifficulty);
            // Determine difficulty level based on current level
            String difficultyLevel = targetDifficulty == 1 ? "Easy" : "Medium";
            System.out.println("Difficulty: " + difficultyLevel); // Announce difficulty level

            System.out.println("Lvl." + lvl + ", HP: " + user.getHealth());
            password.displayConditions(); // Display password hint

            // Take password input from the user
            input = scanner.nextLine();

            // write data into record.txt file
            TxtTools txtTools = new TxtTools();
            txtTools.save(user, input);

            // Validate that the password is correct
            try {
                password.validate(input);
                user.restorehp(password.getTotalDifficulty()); // More health for harder passwords
            } catch (AssertionError e) { // Wrong password submitted
                // Hint will be displayed again when AssertionError is thrown
                user.losehp(1 + (lvl - password.getTotalDifficulty()));
                continue;
            }

            // Move to next level and restore some health
            lvl++;
            user.restorehp(1);
        }
        System.out.println("You lost! Game Over.");*/
}
}