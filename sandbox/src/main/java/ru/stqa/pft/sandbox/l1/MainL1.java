package ru.stqa.pft.sandbox.l1;

/**
 * Created by SorEA on 30.07.2016.
 */
public class MainL1 {
  public static void main(String[] args) {
  Point p1 = new Point(2, 5);
  Point p2 = new Point(4, 7);

    System.out.println("Расстояние между двумя точками " + distance(p1, p2) + " (использование конструтора в классе Point и метода distance)");

  Point p3 = new Point(2, 5, 4, 7);

    System.out.println("Расстояние между двумя точками " + p3.distance() + " (использование метода distance из класса Point и конструктора с 4 параметрами)");
  }

  public static double distance (Point p1, Point p2) {
    return Math.sqrt((p1.b - p1.a) * (p1.b - p1.a) + (p2.b - p2.a) * (p2.b - p2.a));
  }
}