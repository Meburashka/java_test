package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.l1.Point;

import static ru.stqa.pft.sandbox.l1.MainL1.distance;

/**
 * Created by SorEA on 03.08.2016.
 */
public class PointMethodTests {

  @Test
  public void testDesigner() {
    Point p = new Point(3, 4, 5, 7.2);

    Assert.assertEquals(p.distance(), 2.4166091947189146);
  }
}
