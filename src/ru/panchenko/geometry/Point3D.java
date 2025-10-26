package ru.panchenko.geometry;

// Трехмерная точка
public final class Point3D extends Point {
  private double z; // Координата Z точки

  // Конструктор трехмерной точки
  public Point3D(double x, double y, double z) {
    super(x, y);
    if (Double.isNaN(z) || Double.isInfinite(z)) {
      throw new IllegalArgumentException("Координата Z должна быть конечным числом");
    }
    this.z = z;
  }

  // Геттер для координаты Z
  public double getZ() {
    return z;
  }

  // Сеттер для координаты Z с проверкой
  public void setZ(double z) {
    if (Double.isNaN(z) || Double.isInfinite(z)) {
      throw new IllegalArgumentException("Координата Z должна быть конечным числом");
    }
    this.z = z;
  }

  @Override
  public String toString() {
    return "{" + getX() + ";" + getY() + ";" + z + "}";
  }

  // Сравнение трехмерных точек
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false; // Сначала проверяем родительский equals
    if (obj == null || getClass() != obj.getClass()) return false;
    Point3D point3D = (Point3D) obj;
    return Double.compare(point3D.z, z) == 0;
  }
}