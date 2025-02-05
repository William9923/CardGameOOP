package com.avatarduel;

import com.avatarduel.guicontroller.MainMenu.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * main application
 * @author G10-K03-CardGameOOP, Lab programming
 */
public class AvatarDuel extends Application {
  private MediaPlayer mediaPlayer;

  /**
   * Start the game
   * @param stage stage for the application to show
   */
  @Override
  public void start(Stage stage) {
    // Load Main Menu
    try {
      FXMLLoader mainmenuLoader = getMainMenu();
      Parent mainmenuGUI = mainmenuLoader.load();
      Scene mainmenu = new Scene(mainmenuGUI);
      MainMenuController mainMenuController = mainmenuLoader.getController();
      mainMenuController.setStage(stage);

      // set up game

      stage.setTitle("Avatar Duel OOP");
      stage.setScene(mainmenu);
      stage.setFullScreen(true);
      stage.show();
    }
    catch (Exception e) {
      Alert alertBox = new Alert(Alert.AlertType.ERROR);
      alertBox.setContentText("Cant load the game due to error " + e.getMessage());
    }
  }

  /**
   * Load main menu from MainMenu.fzml
   * @return fxmlLoader of mainmenu
   */
  private FXMLLoader getMainMenu() {
    return new FXMLLoader(getClass().getResource("GUI/MainMenu/MainMenu.fxml"));
  }

  /**
   * main program
   */
  public static void main(String[] args) {
    launch();
  }
}