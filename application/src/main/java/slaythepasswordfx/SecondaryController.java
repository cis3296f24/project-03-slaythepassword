package slaythepasswordfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//essential FXML variables
@FXML
private TextField userInput;
@FXML
private Label HPLabel;
@FXML
private Label nameLabel;
@FXML
private ImageView logoImageView;

//Essential Backend variables
private IntegerProperty health = new SimpleIntegerProperty(/*User.getHealth()*/);
private String maxHealth;


public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void initialize(){
        healthLabel.textProperty().bind(health.asString("%d / "+ maxHealth));
        nameLabel.setText(/*User.getName()*/);
        Image logo = new Image(getClass()getResourceAsStream("/assets/Untitled_Artwork_27.PNG"));
    }

    @FXML
    private void captureUserInput(){
        String Input = userInput.getText();

        if (true) {
            //Game loop?        
        }else{
            /*
            if(user.getHealth() > 0){
                //end screen
            }   
            else{
                User.loseHP(1);*/
            //}
        }

        userInput.clear();

    }

}