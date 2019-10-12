package sample;

public class AudioPlayer extends Product implements MultimediaControl{

  private String audioSpecification;
  private String mediaType;

  AudioPlayer(String name, String manufacturer, String type, String audioSpecification,
      String mediaType){
    super(name, manufacturer, type);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  public String toString(){
    String spec = "Supported Audio Formats: " + this.audioSpecification + '\n';
    String media = "Supported Playlist Formats: " + this.mediaType;
    return super.toString() + spec + media;
  }

  public void play(){
    System.out.println("Playing");
  }

  public void stop(){
    System.out.println("Stopping");
  }

  public void next(){
    System.out.println("Next");
  }

  public void previous(){
    System.out.println("Previous");
  }

  public String getAudioSpecification(){
    return audioSpecification;
  }

  public void setAudioSpecification(String audioSpecification){
    this.audioSpecification = audioSpecification;
  }

  public String getMediaType(){
    return mediaType;
  }
  public void setMediaType(String mediaType){
    this.mediaType = mediaType;
  }
}
