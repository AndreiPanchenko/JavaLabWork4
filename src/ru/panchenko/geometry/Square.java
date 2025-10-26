package ru.panchenko.geometry;

// Класс квадрата

public class Square {
  private Point topLeft;
  private double side;

  // Конструктор с объектом точки
  public Square(Point topLeft, double side) {
    if (topLeft == null) {
      throw new IllegalArgumentException("Верхняя левая точка не может быть null");
    }
    if (side <= 0) {
      throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
    }
    this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    this.side = side;
  }

  // Конструктор с координатами
  public Square(double x, double y, double side) {
    if (side <= 0) {
      throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
    }
    this.topLeft = new Point(x, y);
    this.side = side;
  }

  //Получение ломаной линии, представляющей квадрат

  public Polyline getPolyline() {
    Point p1 = new Point(topLeft.getX(), topLeft.getY()); // левый верхний
    Point p2 = new Point(topLeft.getX() + side, topLeft.getY()); // правый верхний
    Point p3 = new Point(topLeft.getX() + side, topLeft.getY() + side); // правый нижний
    Point p4 = new Point(topLeft.getX(), topLeft.getY() + side); // левый нижний

    return new Polyline(p1, p2, p3, p4, p1);
  }

  // Геттеры
  public Point getTopLeft() {
    return new Point(topLeft.getX(), topLeft.getY());
  }

  public double getSide() {
    return side;
  }

  // Сеттеры
  public void setTopLeft(Point topLeft) {
    if (topLeft == null) {
      throw new IllegalArgumentException("Верхняя левая точка не может быть null");
    }
    this.topLeft = new Point(topLeft.getX(), topLeft.getY());
  }

  public void setSide(double side) {
    if (side <= 0) {
      throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
    }
    this.side = side;
  }

  @Override
  public String toString() {
    return "Квадрат в точке " + topLeft + " со стороной " + side;
  }
}