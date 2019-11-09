package sample;

/** This method sets up the methods used for the controls like a music service. */
public interface MultimediaControl {

  /** This method will display if the music/movie is playing. */
  void play();

  /** This method will display if the music/movie is stopped. */
  void stop();

  /** This method will display if the user chose to move back in the music/video playlist. */
  void previous();

  /** This method will display if the user chose to move forward in the music/video playlist. */
  void next();
}
