package ru.panchenko.geometry;

// Базовый класс точки на двумерной плоскости

public class Point {
  private double x;
  private double y;

  // Создает точку с указанными координатами

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
  public double getX() { return x; }
  public double getY() { return y; }

  // Сеттеры с валидацией
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

  // Переопределение equals

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Point point = (Point) obj;
    return Double.compare(point.x, x) == 0 &&
        Double.compare(point.y, y) == 0;
  }

  // Переопределение hashCode (согласовано с equals)

  @Override
  public int hashCode() {
    int result = 17;
    long temp = Double.doubleToLongBits(x);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(y);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "{" + x + ";" + y + "}";
  }
}