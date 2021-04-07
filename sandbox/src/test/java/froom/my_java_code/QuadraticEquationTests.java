package froom.my_java_code;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadraticEquationTests {

  @Test
  public void test0() {
    QuadraticEquation eq1 = new QuadraticEquation(2,4,3);
    Assert.assertEquals(eq1.rootNumber(), 0);
  }

  @Test
  public void test1() {
    QuadraticEquation eq1 = new QuadraticEquation(2,4,2);
    Assert.assertEquals(eq1.rootNumber(), 1);
  }

  @Test
  public void test2() {
    QuadraticEquation eq1 = new QuadraticEquation(2,8,3);
    Assert.assertEquals(eq1.rootNumber(), 2);
  }

  @Test
  public void test3() {
    QuadraticEquation eq1 = new QuadraticEquation(0,8,3);
    Assert.assertEquals(eq1.rootNumber(), 1);
  }

  @Test
  public void test4() {
    QuadraticEquation eq1 = new QuadraticEquation(0,0,3);
    Assert.assertEquals(eq1.rootNumber(), 0);
  }

  @Test
  public void test5() {
    QuadraticEquation eq1 = new QuadraticEquation(0,0,0);
    Assert.assertEquals(eq1.rootNumber(), -1);
  }
}
