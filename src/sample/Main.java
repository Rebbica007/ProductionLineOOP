/* @author - Jana Grunewald
 * @class - COP 3003 - Object-Oriented Programming
 * @date created - 23 September 2019
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  /*
   the start function is setting up the GUI environment to view the GUI in a limited space.
   @param Stage sets the environment
   @param primaryStage sets the stage you would like to use
  */
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line");
    primaryStage.setScene(new Scene(root, 400, 400));
    primaryStage.show();
  }

  /**
   * this is what launches the GUI and allows you to see the functionality
   * creates things in memory
   * @param args this is a default function
   */
  public static void main(String[] args) {
    AudioPlayer newProduct = new AudioPlayer("DP-X1A", "Onkyo", "AUDIO", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    System.out.println(newProduct);
    newProduct.play();
    newProduct.stop();
    newProduct.next();
    newProduct.previous();
    launch(args);
  }
}
