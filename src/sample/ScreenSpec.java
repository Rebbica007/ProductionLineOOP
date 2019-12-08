/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

/**
 * This method sets the different methods that will be used in displaying the screen
 * specifications.
 */
public interface ScreenSpec {

  /**
   * This method will populate the resolution variable.
   *
   * @return - returns the type of resolution.
   */
  String getResolution();

  /**
   * This method will populate the refresh rate variable.
   *
   * @return - returns the refresh rate.
   */
  int getRefreshRate();

  /**
   * This method will populate the response time variable.
   *
   * @return - returns the response time.
   */
  int getResponseTime();

  /**
   * This method will set the resolution variable.
   *
   * @param resolution - sets the variable to a public variable.
   */
  void setResolution(String resolution);

  /**
   * This method will set the refresh rate variable.
   *
   * @param refreshRate - sets the variable to a public variable.
   */
  void setRefreshRate(int refreshRate);

  /**
   * This method will set the response time variable.
   *
   * @param responseTime - sets the variable to a public variable.
   */
  void setResponseTime(int responseTime);
}
