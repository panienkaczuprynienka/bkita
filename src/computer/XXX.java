package computer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class XXX {

  public static void main(String args[]) throws Exception {


    Computer lapek = new Laptop("Dell", "PRO 2", new Hdd("Dell", 512), new Ram("Dell", 128), 80);
    Computer mojplc = new PC("Asus", "Basic", new Hdd("Asus", 512), new Ram("Dell", 256));
    //  (Laptop) lapek.switchOn();
    ((PC) mojplc).putCableIn();
    mojplc.switchOn();

    Computer[] computers = {lapek, mojplc};

    for (Computer computer : computers) {
      computer.switchOn();
    }
    ((Laptop) lapek).volumeUp(80);
    ((Laptop) lapek).volumeUp(30);
    System.out.println("Volume dla lapka to " + lapek.getVolume());

    ((PC) mojplc).volumeUp(10);
    ((PC) mojplc).volumeDown(20);
    System.out.println("Volume dla pc to " + mojplc.getVolume());

    ((Laptop) lapek).pauseMusic();

    System.out.println("____________________________________________________________-");

    List<Computer> computerList = new ArrayList<>();
    computerList.add(new Laptop("Dell", "PRO 2", new Hdd("Dell", 512), new Ram("Dell", 512), 80));
    computerList.add(new Laptop("Asus", "Basic", new Hdd("Asus", 128), new Ram("Asus", 128), 70));
    computerList.add(new Laptop("Mac", "PRO 1", new Hdd("Dell", 1028), new Ram("Dell", 128), 10));
    computerList.add(new PC("Lenovo", "Basic", new Hdd("Lenovo", 512), new Ram("Lenovo", 256)));
    computerList.add(new PC("Mac", "Regular", new Hdd("Mac", 256), new Ram("Mac", 256)));
    computerList.add(new PC("Acer", "PRO", new Hdd("Mac", 1028), new Ram("Mac", 512)));

    // wszytskie komputery co maja wiecej niz 128 gb ramu zliczyc
    long count = computerList.stream().filter(r -> r.getRam().getSize() > 128).count();
    System.out.println("Wiecej niż 128 bg ramu ma komputerów :" + count);

    // wyswietl wszytskie typy komputerów
    List<String> collect = computerList.stream().map(Computer::getType).collect(Collectors.toList());
    System.out.println("Wszytskie typy komputerów to " + collect);

    //wyswietlic komputer ktory ma najwiecej ramu

    Optional<Computer> max = computerList.stream().max(Comparator.comparingInt(r -> r.getRam().getSize()));
    if (max.isPresent()) {
      System.out.println("Komputer co ma najwiecej ramu to " + max.get());
    }

    // utworzyc now akolekcje z komputerami ktore maja dysk twardy mniejszy niz 500 gb

    List<Computer> collect1 = computerList.stream().filter(d -> d.getHdd().getSize() < 500).collect(Collectors.toList());
    System.out.println("Komputery z dyskiem wiekszym niz 500gb jest " + collect1.size() + "  i są to " + collect1);

    List<Computer> sorted = computerList.stream()
            .sorted(Comparator.comparing(Computer::getName).thenComparing(Computer::getType))
            .collect(Collectors.toList());

    for (Computer comp: sorted) {
      System.out.println(comp.getName() + "   " + comp.getType());
    }

// przecwiczenie reszty

    // find first or else
    Integer integer = computerList.stream()
            .map(c -> c.getRam().getSize())
            .filter(c -> c > 1000)
            .findFirst()
            .orElse(-1);

// or else get i or else throw

    computerList.stream()
            .filter(c -> c.getRam().getSize() > 100)
            .findFirst().orElseGet(()->new PC("Acer", "PRO", new Hdd("Mac", 1028), new Ram("Mac", 512)));


    Computer nie_ma_takiego = computerList.stream()
            .filter(c -> c.getRam().getSize() > 100)
            .findFirst().orElseThrow(()->new Exception("Nie ma takiego"));

    // if present

    System.out.println("find first if present");
    computerList.stream()
            .filter(c -> c.getRam().getSize() > 500)
            .findFirst().ifPresent(c -> System.out.println(c));

    // if present of else
    System.out.println("find first if present or else");
    computerList.stream()
            .filter(c -> c.getRam().getSize() > 1000)
            .findFirst().ifPresentOrElse(c-> System.out.println(c), ()-> System.out.println("nie ma"));

  }
}
