/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

/**
 * This method will take the items and display them in the gui.
 */
public abstract class Product implements Item {

  private int Id;
  private ItemType Type;
  private String name;
  private String manufacturer;

  /**
   * This method calls the name of the manufacturer and the product.
   *
   * @param Name         - product name
   * @param Manufacturer - manufacturer name
   */
  public Product(String Name, String Manufacturer) {
    name = Name;
    manufacturer = Manufacturer;
  }

  /**
   * This method will get the name of the product.
   *
   * @return - returns the name of the product.
   */
  public String getname() {
    return name;
  }

  /**
   * This method will take the name, manufacturer and type of the product and populate in other
   * areas.
   *
   * @param name         - takes the name of the product.
   * @param manufacturer - takes the name of the manufacturer.
   * @param type         - takes the type of product.
   */
  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.Type = type;
  }

  /**
   * This method will get the type of product it is.
   *
   * @return - returns the type of item.
   */
  public ItemType getType() {
    return Type;
  }

  /**
   * This method will set the type of product.
   *
   * @param type - displays the type of product it is.
   */
  public void setType(ItemType type) {
    Type = type;
  }

  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + Type;
  }

  /**
   * This method will get the id of the product.
   *
   * @return - returns the product id.
   */
  public int getId() {
    return Id;
  }

  /**
   * This method will set the id of the product.
   *
   * @param id - sets a unique id for the products added.
   */
  public void setId(int id) {
    this.Id = id;
  }

  /**
   * This method will get the manufacturer's name of the product.
   *
   * @return - returns the manufacturer's name.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * This method will set the manufacturer's name of the product.
   *
   * @param manufacturer - displays the maufacturer's name.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * This method will get the name of the product.
   *
   * @return - returns the name of the product.
   */
  public String getName() {
    return name;
  }

  /**
   * This method will set the name of the product.
   *
   * @param name - displays the name of the product.
   */
  public void setName(String name) {
    this.name = name;
  }
}

/**
 * This class makes crazy things happen.
 */
class Widget extends Product {

  Widget(String name, String manufacturer, ItemType type) {

    super(name, manufacturer, type);
  }

  /**
   * This method is part of the crazy things.
   *
   * @param dbId          - database id
   * @param dbName        - database name
   * @param dbManufactuer - database manufacturer
   * @param ItemType      - database item type
   */
  public Widget(int dbId, String dbName, String dbManufactuer, ItemType ItemType) {
    super(dbName, dbManufactuer, ItemType);
    setId(dbId);
  }
}
