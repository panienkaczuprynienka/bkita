package users;

public enum Gender {

  FEMALE("kobieta"),
  MALE("mężczyzna"),
  UNKNOWN("nieznany");

  private String name;

  Gender(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
