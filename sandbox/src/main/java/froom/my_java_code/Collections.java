package froom.my_java_code;

import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {

    List<String> languages = Arrays.asList("Java", "C#", "Python", "JS");

    for (String l : languages) {
      System.out.println(l);
    }
  }
}
