package ru.panchenko.main;

import java.util.Scanner;

// Класс для безопасного ввода данных с обработкой ошибок

public class InputChecker {
  private static final Scanner scanner = new Scanner(System.in);

  // Безопасный ввод целых чисел

  public static int getInt() {
    while (true) {
      try {
        return Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите целое число: ");
      }
    }
  }

  // Безопасный ввод чисел с плавающей точкой

  public static double getDouble() {
    while (true) {
      try {
        return Double.parseDouble(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите число: ");
      }
    }
  }

  // Ввод положительного числа

  public static double getPositiveDouble() {
    while (true) {
      try {
        double value = Double.parseDouble(scanner.nextLine().trim());
        if (value <= 0) {
          System.out.print("Ошибка! Введите положительное число: ");
          continue;
        }
        return value;
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите число: ");
      }
    }
  }

  // Ввод числа в заданном диапазоне

  public static int getIntInRange(int min, int max) {
    while (true) {
      try {
        int value = Integer.parseInt(scanner.nextLine().trim());
        if (value < min || value > max) {
          System.out.print("Ошибка! Введите число от " + min + " до " + max + ": ");
          continue;
        }
        return value;
      } catch (NumberFormatException e) {
        System.out.print("Ошибка! Введите целое число: ");
      }
    }
  }

  // Ввод строки

  public static String getString() {
    return scanner.nextLine().trim();
  }

  // Ввод непустой строки

  public static String getNonEmptyString() {
    while (true) {
      String input = scanner.nextLine().trim();
      if (input.isEmpty()) {
        System.out.print("Ошибка! Введите непустую строку: ");
        continue;
      }
      return input;
    }
  }

  // Методы с пользовательскими сообщениями

  public static int getInt(String prompt) {
    System.out.print(prompt);
    return getInt();
  }

  public static double getDouble(String prompt) {
    System.out.print(prompt);
    return getDouble();
  }

  public static double getPositiveDouble(String prompt) {
    System.out.print(prompt);
    return getPositiveDouble();
  }

  public static int getIntInRange(String prompt, int min, int max) {
    System.out.print(prompt);
    return getIntInRange(min, max);
  }

  public static String getString(String prompt) {
    System.out.print(prompt);
    return getString();
  }

  public static String getNonEmptyString(String prompt) {
    System.out.print(prompt);
    return getNonEmptyString();
  }
}