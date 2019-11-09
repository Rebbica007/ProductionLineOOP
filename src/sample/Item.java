package sample;

/** This method sets the methods for name, manufacturer and type. */
public interface Item {

  /**
   * This method sets the name of the product.
   *
   * @param name - displays the name of the product.
   */
  void setName(String name);

  /**
   * This method gets the name of the product.
   *
   * @return - returns the name of the product.
   */
  String getName();

  /**
   * This method sets the manufacturer of the product.
   *
   * @param manufacturer - displays the manufacturer's name.
   */
  void setManufacturer(String manufacturer);

  /**
   * This method gets the manufacturer of the product.
   *
   * @return - returns the manufacturer's name.
   */
  String getManufacturer();

  /**
   * This method gets the type of product.
   *
   * @return - returns the type of product.
   */
  ItemType getType();

  /**
   * This method sets the type of product.
   *
   * @param type - displays the type of product.
   */
  void setType(ItemType type);
}
