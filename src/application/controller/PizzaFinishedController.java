package application.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import application.Main;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Allows user to either go back home or go back to the GameView.fxml and make
 * another pizza.
 * 
 * @author Amalia Talijancic
 * @author Danny Ghrist (kda458)
 *
 */

public class PizzaFinishedController implements EventHandler<ActionEvent> {

    @FXML
    Button homeButton, morePizzaButton, exitButton;

    @FXML
    Text hoorayPizzaFinishedText;

    @FXML
    ImageView winArgyle;

    @FXML
    MediaPlayer mediaSFX;
    
    MediaPlayer mediaPlayer;
    
    /**
     * @author - Amalia's edits Here's a handle for the Home Button meant for the
     *         Game View
     * @author Danny Ghrist (kda458): I deleted the extra method as I have a
     *         combined method that can handle moving wherever the user needs to go
     *         determined by which button they press. I incorporated your home
     *         button here for brevity.
     */
    
    @Override
    public void handle(ActionEvent event) {
        try {
        	
            // Determine which button was pressed.
            Button buttonPushed = (Button) event.getSource();

            String newScene = "";

            // Determines which button was pushed and loads that FXML Scene.
            if (buttonPushed.getId().equals("homeButton")) {
                newScene = "MainView.fxml";
                playSound("buttonclick");
            } else if (buttonPushed.getId().equals("morePizzaButton")) {
                newScene = "GameView.fxml";
                playSound("buttonclick");
            } else if (buttonPushed.getId().equals("exitButton")) {
                playSound("buttonclick");
                newScene = null;
            } else if (buttonPushed.getId().equals(null)) {
                System.out.println("IT'S ALL WRONG, WHAT HAVE YOU DONE!!!");
            }

            if (newScene == null) {
//                Platform.exit();
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            } else {
                // Connect to the FXML (contains our layout) and load it in.
                Parent root = FXMLLoader.load(Main.class.getResource("view/" + newScene));

                // Put the layout onto the scene.
                Scene scene = new Scene(root);

                // Set the scene on the stage that was created in Main.java.
                Main.stage.setScene(scene);
            	try {
        			setCursor("normalClick");
        		} catch (FileNotFoundException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
                Main.stage.show();
              
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Event listener to play a sound effect for when a user hovers over a button.
     */
    public void setCursor(String imageName) throws FileNotFoundException
    {
    	Image myImage = new Image(new FileInputStream("src/application/images/"+imageName+".png"));
    	ImageCursor cursor = new ImageCursor(myImage, 0, 0);
    	Scene scene = Main.stage.getScene();
    	scene.getRoot().setCursor(cursor);
    }
    public void buttonEntered() {
        playSound("buttonhover");
    	try {
			setCursor("normalClick");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void buttonExit()
    {
    	try {
			setCursor("normalSelect");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void playSound(String soundName) {
        String s = "src/application/audio/" + soundName + ".mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        // Media(getClass().getResource("application/audio/StrangerThingsThemeSong.mp3").toExternalForm());
        mediaSFX = new MediaPlayer(h);
        mediaSFX.play();
        // mediaPlayer.setStartTime(Duration.seconds(0));
        // mediaPlayer.setAutoPlay(true);
    }
    
}
