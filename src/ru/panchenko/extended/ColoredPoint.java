package ru.panchenko.extended;

// Точка с цветом

public class ColoredPoint extends AbstractPoint {
  private String color; // Цвет точки

  // Конструктор

  public ColoredPoint(double x, double y, String color) {
    super(x, y); // Вызов конструктора родительского класса
    this.color = color;
  }

  // Геттер для цвета
  public String getColor() {
    return color;
  }

  // Сеттер для цвета
  public void setColor(String color) {
    this.color = color;
  }


  @Override
  public String toString() {
    return "Точка {" + x + ";" + y + "}, цвет: " + color;
  }
}