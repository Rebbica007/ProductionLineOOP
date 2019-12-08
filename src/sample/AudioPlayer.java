/**
 * Allows the user to add items to a database shows the usage of the database and linking other
 * information in it.
 *
 * @author Jana Grunewald
 */
package sample;

/**
 * This method will display the different audio types for the product.
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private String audioSpecification;
  private String mediaType;

  /**
   * This method will display the name, manufacturer, type, audio and media type to the console.
   *
   * @param name               - sets the name of the product.
   * @param manufacturer       - sets the name of the manufacturer.
   * @param audioSpecification - sets the audio specifications.
   * @param mediaType          - sets the media type.
   */
  public AudioPlayer(
      String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer);
    this.setType(ItemType.AUDIO);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * This method will display the audio format and the type of media in a sentence format.
   *
   * @return - will return the name, manufacturer, type, audio and media type.
   */
  public String toString() {
    String spec = "Supported Audio Formats: " + this.audioSpecification + '\n';
    String media = "Supported Playlist Formats: " + this.mediaType;
    return super.toString() + spec + media;
  }

  /**
   * This method will display if the user played the program.
   */
  public void play() {
    System.out.println("Playing");
  }

  /**
   * This method will display if the user stopped the program.
   */
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * This method will display if the user skipped to the next audio.
   */
  public void next() {
    System.out.println("Next");
  }

  /**
   * This method will display if the user went back to the previous audio.
   */
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * This method will get the type of audio being used.
   *
   * @return - returns the type of audio being used.
   */
  public String getAudioSpecification() {
    return audioSpecification;
  }

  /**
   * This method will set the type of audio being used.
   *
   * @param audioSpecification - displays the type of audio being used.
   */
  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  /**
   * This method will get the type of media being played.
   *
   * @return - returns the media type.
   */
  public String getMediaType() {
    return mediaType;
  }

  /**
   * This method will set the type of media being played.
   *
   * @param mediaType - displays the type of media being played.
   */
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
}
