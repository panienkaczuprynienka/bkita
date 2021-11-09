package computer;

public class Laptop extends Computer  implements Music, Video {

  private int batteryLevel;

  public Laptop(String name, String type, Hdd hdd, Ram ram, int batteryLevel) {
    super(name, type, hdd, ram);
    this.batteryLevel = batteryLevel;
  }

  @Override
  public void switchOn() {
    if (batteryLevel > 0) {
      super.switchOn();
      System.out.println("Włączam Laptopa");
    } else {
      System.out.println("Za niski poziom naładowania by włączyć!");
    }
  }

  @Override
  public void volumeUp() {
    volume = volume + 5;
  }

  @Override
  public void volumeDown() {
    volume = volume - 2;
  }

  @Override
  public void volumeUp(int value) {
    volume = volume + value;
    if (volume > 100) {
      volume = 100;
    }
  }

  @Override
  public void volumeDown(int value) {
    volume = volume - value;
    if (volume < 0) {
      volume = 0;
    }
  }

  @Override
  public void playMusic() {
    System.out.println("Play music");
  }

  @Override
  public void pauseMusic() {
    System.out.println("Pause music");
  }

  @Override
  public void stopMusic() {
    System.out.println("Stop music");
  }

  @Override
  public void playVideo() {
    System.out.println("Play video");
  }

  @Override
  public void pauseVideo() {
    System.out.println("Pause video");
  }

  @Override
  public void stopVideo() {
    System.out.println("Stop video");
  }
}
