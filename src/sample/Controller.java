/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.collections.FXCollections;
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
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This method is what makes the gui run properly. All the different interactions within the gui are
 * controlled through this file.
 */
public class Controller {

  @FXML
  public Tab productLineTab;

  @FXML
  public Tab produceTab;

  @FXML
  public Tab productionLogTab;

  @FXML
  public TextField nameBox;

  @FXML
  public TextField manBox;

  @FXML
  public Label itemType;

  @FXML
  public TabPane tabPane;

  @FXML
  private Label productName;

  @FXML
  private Label manufacturer;

  @FXML
  public Label existingProducts;

  @FXML
  public Label chooseProduct;

  @FXML
  public Label chooseQuantity;

  @FXML
  public ListView<Product> productList;

  @FXML
  public ChoiceBox<ItemType> choiceBox;

  @FXML
  public Button AddProduct;

  @FXML
  private TableColumn<?, ?> tableViewProductId;

  @FXML
  public TableColumn<?, ?> tableViewProduct;

  @FXML
  public TableColumn<?, ?> tableViewType;

  @FXML
  public TableColumn<?, ?> tableViewManufacturer;

  @FXML
  public TableView tableView;

  @FXML
  public Button AddRecord;

  @FXML
  public ComboBox<Integer> ProduceCombo;

  @FXML
  public Button logButton;

  @FXML
  public TextArea productLog;
  private Connection conn;

  /**
   * This method will add the item to the table view.
   *
   * @param event - just a variable name generated with the handle.
   */
  public void handleAddButtonAction(ActionEvent event) {

    String itemTypeString = choiceBox.getValue().toString(); // audio
    String manufacturerString = manufacturer.getText(); // friend
    String nameString = productName.getText(); // favorite

    try {
      Statement stmt = conn.createStatement();

      // "INSERT INTO Product (type, manufacturer, name) VALUES ('mytype', 'manufactuer', 'name')"
      String sql =
          "INSERT INTO Product(type, manufacturer, name)"
              + "VALUES ('"
              + itemTypeString
              + "', '"
              + manufacturerString
              + "', '"
              + nameString
              + "')";
      stmt.executeUpdate(sql);
      tableView.setItems(FXCollections.observableArrayList(productsAdded()));
    } catch (SQLException | NullPointerException e) {
      // System.out.println("the handleAddProductAction catch worked!");
      // e.printStackTrace();

      System.out.println("This is from the catch!");
    }
  }

  /**
   * This method adds the items to the log on the last tab.
   *
   * @param event - just a variable name generated with the handle.
   */
  public void handleGetLogAction(ActionEvent event) {
    ArrayList<Product> products = productsAdded();
    for (Product product : products) {
      productLog.appendText(product.toString());
    }
  }

  /**
   * This method allows the quantity to be updated in the database.
   */
  public void handleAddRecordAction(ActionEvent event) {
    int i = ProduceCombo.getValue();
    for (int j = 0; j < i; j++) {
      System.out.println(
          "Item Produced: \n"
              + (j + 1)
              + " "
              + productList.getSelectionModel().getSelectedItem()
              + "\n");
    }
    productList.setItems(FXCollections.observableArrayList(productsAdded()));
  }

  /**
   * This method connects to the database.
   */
  public void connectToDB() {
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionLine";

    //  Database credentials
    final String USER = "";
    final String PASS = "";

    conn = null;

    Statement stmt = null;
    try {
      // STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, "admin", "admin");
      System.out.println("Connected database successfully...");
    } catch (Exception se) {
      se.printStackTrace();
    }
  }

  /**
   * This method adds all the products to the table view.
   *
   * @return - will return all the products added.
   */
  public ArrayList<Product> productsAdded() {
    ArrayList<Product> products = new ArrayList<>();
    try {
      Statement smt = conn.createStatement();
      String sql = "SELECT * FROM PRODUCT";
      ResultSet resultSet = smt.executeQuery(sql);
      while (resultSet.next()) {
        int rsId = resultSet.getInt("ID");
        String rsName = resultSet.getString("NAME");
        String rsType = resultSet.getString("TYPE");
        String rsManufactuer = resultSet.getString("MANUFACTURER");
        ItemType ItemType;
        if (rsType.equals("AUDIO")) {
          ItemType = sample.ItemType.AUDIO;
        } else if (rsType.equals("VISUAL")) {
          ItemType = sample.ItemType.VISUAL;
        } else if (rsType.equals("AUDIO_MOBILE")) {
          ItemType = sample.ItemType.AUDIO_MOBILE;
        } else if (rsType.equals("VISUAL_MOBILE")) {
          ItemType = sample.ItemType.VISUAL_MOBILE;
        } else {
          ItemType = null;
        }
        Widget a = new Widget(rsId, rsName, rsManufactuer, ItemType);
        products.add(a);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return products;
  }

  /**
   * This method allows the database to receive items. This also populates the combo boxes and the
   * choice boxes to allow users to choose an amount and type.
   */
  public void initialize() {
    connectToDB();
    testMultimedia();
    productsAdded();
    ArrayList<Product> products = productsAdded();
    tableView.setItems(FXCollections.observableArrayList(productsAdded()));
    productList.setItems(FXCollections.observableArrayList(productsAdded()));
    tableViewProductId.setCellValueFactory(new PropertyValueFactory<>("Id"));
    tableViewType.setCellValueFactory(new PropertyValueFactory<>("Type"));
    tableViewProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
    tableViewManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

    for (Product product : products) {
      productLog.appendText(product.toString());
    }

    choiceBox.setItems(FXCollections.observableArrayList(ItemType.values()));
    ProduceCombo.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  /**
   * This method tests the multimedia aspect of the application.
   */
  public static void testMultimedia() {
    AudioPlayer newAudioProduct =
        new AudioPlayer(
            "DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct =
        new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen, MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }
}
