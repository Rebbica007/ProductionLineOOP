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
import java.util.ArrayList;

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
    primaryStage.setTitle("Production Line");
    primaryStage.setScene(new Scene(root, 400, 400));
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
