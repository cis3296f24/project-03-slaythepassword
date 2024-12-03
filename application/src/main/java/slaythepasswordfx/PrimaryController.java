package slaythepasswordfx;

import java.io.IOException;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("start");
    }
    public void save(String maxHealth,String currentHealth,String input) {
        // write data into record.txt file
        try {
            FileWriter fileWriter = new FileWriter( "record.txt", true); // 第二个参数为true表示追加写入
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(maxHealth + ", " + currentHealth+ ", " + input + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
