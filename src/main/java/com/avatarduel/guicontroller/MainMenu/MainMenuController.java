package com.avatarduel.guicontroller.MainMenu;

import com.avatarduel.guicontroller.Board.BoardController;
import com.avatarduel.guicontroller.util.FXMLHandler;
import com.avatarduel.guicontroller.Request.GlobalRequest.PlayMusicRequest;
import com.avatarduel.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * used to manage the main menu scene which has 3 button, start, how to play, and cards ( to show the card library )
 * @author G10-K03-CardGameOOP
 */
public class MainMenuController {
    private Stage stage;
    private MediaPlayer mediaPlayer;
    private Thread musicThread;

    @FXML private Label start;
    @FXML private Label how_to_play;
    @FXML private Label cards;

    /**
     * play the theme music
     */
    @FXML
    public void initialize() {
        playMainMenuSong();
    }

    /**
     * set the stage, used by file AvatarDuel. java to set the main menu on window stage
     * @param stage avatar duel's stage
     * @throws IOException if the main menu fxml file is not found
     */
    public void setStage(Stage stage) throws IOException {
        this.stage = stage;
        this.setStart();
        this.setHowToPlayPopUp();
        this.setCardsPopUp();
        Game.getInstance().getEventBus().register(this);
    }

    /**
     * set up the start button, used privately
     * to start the game and change the music
     * if there is an error loading the game, it will display an alert
     */
    private void setStart() {
        FXMLHandler fxmlHandler = new FXMLHandler("GUI/Board/Board.fxml");
        try {
            FXMLLoader fxmlLoader = fxmlHandler.getFxmlLoader();
            Parent startGui = fxmlLoader.load();
            Scene startScene = new Scene(startGui);
            BoardController boardController = fxmlLoader.getController();
            start.onMouseClickedProperty().setValue(event -> {
                Game.getInstance().getEventBus().post(new PlayMusicRequest());
                stage.setScene(startScene);
                stage.setFullScreen(true);
                mediaPlayer.stop();
            }
            );
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Loading error");
            alert.setContentText("Cannot Load Board.fxml in Mainmenucontroller.java");
            alert.show();
        }
    }

    /**
     * set up how to play popup window
     */
    private void setHowToPlayPopUp() {
        HowToPlayController howToPlay = new HowToPlayController();
        howToPlay.setStage(stage);
        how_to_play.onMouseClickedProperty().setValue(e -> {
            howToPlay.goToPage1();
        });
    }

    /**
     * set up card library pop up window
     */
    private void setCardsPopUp() throws IOException {
        FXMLHandler fxmlHandler = new FXMLHandler("GUI/MainMenu/ShowCards/ShowCards.fxml");
        FXMLLoader fxmlLoader = fxmlHandler.getFxmlLoader();
        fxmlLoader.load();
        CardLibraryController cardLibraryController = fxmlLoader.getController();
        cardLibraryController.setWindow(stage);
        cards.onMouseClickedProperty().setValue(e -> {
            cardLibraryController.start();
        });
    }

    /**
     * play the theme song
     */
    private void playMainMenuSong() {
        musicThread = new Thread(() -> {
            try {
                File musicFile = new File("src/main/resources/com/avatarduel/music/main_song.mp3");
                URL musicURL = musicFile.toURI().toURL();
                Media media = new Media(musicURL.toString());
                this.mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }
            catch(Exception e) { }
        });
        musicThread.start();
    }
}
