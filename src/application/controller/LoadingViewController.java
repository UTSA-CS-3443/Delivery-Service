package application.controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class LoadingViewController implements Initializable {
	
	@FXML
	Button continueButton;

	@FXML
	Label tipOne, tipTwo;
	
	@FXML
	ImageView vecnaImageView;
	
	@FXML
	Image vecnaPixelImage;
	
	@FXML
	MediaView mediaLoading;
	
	@FXML 
	MediaPlayer mediaPlayer;
	
	//private static final String MEDIA_URL= "src/application/videos/ArgleMission.mp4";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		 String mediaURL = "src/application/videos/mainMenuBackground.mp4";
//	        Media media1 = new Media(Paths.get(mediaURL).toUri().toString());
//	        mediaBackground = new MediaPlayer(media1);
//	        mediaBackground.setAutoPlay(true);
//	        mediaBackground.setCycleCount(-1);
//	        backgroundMedia.setMediaPlayer(mediaBackground);
		
		 String mediaURL = "src/application/videos/ClipChampRedBar.mp4";
	        Media media1 = new Media(Paths.get(mediaURL).toUri().toString());
	        mediaPlayer = new MediaPlayer(media1);
	        mediaPlayer.setAutoPlay(true);
	        //mediaLoading.setCycleCount(-1);
	        mediaLoading.setMediaPlayer(mediaPlayer);
		
//		System.out.println(location.toString());
//		System.out.println(this.getClass().getResource(MEDIA_URL).toExternalForm());
//		
//		mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));
//		mediaPlayer.setAutoPlay(true);
//		mediaLoading.setMediaPlayer(mediaPlayer);
		
	}

public void handle(ActionEvent event) {
    try {

        // Determines which button was pushed and loads that FXML Scene.
        Button buttonPushed = (Button) event.getSource();

        String newScene = "";

        if (buttonPushed.getId().equals("continueButton")) {
            newScene = "GameView.fxml";
            
            // Connect to the FXML (contains our layout) and load it in.
            Parent root = FXMLLoader.load(Main.class.getResource("view/" + newScene));

            // Put the layout onto the scene.
            Scene scene = new Scene(root);

            // Set the scene on the stage that was created in Main.java.
            Main.stage.setScene(scene);
            Main.stage.show();
            
        }
    }
    catch (Exception e) {
    	
    }
}

}