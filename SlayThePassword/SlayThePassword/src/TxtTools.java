import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtTools {
    public void save(User user,String input) {
        // write data into record.txt file
        try {
            FileWriter fileWriter = new FileWriter( "record.txt", true); // 第二个参数为true表示追加写入
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(user.getUsername() + ", " + user.getMaxHealth() + ", " + user.getHealth() + ", " + input + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
