package sample;

/** This method will take the items and display them in the gui. */
public abstract class Product implements Item {

  private int Id;
  public ItemType Type;
  public String Manufacturer;
  public String Name;

  /**
   * This method will take the name, manufacturer and type of the product and populate in other
   * areas.
   *
   * @param name - takes the name of the product.
   * @param manufacturer - takes the name of the manufacturer.
   * @param type - takes the type of product.
   */
  Product(String name, String manufacturer, ItemType type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
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
   * This method will get the manufacturer's name of the product.
   *
   * @return - returns the manufacturer's name.
   */
  public String getManufacturer() {
    return Manufacturer;
  }

  /**
   * This method will set the manufacturer's name of the product.
   *
   * @param manufacturer - displays the maufacturer's name.
   */
  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  /**
   * This method will get the name of the product.
   *
   * @return - returns the name of the product.
   */
  public String getName() {
    return Name;
  }

  /**
   * This method will set the name of the product.
   *
   * @param name - displays the name of the product.
   */
  public void setName(String name) {
    Name = name;
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
}
