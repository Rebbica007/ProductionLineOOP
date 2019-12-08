/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

/**
 * This method sets the methods for name, manufacturer and type.
 */
public interface Item {

  /**
   * This method gets the id of the product.
   *
   * @return - will return the id of the product.
   */
  int getId();

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
}
