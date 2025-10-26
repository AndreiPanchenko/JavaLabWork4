package ru.panchenko.extended;

// Точка с временем появления

public class TimedPoint extends AbstractPoint {
  private String time; // Время появления точки

  // Конструктор
  public TimedPoint(double x, double y, String time) {
    super(x, y); // Вызов конструктора родительского класса
    this.time = time;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "Точка {" + x + ";" + y + "}, время: " + time;
  }
}