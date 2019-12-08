/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */

package sample;

/**
 * This method sets up the methods used for the controls like a music service.
 */
interface MultimediaControl {

  /**
   * This method will display if the music/movie is playing.
   */
  void play();

  /**
   * This method will display if the music/movie is stopped.
   */
  void stop();

  /**
   * This method will display if the user chose to move back in the music/video playlist.
   */
  void previous();

  /**
   * This method will display if the user chose to move forward in the music/video playlist.
   */
  void next();
}
