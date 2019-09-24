package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
  public Button AddProduct;
  public Button AddRecord;

  @FXML
  protected void handleAddButtonAction(ActionEvent event) {
    // Button was clicked, print this
    System.out.println("Product added.");
  }

  @FXML
  protected void handleAddRecordAction(ActionEvent event) {
    // Button was clicked, print this
    System.out.println("Record added.");
  }

}
