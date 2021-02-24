package froom.my_java_code;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point a = new Point(2,14);
    Point b = new Point(2,-4);
    Assert.assertEquals(a.distance(b), 18);
  }

  @Test
  public void testDistance2() {
    Point a = new Point(54,64);
    Point b = new Point(10,64);
    Assert.assertEquals(a.distance(b), 44);
  }
}
