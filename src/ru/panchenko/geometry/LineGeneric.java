package ru.panchenko.geometry;

// ЗАДАНИЕ 1.5 - Обобщенная линия
public class LineGeneric<T extends Point> {
  private T start;
  private T end;

  // Создает линию с указанными точками начала и конца

  public LineGeneric(T start, T end) {
    if (start == null || end == null) {
      throw new IllegalArgumentException("Точки начала и конца не могут быть null");
    }
    if (start.equals(end)) {
      throw new IllegalArgumentException("Точки начала и конца не могут совпадать");
    }
    this.start = start;
    this.end = end;
  }

  // Геттеры
  public T getStart() {
    return start;
  }

  public T getEnd() {
    return end;
  }

  // Сеттеры
  public void setStart(T start) {
    if (start == null) {
      throw new IllegalArgumentException("Точка начала не может быть null");
    }
    this.start = start;
  }

  public void setEnd(T end) {
    if (end == null) {
      throw new IllegalArgumentException("Точка конца не может быть null");
    }
    this.end = end;
  }

  // Вычисляет длину линии с учетом размерности точек
  public double getLength() {
    double dx = end.getX() - start.getX();
    double dy = end.getY() - start.getY();

    // Для трехмерных точек учитываем координату Z
    if (start instanceof Point3D && end instanceof Point3D) {
      Point3D start3D = (Point3D) start;
      Point3D end3D = (Point3D) end;
      double dz = end3D.getZ() - start3D.getZ();
      return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    return Math.sqrt(dx * dx + dy * dy);
  }

  // Сравнение линий по точкам начала и конца
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    LineGeneric<?> line = (LineGeneric<?>) obj;
    return start.equals(line.start) && end.equals(line.end);
  }

  @Override
  public String toString() {
    return "Линия от " + start + " до " + end;
  }
}