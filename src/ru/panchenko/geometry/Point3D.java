package ru.panchenko.geometry;

// Класс трехмерной точки

public final class Point3D extends Point {
  private double z;

  // Создает трехмерную точку
  public Point3D(double x, double y, double z) {
    super(x, y);
    if (Double.isNaN(z) || Double.isInfinite(z)) {
      throw new IllegalArgumentException("Координата Z должна быть конечным числом");
    }
    this.z = z;
  }

  public double getZ() { return z; }

  public void setZ(double z) {
    if (Double.isNaN(z) || Double.isInfinite(z)) {
      throw new IllegalArgumentException("Координата Z должна быть конечным числом");
    }
    this.z = z;
  }

  // Переопределение equals с учетом координаты Z

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    if (obj == null || getClass() != obj.getClass()) return false;
    Point3D point3D = (Point3D) obj;
    return Double.compare(point3D.z, z) == 0;
  }

  // Переопределение hashCode с учетом координаты Z

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp = Double.doubleToLongBits(z);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "{" + getX() + ";" + getY() + ";" + z + "}";
  }
}