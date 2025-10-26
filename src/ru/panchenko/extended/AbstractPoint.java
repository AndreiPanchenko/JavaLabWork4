package ru.panchenko.extended;

// Абстрактный класс точки как базовый для различных типов точек

public abstract class AbstractPoint {
  protected double x;
  protected double y;

  // Конструктор

  public AbstractPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // Абстрактный метод

  public abstract String toString();

  // Геттеры
  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  // Сеттеры
  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }
}