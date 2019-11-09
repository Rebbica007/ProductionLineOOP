package sample;

/** This method will tell you the specifications of the screen you are using. */
public class Screen implements ScreenSpec {
  private String Resolution;
  private int RefreshRate;
  private int ResponseTime;

  /**
   * This method will display the different settings for a screen. Resolution, refresh rate and
   * response time.
   *
   * @param resolution - Will return from the monitor type enum.
   * @param refreshRate - will return an int.
   * @param responseTime - will return an int.
   */
  Screen(String resolution, int refreshRate, int responseTime) {
    this.Resolution = resolution;
    this.RefreshRate = refreshRate;
    this.ResponseTime = responseTime;
  }

  /**
   * This method converts everything to a string for easier readability.
   *
   * @return - will print out a sentence with the information provided.
   */
  public String toString() {
    return "Screen:"
        + "\n"
        + "Resolution: "
        + Resolution
        + "\n"
        + "Refresh rate: "
        + RefreshRate
        + "\n"
        + "Response time: "
        + ResponseTime;
  }

  /**
   * This method will populate the resolution variable.
   *
   * @return - returns the type of resolution.
   */
  public String getResolution() {
    return Resolution;
  }

  /**
   * This method will set the resolution variable.
   *
   * @param resolution - sets the variable to a public variable.
   */
  public void setResolution(String resolution) {
    Resolution = resolution;
  }

  /**
   * This method will populate the refresh rate variable.
   *
   * @return - returns the refresh rate.
   */
  public int getRefreshRate() {
    return RefreshRate;
  }

  /**
   * This method will set the refresh rate variable.
   *
   * @param refreshRate - sets the variable to a public variable.
   */
  public void setRefreshRate(int refreshRate) {
    RefreshRate = refreshRate;
  }

  /**
   * This method will populate the response time variable.
   *
   * @return - returns the response time.
   */
  public int getResponseTime() {
    return ResponseTime;
  }

  /**
   * This method will set the response time variable.
   *
   * @param responseTime - sets the variable to a public variable.
   */
  public void setResponseTime(int responseTime) {
    ResponseTime = responseTime;
  }
}
