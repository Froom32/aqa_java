package froom.my_java_code;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {

  @Test
  public void testArea() {
    Rectangle ab = new Rectangle(7,4);
    Assert.assertEquals(ab.area(), 28.0);
  }
}
