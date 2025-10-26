package ru.panchenko.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

// Класс для возведения в степень
public class PowerCalculator {

  // Метод для возведения X в степень Y из строк
  public static double calculatePower(String xStr, String yStr) {
    try {
      int x = parseInt(xStr); // Преобразование строки в int с
      int y = parseInt(yStr);
      return pow(x, y);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          "Некорректные параметры: '" + xStr + "', '" + yStr + "'", e);
    }
  }
}