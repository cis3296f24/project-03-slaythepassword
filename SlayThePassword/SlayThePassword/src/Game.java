
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
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
//    public void save(User user,String input) {
//        // write data into record.txt file
//        try {
//            FileWriter fileWriter = new FileWriter( "record.txt", true); // 第二个参数为true表示追加写入
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(user.getMaxHealth() + ", " + user.getHealth() + ", " + input + "\n");
//            bufferedWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @SneakyThrows
    public void play() throws InterruptedException{
//        String username = "";
//        User user = new UserImpl(username);
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
            password = new Password();

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

            } catch (AssertionError e) { // Wrong password submitted
                // Hint will be displayed again when AssertionError is thrown
                user.losehp(1);
                continue;
            }

            // Move to next level and restore some health
            lvl++;
            user.restorehp(1);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            new Game().play();
            System.out.println("You lost! Game Over.Input E to Exit or R to Retry");
            Scanner scanner = new Scanner(System.in);
            String flag;
            flag = scanner.nextLine();
            if (flag.equals("R")) {
                System.out.println("Let's play again!");
            } else {
                System.out.println("Exit the game!Thank you for playing!");
                System.exit(0);
            }
        }
    }
}
