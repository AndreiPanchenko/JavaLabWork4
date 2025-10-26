package ru.panchenko.geometry;

// ЗАДАНИЕ 2.1 - Утилиты для работы с линиями
public class LineUtils {

  // Сдвигает начальную точку линии на 10 единиц по оси X

  public static <T extends Point> void shiftLineStartX(LineGeneric<T> line) {
    T start = line.getStart();
    start.setX(start.getX() + 10);
  }

  // Сдвигает начальную точку обычной линии на 10 единиц по оси X

  public static void shiftLineStartX(Line line) {
    Point start = line.getStart();
    Point newStart = new Point(start.getX() + 10, start.getY());
    line.setStart(newStart);
  }
}