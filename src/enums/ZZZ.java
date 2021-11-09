package enums;

import java.io.*;

public class ZZZ {

  public static void main(String[] args) {
    System.out.println(WeekDays.PONIEDZIALEK.getName());

    if ("Czwartek".equals(WeekDays.CZWARTEK.getName())) {
      System.out.println("Hurra dziś czwartek");
    } else {
      System.out.println("Dziś jednak nie jest czwartek buu");
    }

    try {
      File file;
      BufferedReader bufferedReader = new BufferedReader(new FileReader("testfile.txt"));
    String line = bufferedReader.readLine();
    while (line!=null){
      System.out.println(line);
      line = bufferedReader.readLine();
    }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
