package ru.panchenko.geometry;

// Обычный класс линии и

public class Line {
  private Point start;
  private Point end;

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

  public Line(double x1, double y1, double x2, double y2) {
    if (x1 == x2 && y1 == y2) {
      throw new IllegalArgumentException("Точки начала и конца не могут совпадать");
    }
    this.start = new Point(x1, y1);
    this.end = new Point(x2, y2);
  }

  public Point getStart() {
    return new Point(start.getX(), start.getY());
  }

  public Point getEnd() {
    return new Point(end.getX(), end.getY());
  }

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

  public double getLength() {
    double dx = end.getX() - start.getX();
    double dy = end.getY() - start.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Line line = (Line) obj;
    return start.equals(line.start) && end.equals(line.end);
  }

  @Override
  public String toString() {
    return "Линия от " + start + " до " + end;
  }
}