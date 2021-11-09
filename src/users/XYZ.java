package users;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XYZ {
  public static void main(String[] args) {

    List<User> users = new ArrayList<>();
    users.add(new User("Ola", "Zych", "ola.zych@wp.pl", 10, Gender.FEMALE));
    users.add(new User("Jan", "Żbik", "jan.zbik@gmail.com", 19, Gender.MALE));
    users.add(new User("Oktawia", "Brzuszek", "okta@wp.pl", 17, Gender.FEMALE));
    users.add(new User("Edek", "Kredowski", "kredowski@wp.pl", 45, Gender.MALE));
    users.add(new User("Misza", "Ladak", "miszka@wp.pl", 33, Gender.MALE));
    users.add(new User("Tajemnicza", "Norka", "999@wp.pl", 99, Gender.UNKNOWN));

    List<User> females = users.stream().filter(u -> u.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
    System.out.println("Kobiety to " + females);

    List<User> kobieta = users.stream().filter(u -> u.getGender().getName().equals("kobieta")).collect(Collectors.toList());
    System.out.println("Kobiety innym sposobem to to " + kobieta);


    System.out.println("Names red from file are: " + readNames());
  }


  public static List<String> readNames() {
    List<String> names = new ArrayList<>();
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("names.txt"));
      String line = bufferedReader.readLine();
      while (!line.isEmpty()) {
        names.add(line);
        line = bufferedReader.readLine();
      }
      names.stream()
              .filter(n -> n.endsWith("x"))
              .findFirst().orElseThrow(() -> new IllegalStateException("Powinny zostać wczytane imiona"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      names.stream()
              .filter(n -> n.endsWith("a"))
              .findFirst().orElseThrow(() -> new IllegalStateException("Powinny zostać wczytane imiona"));
      return names;
    }
  }

}
