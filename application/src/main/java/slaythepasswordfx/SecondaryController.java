package slaythepasswordfx;

import java.io.IOException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//essential FXML variables


public class SecondaryController {
    @FXML
    private TextField userInput;
    @FXML
    private Label HPLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private ImageView logoImageView;

    //Essential Backend variables
    private IntegerProperty health = new SimpleIntegerProperty(/*Gameloop.User.getHealth()*/);
    private String maxHealth;



    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void initialize(){
        HPLabel.textProperty().bind(health.asString("%d / "+ maxHealth));
        nameLabel.setText("TEST TEST CHANGE");
        Image logo = new Image(getClass().getResourceAsStream("/assets/Untitled_Artwork_27.PNG"));
        logoImageView.setImage(logo);
    }

    @FXML
    private void captureUserInput(){
        String Input = userInput.getText();

        /*if (true) {
            //Game loop?        
        }else{
            if(user.getHealth() > 0){
                //end screen
            }   
            else{
                User.loseHP(1);
            //}
        }*/

        userInput.clear();

    }

}