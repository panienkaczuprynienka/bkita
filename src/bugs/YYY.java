package bugs;

import java.util.*;
import java.util.stream.Collectors;

public class YYY {

  public static void main(String args[]) throws Exception {

    BugReporter bugReporter1 = new BugReporter("Iza", "Rak", "iza.rak@wp.pl");
    BugReporter bugReporter2 = new BugReporter("Ela", "Złota", "ela.złota@wp.pl");
    BugReporter bugReporter3 = new BugReporter("Ela", "Aleńska", "ela.alenska@wp.pl");
    BugReporter bugReporter4 = new BugReporter("Zofia", "Branczyk", "zofia.branczyk@wp.pl");

    List<BugReporter> bugReporters = new ArrayList<>();
    bugReporters.add(bugReporter1);
    bugReporters.add(bugReporter2);
    bugReporters.add(bugReporter3);
    bugReporters.add(bugReporter4);

    Set<BugReporter> bugReporterSet = new TreeSet<>(bugReporters);

    System.out.println("______DRUKUJE_______");

    for (BugReporter bugReporter : bugReporterSet) {
      System.out.println(bugReporter.getName() + " " + bugReporter.getSurname());

    }


    Bug bug = new Bug("Zepsuty input", bugReporter2, 2);
    Bug bug2 = new Bug("Exception", bugReporter3, 1);
    Bug bug3 = new Bug("Nie działa internet", bugReporter4, 2);
    Bug bug4 = new Bug("Nievalidny input", bugReporter4, 2);
    Bug bug5 = new Bug("500tka", bugReporter4, 5);


    List<Bug> bugs = new ArrayList<>();
    bugs.add(bug);
    bugs.add(bug2);
    bugs.add(bug3);
    bugs.add(bug4);
    bugs.add(bug5);

    System.out.println("_______________STREAMY_________________");

    List<Bug> sortedBugs = bugs.stream()
            .sorted(Comparator.comparing(Bug::getPriority).thenComparing(Bug::getDescription))
            .collect(Collectors.toList());
    System.out.println("Sorted bugs to " + sortedBugs);

    // Integer nie_wiem = bugs.stream().map(Bug::getPriority).max(Integer::compareTo).findFirst();
    List<Bug> elas = bugs.stream().filter(b -> b.getBugReporter().getName().startsWith("Ela")).collect(Collectors.toList());
    Optional<Bug> opt = bugs.stream().filter(b -> b.getBugReporter().getName().equals("Zofia")).findFirst();
    if (opt.isPresent()) {
      System.out.println("Optional to " + opt.get());
    }

    String surnameRak = bugs.stream()
            .map(s -> s.getBugReporter().getSurname())
            .filter(s -> s.contains("Branczyk"))
            .findFirst().orElse("Nie udalo się znależć");
    System.out.println("Surname rak " + surnameRak);

    Bug piecetka = bugs.stream()
            .filter(b -> b.getDescription().contains("500"))
            .findFirst().orElseThrow(() -> new IllegalStateException("Nie m a takiego"));

    System.out.println("Piecetka to " + piecetka);

     bugs.stream()
            .filter(b -> b.getDescription().contains("400"))
            .findFirst().ifPresentOrElse(b->System.out.println(b), ()-> System.out.println("Nie ma takiego"));




    System.out.println("________________KONIEC STREAMOW_____________");


    System.out.println("Lista z bugami to " + bugs);

    Collections.sort(bugs, Comparator.comparingInt(Bug::getPriority).reversed());
    System.out.println(bugs);

    Set<Bug> distinctBugs = new HashSet<>(bugs);
    System.out.println("DISTINKTOWYCH BUGOW JEST " + distinctBugs.size());

    for (Bug distinctBug : distinctBugs) {
      System.out.println(distinctBug);
    }

    Set<Bug> distinctSortedBugs = new TreeSet<>(bugs);

    System.out.println("DISKTINTT SORETD BUGS TO______________");

    for (Bug distinctSortedBug : distinctSortedBugs) {
      System.out.println(distinctSortedBug);
    }

    Map<Integer, String> nicks = new HashMap<>();
    nicks.put(2, "Joey");
    nicks.put(8, "Ana");
    nicks.put(20, "Eva");
    nicks.put(1, "Zoey");

    for (Map.Entry<Integer, String> nickEntry : nicks.entrySet()) {
      System.out.println("Klucz to: " + nickEntry.getKey() + " , a wartość to: " + nickEntry.getValue());
    }
    Map<Integer, String> sortedNicks = new TreeMap<>(nicks);

    System.out.println("______SORTED MAP___________");

    for (Map.Entry<Integer, String> sortedNickEntry : sortedNicks.entrySet()) {
      System.out.println("Klucz to: " + sortedNickEntry.getKey() + " , a wartość to: " + sortedNickEntry.getValue());
    }


    bug.setPriority(5);
  }
}
