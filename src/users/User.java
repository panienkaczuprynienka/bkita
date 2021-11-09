package users;

import java.util.Objects;

public class User {
  private String firstName;
  private String lastName;
  private String email;
  private int age;
  private boolean isAdult;
  private Gender gender;

  public User(String firstName, String lastName, String email, int age, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.isAdult = isUserAdult();
    this.gender=gender;
  }


  private boolean isUserAdult() {
    return age>= 18 ? true : false;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isAdult() {
    return isAdult;
  }

  public void setAdult(boolean adult) {
    isAdult = adult;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "User{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", age=" + age +
            ", isAdult=" + isAdult +
            ", gender=" + gender +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return age == user.age && isAdult == user.isAdult && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && gender == user.gender;
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, age, isAdult, gender);
  }
}
