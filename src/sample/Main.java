/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This method makes the scenes show up and the application function.
 */
public class Main extends Application {

  @Override
  /**
   * The start function is setting up the GUI environment to view the GUI in a limited space.
   *
   * @param Stage - sets the environment
   * @param primaryStage - sets the stage you would like to use
   */
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 424, 376));
    primaryStage.show();
  }

  /**
   * This method is what makes the GUI run.
   *
   * @param args - displays the gui on screen.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
