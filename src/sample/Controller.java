package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Controller {
  @FXML public Button AddProduct;
  @FXML private ComboBox<Integer> ProduceCombo;
  @FXML public Button AddRecord;


  public void handleAddButtonAction() {
    System.out.println("Product added.");
  }

  public void handleAddRecordAction() {
    System.out.println("Record added.");
  }

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
      String sql = "INSERT INTO PRODUCT(NAME,TYPE,MANUFACTURER) VALUES('iPod','AUDIO','Apple')";
      stmt.executeUpdate(sql);

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    for (int i = 0; i <= 10; i++) {
      ProduceCombo.getItems().add(i);
    }

    ProduceCombo.getSelectionModel().selectFirst();
    ProduceCombo.setEditable(true);
  }
}
