package ru.panchenko.main;

// Класс для полиморфного суммирования чисел разных типов

public class SumCalculator {

  // Метод принимает любые числовые типы и возвращает их сумму

  public static double sum(Number... numbers) {
    double result = 0.0;
    for (Number num : numbers) {
      result += num.doubleValue();
    }
    return result;
  }
}