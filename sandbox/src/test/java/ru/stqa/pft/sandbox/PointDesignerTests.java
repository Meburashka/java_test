package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.l1.Point;

import static ru.stqa.pft.sandbox.l1.MainL1.distance;

/**
 * Created by SorEA on 03.08.2016.
 */
public class PointDesignerTests {

  @Test
  public void testDesigner() {
    Point p1 = new Point(2, 5);
    Point p2 = new Point(4, 7);

    Assert.assertEquals(distance(p1, p2), 4.242640687119285);
  }
}
