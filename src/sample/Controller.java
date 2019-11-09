/* @author - Jana Grunewald
 * @class - COP 3003 - Object-Oriented Programming
 * @date created - 23 September 2019
 */

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This method is what makes the gui run properly. All the different interactions within the gui are
 * controlled through this file.
 */
public class Controller {
  @FXML public Button AddProduct;
  @FXML private ComboBox<Integer> ProduceCombo;
  @FXML public Button AddRecord;
  @FXML public TabPane tabPane;
  @FXML public Tab productLineTab;
  @FXML public Label productName;
  @FXML public TextField nameBox;
  @FXML public TextField manBox;
  @FXML public ChoiceBox<String> choiceBox;
  @FXML public Label manufacturer;
  @FXML public Label itemType;
  @FXML public TableView<Product> tableView;
  @FXML public TableColumn<?, ?> tableViewProduct;
  @FXML public TableColumn<?, ?> tableViewAmount;
  @FXML public TableColumn<?, ?> tableViewItemType;
  @FXML public Label existingProducts;
  @FXML public Tab produceTab;
  @FXML public Label chooseProduct;
  @FXML public ListView<Product> productList;
  @FXML public Label chooseQuantity;
  @FXML public Tab productionLogTab;
  @FXML public TextArea productLog;

  // global vars
  private Connection conn;

  // observable list used for the table view
  private final ObservableList<Product> productLine = FXCollections.observableArrayList();

  /**
   * This method allows the user to insert an item into the database. This also makes the item show
   * up in the table view below the button.
   *
   * @throws SQLException - uses sql to insert data into the database.
   */
  public void handleAddButtonAction() throws SQLException {

    // initialise variables
    String prodName = nameBox.getText();
    String prodMan = manBox.getText();
    String prodChoice = choiceBox.getValue();

    // database accepts input from user
    String information = "INSERT INTO PRODUCT (NAME, MANUFACTURER, TYPE) VALUES (?,?,?)";

    // Prepared statement and connection
    PreparedStatement prepStat = conn.prepareStatement(information);

    // Prepared statement sets values of name, manufacturer and type
    prepStat.setString(1, prodName);
    prepStat.setString(2, prodMan);
    prepStat.setString(3, prodChoice);
    prepStat.executeUpdate();

    // print when button is clicked
    System.out.println("The product has been added.");

    // clear text fields
    nameBox.clear();
    manBox.clear();

    // this will show the data in the table view
    tableViewProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
    tableViewAmount.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    tableViewItemType.setCellValueFactory(new PropertyValueFactory<>("type"));

    // sets the items to productLine(observableList)
    tableView.setItems(productLine);

    // uses widget to add values
    productLine.add(new Widget(prodName, prodMan, ItemType.valueOf(prodChoice)));

    // sets the values from the product line to the list view
    productList.setItems(productLine);

    // clear environment
    prepStat.close();
    conn.close();
  }

  /** This method allows the quantity to be updated in the database. */
  public void handleAddRecordAction() {
    // print when button is clicked
    System.out.println("The product has been added.");
  }

  /**
   * This method allows the database to receive items. This also populates the combo boxes and the
   * choice boxes to allow users to choose an amount and type.
   */
  public void initialize() {

    // call to initialize the database connection
    initializeData();

    // Observable list to populate combo box
    ObservableList<Integer> amount =
        FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    ProduceCombo.setItems(amount);
    ProduceCombo.getSelectionModel().selectFirst();
    ProduceCombo.setEditable(true);

    // enhanced for loop to populate the item choices
    ObservableList<String> items = FXCollections.observableArrayList();
    for (ItemType itemChoice : ItemType.values()) {
      System.out.println(itemChoice + " " + itemChoice.codes);
      items.add(String.valueOf(itemChoice));
    }

    // shows all items possible to choose from
    choiceBox.getItems().addAll(items);

    // display an instance of production record in the text area in the production log tab
    ProductionRecord productionRec = new ProductionRecord(0);
    String product = productionRec.toString();
    productLog.setText(product);
  }

  /** This method sets up the database and stores the data. */
  private void initializeData() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionLine";

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
