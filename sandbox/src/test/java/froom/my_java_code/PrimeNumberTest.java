package froom.my_java_code;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeNumberTest {

  @Test
  public void testPrimeNumberFor1() {
    Assert.assertTrue(PrimeNumber.isNumberPrime(53));
  }

  @Test
  public void testPrimeNumberFor2() {
    Assert.assertTrue(PrimeNumber.isNumberPrime(103));
  }

  @Test
  public void testPrimeNumberFor3() {
    Assert.assertFalse(PrimeNumber.isNumberPrime(255));
  }
  @Test
  public void testPrimeNumberWhile1() {
    Assert.assertTrue(PrimeNumber.isNumberPrimeWhile(29));
  }

  @Test
  public void testPrimeNumberWhile2() {
    Assert.assertTrue(PrimeNumber.isNumberPrimeWhile(109));
  }

  @Test
  public void testPrimeNumberWhile3() {
    Assert.assertFalse(PrimeNumber.isNumberPrimeWhile(344));
  }

}
