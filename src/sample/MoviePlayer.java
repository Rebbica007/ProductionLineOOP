/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

import static sample.ItemType.VISUAL;

/**
 * This method will display the screen and monitor type, while taking in the type of product, the
 * name and manufacturer and display this in the console.
 */
public class MoviePlayer extends Product implements MultimediaControl {

  Screen screen;
  MonitorType monitorType;

  /**
   * This method will get the type of screen and return it to the console.
   *
   * @return - will display the type of screen that is being used.
   */
  public Screen getScreen() {
    return screen;
  }

  /**
   * This method will set the type of screen that is being used.
   *
   * @param screen - sets the private variable to a public variable.
   */
  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * This method will get the monitor type.
   *
   * @return - will display the type of monitor being used.
   */
  public MonitorType getMonitorType() {
    return monitorType;
  }

  /**
   * This method will set the type of monitor that is being used.
   *
   * @param monitorType - sets the private variable to a public variable.
   */
  public void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }

  /**
   * This method will use the name, manufacturer, monitor type and screen to display the different
   * information on the screen.
   *
   * @param name         - name of the product
   * @param manufacturer - name of the manufacturer
   * @param screen       - screen resolution, refresh rate and response time
   * @param monitorType  - type of monitor
   */
  MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer);
    super.setType(VISUAL);
    setScreen(screen);
    setMonitorType(monitorType);
  }

  /**
   * This method will display the results in sentence format.
   *
   * @return - prints out the information neatly.
   */
  @Override
  public String toString() {
    return super.toString() + "\nScreen:" + screen + "\nMonitor Type: " + monitorType;
  }

  /**
   * This method will print out Playing movie to show that it is working.
   */

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * This method will print out Stopping movie to show that it is working.
   */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * This method will print out Previous movie to show that it is working.
   */
  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  /**
   * This method will print out Next movie to show that it is working.
   */
  @Override
  public void next() {
    System.out.println("Next movie");
  }
}
