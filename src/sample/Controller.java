/* @author - Jana Grunewald
 * @class - COP 3003 - Object-Oriented Programming
 * @date created - 23 September 2019
 */

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/** The controller is what allows the GUI to have functionality. */
/* warning: Declaration redundancy, says the package could be private
however, if you make it private, the GUI will not run.
 */
public class Controller {
  @FXML public Button AddProduct;
  @FXML private ComboBox<Integer> ProduceCombo;
  @FXML public Button AddRecord;

  /* THE BELOW ARE USED IN MY STYLESHEET AND NEEDED
  TO BE ADDED TO THE CONTROLLER SINCE THEY ARE
  FX:IDs
  */
  @FXML public TabPane tabPane;
  @FXML public Tab productLineTab;
  @FXML public Label productName;
  @FXML public TextField nameBox;
  @FXML public TextField manBox;
  @FXML public ChoiceBox<Enum<ItemType>> choiceBox;
  @FXML public Label manufacturer;
  @FXML public Label itemType;
  @FXML public TableView tableView;
  @FXML public TableColumn tableViewProduct;
  @FXML public TableColumn tableViewAmount;
  @FXML public Label existingProducts;
  @FXML public Tab produceTab;
  @FXML public Label chooseProduct;
  @FXML public ListView productList;
  @FXML public Label chooseQuantity;
  @FXML public Tab productionLogTab;
  @FXML public TextArea productLog;

  /**
   * handleAddButtonAction is the main function for the addProduct button hard coded to print
   * Product added to the console.
   */
  public void handleAddButtonAction() {

    System.out.println("Product added."); // hard codes a response.
  }

  /**
   * handleAddRecordAction is the main function for the addRecord button hard coded to print Record
   * added to the console window.
   */
  public void handleAddRecordAction() {

    System.out.println("Record added."); // hard codes a response.
  }

  /**
   * the initialize function allows the GUI to connect to the database Populates the combo box to be
   * populated with values 1-10
   */
  public void initialize() {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionLine";

    //  Database credentials
    Connection conn;
    Statement stmt;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);

      // STEP 3: Execute a query
      stmt = conn.createStatement();
      String sql = "INSERT INTO PRODUCT(NAME,TYPE,MANUFACTURER) VALUES('iPod', 'AUDIO', 'Apple')";
      stmt.executeUpdate(sql);

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    // populates the combo box
    for (int i = 0; i <= 10; i++) {
      ProduceCombo.getItems().add(i);
    }
    // makes a drop down menu with numbers 1-10 and you can choose based of the amount you have.
    ProduceCombo.getSelectionModel().selectFirst();
    ProduceCombo.setEditable(true);

    for (ItemType choiceBoxPopulation : ItemType.values()) {
      choiceBox.getItems().add(choiceBoxPopulation);
    }
  }
}
