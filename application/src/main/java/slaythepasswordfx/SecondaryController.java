package slaythepasswordfx;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.binding.Bindings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;

//essential FXML variables
@FXML
private TextField userInput;
@FXML
private Label HPLabel;
@FXML
private Label nameLabel;
@FXML
private ImageView logoImageView;
@FXML
private Label hintLabel;
@FXML 
private Label LvlLabel;


//Essential Backend variables

//health variable
private IntegerProperty health = new SimpleIntegerProperty(/*game.User.getHealth()*/);
//lvl variable
private IntegerProperty lvl = new SimpleIntegerProperty(/*game.User.getlevel()*/);
//hint vatriable
private StringProperty hint = new SimpleStringPRoperty(/*game.condition.hint */);
//maxHealth variable
private final int maxHealth;// = game.user.getMaxHP
//gameloop, where variables are found
private Game game;
//user prompts
private List<String> prompts = new ArrayList<>();
//hint texts for passwords.
private StringProperty hintText = new SimpleStringProperty();
//user prompt text
private StringProperty promptText = new SimpleStringProperty();


public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void initialize(){ //make a new gameloop
        this.game = new Game();
        setDisplays();
        
    }

    @FXML
    public void load(Game loadedGameLoop*/){ // initialize a saved gameloop
        this.game = loadedGameLoop;
        setDisplays();
    }

    @FXML
    public void setDisplays(){
        //Set the userPrompt Display, random even between savefiles
        try {
            loadPromptsFromFile("/userInputTextPrompts.txt");
            String randPrompt = getRandomPrompt();
            promptText.set(randPrompt);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //set the Health labels
        health.set(game.getHealth());
        HPLabel.textProperty().bind(Bindings.createStringBinding(() -> String.format("%d / %d", health.get(), maxHealth), health)); 

        //Set the logo
        Image logo = new Image(getClass().getResourceAsStream("/assets/Untitled_Artwork_27.PNG+"));
        logoImageView.setImage(logo); 

        //display the hints
        String hints = getConditionHints();
        hintText.set(hints);
        hintLabel.textProperty().bind(hints);

        //display the level


    }

    private String getConditionHints() {
    StringBuilder hintsBuilder = new StringBuilder();

    List<Condition> conditions =; /*game.getConditions();*/
    for (Condition condition : conditions) { //loop through every condition, add breaks when multiple.
        if (hintsBuilder.length() > 0) {
            hintsBuilder.append("\n"); 
        }
        hintsBuilder.append(condition.hint());
    }
    return hintsBuilder.toString();
}

    

    @FXML
    private void captureUserInput(){
        String Input = userInput.getText();

    /*  
    * 
    */
        userInput.clear();
    }

    private void EndPopup(){
        //Alert the user that the game has reached its end
        Alert gameOver = new Alert(AlertType.INFORMATION);
        gameOver.setTitle("Game Over");
        gameOver.setContentText("Your health has reached 0.");

        //wait for user to close popup
        gameOver.showAndWait(ifPresent(response ->{
            if(response == ButtonType.OK){
                    switchToPrimary();
            }
        }));
    }

    private void loadPromptsFromFile(String filePath) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("File not found " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String promptLine;
            while ((promptLine = reader.readLine()) != null) {
                prompts.add(promptLine.trim()); // Add each line to the list
            }
        }
    }

    private String getRandomPrompt() {
        if (prompts.isEmpty()) {
            return "Empty prompt file";
        }
        Random random = new Random();
        return prompts.get(random.nextInt(prompts.size()));
    }
}
package slaythepasswordfx;

import java.io.IOException;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("test");
    }
}