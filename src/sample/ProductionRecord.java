package sample;

import java.util.Date;

/**
 * This method sets the production number, the id, the serial number and the date the item was added
 * to the database.
 */
public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  /**
   * This method will increment the product id with the different items that are added.
   *
   * @param productProduced - puts the number of the product being produced.
   * @param items - sets the number of the id and increments.
   */
  public ProductionRecord(Product productProduced, int items) {
    String id = String.format("%05d", items);
    // formats and sets cereal number
    this.serialNumber =
        productProduced.Manufacturer.substring(0, 3) + productProduced.getType().getCodes() + id;
  }

  /**
   * This method will start with one product an display the information about the product.
   *
   * @param productID - displays the id.
   */
  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * This method will put in the id, serial number, product number and the date into the dataase.
   *
   * @param productionNumber - adds a production number to the product.
   * @param productID - displays the id for the product.
   * @param serialNumber - displays the serial number for the product.
   * @param dateProduced - displays the date and time the item was added to the database.
   */
  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productID = productID;
    this.productionNumber = productionNumber;
    this.dateProduced = dateProduced;
    this.serialNumber = serialNumber;
  }

  /**
   * This method will print out the product number, serial number, date and the id on new lines.
   *
   * @return - will display the information in a neat fashion.
   */
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " \nProduct ID: "
        + productID
        + " \nSerial Num: "
        + serialNumber
        + " \nDate: "
        + dateProduced;
  }

  /**
   * This method will grab the production number.
   *
   * @return - will return the production number.
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * This method will set the production number.
   *
   * @param productionNumber - will display a number.
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * This method will get the product id.
   *
   * @return - will return the product id.
   */
  public int getProductID() {
    return productID;
  }

  /**
   * This method will set the product id.
   *
   * @param productID - will display the product id.
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * This method will get the serial number of the product.
   *
   * @return - will return the serial number.
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * This method will set the serial number of the product.
   *
   * @param serialNumber - will display the serial number of the product.
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * This method will get the date the product was made.
   *
   * @return - will return the date.
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * This method will set the date the product was made.
   *
   * @param dateProduced - will display the date.
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }
}
