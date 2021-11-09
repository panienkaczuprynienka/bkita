package bugs;

import java.util.Objects;

public class BugReporter implements Comparable<BugReporter> {

  private String name;
  private String surname;
  private String email;

  public BugReporter(String name, String surname, String reporterEmail) {
    this.name = name;
    this.surname = surname;
    this.email = reporterEmail;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setEmail(String email) {
    if (email.contains("@")) {
      this.email = email;
    } else {
      System.out.println("Niepoprawny adres email!");
    }
  }

  @Override
  public String toString() {
    return "BugReporter{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BugReporter that = (BugReporter) o;
    return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, email);
  }

  @Override
  public int compareTo(BugReporter bugReporter) {
    int compareResult = this.name.compareTo(bugReporter.name);
    if (compareResult == 0) {
      compareResult = this.surname.compareTo(bugReporter.surname);
    }
    return compareResult;
  }
}
