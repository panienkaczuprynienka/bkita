package computer;

public class PC extends Computer {

  private boolean hasCableIn;

  public PC(String name, String type, Hdd hdd, Ram ram) {
    super(name, type, hdd, ram);
    this.hasCableIn = false;
  }

  @Override
  public void switchOn() {
    if (hasCableIn == true) {
      System.out.println("Włączam PC");
      super.switchOn();
    } else {
      System.out.println("Brak podlaczonego kabla!");
    }
  }

  @Override
  public void volumeUp() {
    volume++;
  }

  @Override
  public void volumeDown() {
    volume--;
  }


  public void putCableIn() {
    hasCableIn = true;
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
}
