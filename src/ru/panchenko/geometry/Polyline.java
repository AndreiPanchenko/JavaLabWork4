package ru.panchenko.geometry;

import java.util.ArrayList;
import java.util.List;

// Класс ломаной линии

public class Polyline {
  private List<Point> points;

  // Конструктор по умолчанию
  public Polyline() {
    this.points = new ArrayList<>();
  }

  // Конструктор с массивом точек

  public Polyline(Point... points) {
    this.points = new ArrayList<>();
    if (points == null) {
      throw new IllegalArgumentException("Массив точек не может быть null");
    }
    for (Point p : points) {
      if (p == null) {
        throw new IllegalArgumentException("Точки в массиве не могут быть null");
      }
      this.points.add(new Point(p.getX(), p.getY()));
    }
  }

  // Добавление новых точек в ломаную

  public void addPoints(Point... newPoints) {
    if (newPoints == null) {
      throw new IllegalArgumentException("Массив новых точек не может быть null");
    }
    for (Point p : newPoints) {
      if (p == null) {
        throw new IllegalArgumentException("Точки в массиве не могут быть null");
      }
      points.add(new Point(p.getX(), p.getY()));
    }
  }

  //Получение копии списка точек ломаной линии
  public List<Point> getPoints() {

    List<Point> copy = new ArrayList<>();

    for (Point p : points) {

      Point pointCopy = new Point(p.getX(), p.getY());

      copy.add(pointCopy);

    }
    // оригинальный список 'points' внутри объекта Polyline
    // возвращенный список 'copy' для внешнего использования
    return copy;

  }

  // Вычисление общей длины ломаной

  public double getLength() {
    if (points.size() < 2) {
      return 0;
    }

    double totalLength = 0;
    for (int i = 0; i < points.size() - 1; i++) {
      // Создаем временную линию между соседними точками
      Line segment = new Line(points.get(i), points.get(i + 1));
      totalLength += segment.getLength();
    }
    return totalLength;
  }

  @Override
  public String toString() {
    return "Ломаная линия " + points;
  }
}