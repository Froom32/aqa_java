package froom.my_java_code;

public class PrimeNumber {

  public static boolean isNumberPrime(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isNumberPrimeWhile(int n) {
    int m = (int) Math.sqrt(n);
    int i = 2;
    while (i < m && n % i != 0) {
      i++;
    }
    return i == m;
  }

}
