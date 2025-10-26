package ru.panchenko.geometry;

// Класс линии на плоскости
public class Line implements Cloneable {
  private Point start;
  private Point end;

  // Конструктор линии с объектами точек
  public Line(Point start, Point end) {
    if (start == null || end == null) {
      throw new IllegalArgumentException("Точки начала и конца не могут быть null");
    }
    if (start.equals(end)) {
      throw new IllegalArgumentException("Точки начала и конца не могут совпадать");
    }
    this.start = new Point(start.getX(), start.getY());
    this.end = new Point(end.getX(), end.getY());
  }

  // Конструктор линии с координатами
  public Line(double x1, double y1, double x2, double y2) {
    if (x1 == x2 && y1 == y2) {
      throw new IllegalArgumentException("Точки начала и конца не могут совпадать");
    }
    this.start = new Point(x1, y1);
    this.end = new Point(x2, y2);
  }

  // Геттеры возвращают копии точек
  public Point getStart() {
    return new Point(start.getX(), start.getY());
  }

  public Point getEnd() {
    return new Point(end.getX(), end.getY());
  }

  // Сеттеры принимают точки и создают их копии
  public void setStart(Point start) {
    if (start == null) {
      throw new IllegalArgumentException("Точка начала не может быть null");
    }
    this.start = new Point(start.getX(), start.getY());
  }

  public void setEnd(Point end) {
    if (end == null) {
      throw new IllegalArgumentException("Точка конца не может быть null");
    }
    this.end = new Point(end.getX(), end.getY());
  }


  public int getLength() {
    double dx = end.getX() - start.getX();
    double dy = end.getY() - start.getY();
    return (int) Math.sqrt(dx * dx + dy * dy);
  }

  // Сравнение линий по точкам начала и конца (Задание 6)
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Line line = (Line) obj;
    return start.equals(line.start) && end.equals(line.end);
  }

  // Клонирование линии (Задание 8)
  @Override
  public Line clone() {
    try {
      Line cloned = (Line) super.clone();
      cloned.start = new Point(start.getX(), start.getY());
      cloned.end = new Point(end.getX(), end.getY());
      return cloned;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException("Ошибка клонирования линии", e);
    }
  }

  @Override
  public String toString() {
    return "Линия от " + start + " до " + end;
  }
}