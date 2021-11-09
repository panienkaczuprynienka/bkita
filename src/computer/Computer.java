package computer;

abstract public class Computer {

  protected String name;
  protected String type;
  protected Hdd hdd;
  protected Ram ram;
  protected boolean status;
  protected int volume;

  public Computer(String name, String type, Hdd hdd, Ram ram) {
    this.name = name;
    this.type = type;
    this.hdd = hdd;
    this.ram = ram;
    this.status = false;
    volume=0;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Hdd getHdd() {
    return hdd;
  }

  public void setHdd(Hdd hdd) {
    this.hdd = hdd;
  }

  public Ram getRam() {
    return ram;
  }

  public void setRam(Ram ram) {
    this.ram = ram;
  }

  public int getVolume() {
    return volume;
  }

  public void switchOn() {
    status = true;
  }

  public void switchOff() {
    status = false;
  }

  public abstract void volumeUp();

  public abstract void volumeDown();

  public abstract void volumeUp(int value);

  public abstract void volumeDown(int value);


  @Override
  public String toString() {
    return "Computer{" +
            "name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", hdd=" + hdd +
            ", ram=" + ram +
            ", status=" + status +
            ", volume=" + volume +
            '}';
  }
}
