package ru.panchenko.geometry;

// Класс точки на двумерной плоскости
public class Point {
  private double x;
  private double y;

  // Конструктор точки
  public Point(double x, double y) {

    if (Double.isNaN(x) || Double.isInfinite(x)) {
      throw new IllegalArgumentException("Координата X должна быть конечным числом");
    }
    if (Double.isNaN(y) || Double.isInfinite(y)) {
      throw new IllegalArgumentException("Координата Y должна быть конечным числом");
    }
    this.x = x;
    this.y = y;
  }

  // Геттеры
  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  // Сеттеры
  public void setX(double x) {
    if (Double.isNaN(x) || Double.isInfinite(x)) {
      throw new IllegalArgumentException("Координата X должна быть конечным числом");
    }
    this.x = x;
  }

  public void setY(double y) {
    if (Double.isNaN(y) || Double.isInfinite(y)) {
      throw new IllegalArgumentException("Координата Y должна быть конечным числом");
    }
    this.y = y;
  }

  @Override
  public String toString() {
    return "{" + x + ";" + y + "}";
  }

// Сравнение точек по координатам (чтобы потом в задании 3 использовать)
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (obj == null || getClass() != obj.getClass())
      return false;

    Point point = (Point) obj;

    return Double.compare(point.x, x) == 0 &&
        Double.compare(point.y, y) == 0;
  }
}