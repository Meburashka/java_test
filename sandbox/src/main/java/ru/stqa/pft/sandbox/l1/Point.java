package ru.stqa.pft.sandbox.l1;

/**
 * Created by SorEA on 30.07.2016.
 */
public class Point {
  double a, b, c, d;

  public Point(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public Point(double a, double b, double c, double d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  public double distance () {
    return Math.sqrt((this.b - this.a) * (this.b - this.a) + (this.d - this.c) * (this.d - this.c));
  }
}
