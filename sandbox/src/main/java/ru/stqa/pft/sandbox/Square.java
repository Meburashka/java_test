package ru.stqa.pft.sandbox;

/**
 * Created by SorEA on 30.07.2016.
 */
public class Square {
  public double l;

  public Square (double l) {
    this.l = l;
  }

  public double area() {
    return this.l * this.l;
  }
}
