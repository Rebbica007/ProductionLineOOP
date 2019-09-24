package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Controller {
  public Button AddProduct;
  public Button AddRecord;
  private ComboBox<String> cboTableName = new ComboBox<>();


  @FXML
  protected void handleAddButtonAction(ActionEvent event) {
    // Button was clicked, print this
    System.out.println("Product added.");

  }

  @FXML
  protected void handleAddRecordAction(ActionEvent event) {
    // Button was clicked, print this
    System.out.println("Record added.");
    addToDatabase();

  }

  private void addToDatabase() {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/HR";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn;
    Statement stmt;

    cboTableName.getItems().add("PRODUCT");

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES ('iPod', 'AUDIO', 'Apple') " ;

      stmt.executeUpdate(sql);

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();

    }

  }


}
