/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

import java.util.Date;

/**
 * This method sets the production number, the id, the serial number and the date the item was added
 * to the database.
 */
class ProductionRecord {

  private String Manufacturer;
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced = new Date();
  private int amount;
  private ItemType Type;

  /**
   * @param item
   * @param amount
   */
  public ProductionRecord(Product item, int amount) {
    this.productID = item.getId();
    this.Manufacturer = item.getManufacturer();
    this.amount = amount;
    Type = item.getType();
    this.serialNumber =
        this.Manufacturer.substring(0, 3) + item.getType().codes() + "0000" + this.amount;
  }

  /**
   * This method will put in the id, serial number, item number and the date into the dataase.
   *
   * @param item - adds a production number to the item.
   */
  public ProductionRecord(Product item) {
    this.productID = item.getId();
    this.Manufacturer = item.getManufacturer();
    this.amount = amount;
    Type = item.getType();
    this.serialNumber =
        this.Manufacturer.substring(0, 3) + item.getType().codes() + "0000" + this.amount;
  }

  /**
   * This method will start with one product an display the information about the product.
   *
   * @param productID - displays the id.
   */
  public ProductionRecord(int productID) {
    productionNumber = 0;
    serialNumber = "0";
    Date dateProduced = new Date();
  }

  /**
   * This method will print out the product number, serial number, date and the id on new lines.
   *
   * @return - will display the information in a neat fashion.
   */
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }

  /**
   * @return
   */
  public String getManufacturer() {
    return Manufacturer;
  }

  /**
   * @param manufacturer
   */
  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  /**
   * This method will grab the production number.
   *
   * @return - will return the production number.
   */
  public int getProductionNumber() {
    return productionNumber;
  }

  /**
   * This method will set the production number.
   *
   * @param productionNumber - will display a number.
   */
  public void setProductionNumber(int productionNumber) {
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
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * This method will set the serial number of the product.
   *
   * @param serialNumber - will display the serial number of the product.
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * This method will get the date the product was made.
   *
   * @return - will return the date.
   */
  public Date getDateProduced() {
    return dateProduced;
  }

  /**
   * This method will set the date the product was made.
   *
   * @param dateProduced - will display the date.
   */
  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * @return
   */
  public int getAmount() {
    return amount;
  }

  /**
   * @param amount
   */
  public void setAmount(int amount) {
    this.amount = amount;
  }

  /**
   * @return
   */
  public ItemType getType() {
    return Type;
  }

  /**
   * @param type
   */
  public void setType(ItemType type) {
    Type = type;
  }
}
