package bugs;

import java.util.Comparator;
import java.util.Objects;

public class Bug implements ConsoleNotification, Comparable<Bug> {

  private String description;
  private BugReporter bugReporter;
  private int priority;
  private String status;

  public Bug(String description, BugReporter bugReporter, int priority) {
    this.description = description;
    this.bugReporter = bugReporter;
    this.priority = priority;
    this.status = status();
  }


  public String status() {
    String status = "otwarty";
    return status;
  }

  public BugReporter getBugReporter() {
    return bugReporter;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    if (description.length() >= 10) {
      this.description = description;
    } else {
      System.out.println("Opis nie może być krótszy niż 10 znaków!");
    }
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    /*
    if (priority > 0 && priority <= 5) {
      this.priority = priority;
    } else {
      System.out.println("Niewłaściwe bug priority!");
    }
    */
    switch (priority) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        this.priority = priority;
        break;
      default: {
        System.out.println("Niewłaściwie podane bug priority!");
      }
    }
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
    notifyStatusChange();
  }

  @Override
  public String toString() {
    return "Bug{" +
            "description='" + description + '\'' +
            ", bugReporter=" + bugReporter +
            ", priority=" + priority +
            ", status='" + status + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bug bug = (Bug) o;
    return priority == bug.priority && Objects.equals(description, bug.description) && Objects.equals(bugReporter, bug.bugReporter) && Objects.equals(status, bug.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, bugReporter, priority, status);
  }

  @Override
  public void notifyStatusChange() {
    System.out.println("Notyfikacja: Zmiana statusu!");
  }

  @Override
  public int compareTo(Bug bug) {
    int resultOfCompare = this.description.compareTo(bug.description);
    return resultOfCompare;
  }
}
