package ru.panchenko.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ru.panchenko.collections.Storage;
import ru.panchenko.functional.GenericMethods;
import ru.panchenko.geometry.Line;
import ru.panchenko.geometry.LineGeneric;
import ru.panchenko.geometry.LineUtils;
import ru.panchenko.geometry.Point;
import ru.panchenko.geometry.Point3D;

public class Main {

  public static void main(String[] args) {
    new Main().runInteractiveMenu();
  }

  private static void runInteractiveMenu() {
    while (true) {
      printMenu();
      int choice = InputChecker.getInt("Выберите задание: ");

      switch (choice) {
        case 1:
          demonstrateStorage();
          break;
        case 2:
          demonstrateGenericLine();
          break;
        case 3:
          demonstrateLineShift();
          break;
        case 4:
          demonstrateMap();
          break;
        case 5:
          demonstrateFilter();
          break;
        case 6:
          demonstrateReduce();
          break;
        case 7:
          demonstrateCollect();
          break;
        case 0:
          System.out.println("Выход из программы. До свидания!");
          return;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
          break;
      }
      System.out.println();
    }
  }

  private static void printMenu() {
    System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА №4 ===");
    System.out.println("1. Хранилище (Задание 1.2)");
    System.out.println("2. Обобщенная линия (Задание 1.5)");
    System.out.println("3. Сдвиг линии (Задание 2.1)");
    System.out.println("4. Map - Функция (Задание 3.1)");
    System.out.println("5. Filter - Фильтр (Задание 3.2)");
    System.out.println("6. Reduce - Сокращение (Задание 3.3)");
    System.out.println("7. Collect - Коллекционирование (Задание 3.4)");
    System.out.println("0. Выход");
  }

  // ЗАДАНИЕ 1.2 - Хранилище
  private static void demonstrateStorage() {
    System.out.println("--- Демонстрация хранилища (Задание 1.2) ---");

    // Демонстрация согласно требованиям задания
    System.out.println("=== Примеры из задания ===");

    System.out.println("1. Хранилище чисел с null (альтернатива 0):");
    Storage<Integer> numStorage1 = new Storage<>(null);
    Storage.printNumberStorage(numStorage1);

    System.out.println("2. Хранилище чисел со значением 99 (альтернатива -1):");
    Storage<Integer> numStorage2 = new Storage<>(99);
    Storage.printNumberStorageAlt(numStorage2);

    System.out.println("3. Хранилище строк с null (альтернатива 'default'):");
    Storage<String> strStorage1 = new Storage<>(null);
    Storage.printStringStorage(strStorage1);

    System.out.println("4. Хранилище строк со значением 'hello' (альтернатива 'hello world'):");
    Storage<String> strStorage2 = new Storage<>("hello");
    Storage.printStringStorageAlt(strStorage2);

    // Интерактивная часть с выводом введенных данных
    System.out.println("\n=== Интерактивная часть ===");
    System.out.println("Создайте свое хранилище:");

    System.out.println("Выберите тип хранилища:");
    System.out.println("1 - Числовое хранилище");
    System.out.println("2 - Строковое хранилище");
    int typeChoice = InputChecker.getIntInRange("Ваш выбор: ", 1, 2);

    if (typeChoice == 1) {
      System.out.println("Введите значение (или оставьте пустым для null):");
      String input = InputChecker.getString();
      Integer value = input.isEmpty() ? null : Integer.parseInt(input);

      // ВЫВОД ВВЕДЕННЫХ ДАННЫХ
      System.out.println(">>> Вы ввели: '" + input + "'");
      System.out.println(">>> Созданное хранилище: " + new Storage<>(value));

      Storage<Integer> userStorage = new Storage<>(value);

      System.out.println("Выберите альтернативное значение:");
      System.out.println("1 - 0");
      System.out.println("2 - -1");
      int altChoice = InputChecker.getIntInRange("Ваш выбор: ", 1, 2);

      // ВЫВОД ВЫБРАННОЙ АЛЬТЕРНАТИВЫ
      System.out.println(">>> Выбрана альтернатива: " + (altChoice == 1 ? "0" : "-1"));

      if (altChoice == 1) {
        Storage.printNumberStorage(userStorage);
      } else {
        Storage.printNumberStorageAlt(userStorage);
      }
    } else {
      System.out.println("Введите значение (или оставьте пустым для null):");
      String input = InputChecker.getString();
      String value = input.isEmpty() ? null : input;

      // ВЫВОД ВВЕДЕННЫХ ДАННЫХ
      System.out.println(">>> Вы ввели: '" + input + "'");
      System.out.println(">>> Созданное хранилище: " + new Storage<>(value));

      Storage<String> userStorage = new Storage<>(value);

      System.out.println("Выберите альтернативное значение:");
      System.out.println("1 - 'default'");
      System.out.println("2 - 'hello world'");
      int altChoice = InputChecker.getIntInRange("Ваш выбор: ", 1, 2);

      // ВЫВОД ВЫБРАННОЙ АЛЬТЕРНАТИВЫ
      System.out.println(
          ">>> Выбрана альтернатива: '" + (altChoice == 1 ? "default" : "hello world") + "'");

      if (altChoice == 1) {
        Storage.printStringStorage(userStorage);
      } else {
        Storage.printStringStorageAlt(userStorage);
      }
    }
  }

  // ЗАДАНИЕ 1.5 - Обобщенная линия
  private static void demonstrateGenericLine() {
    System.out.println("--- Демонстрация обобщенной линии (Задание 1.5) ---");

    try {
      // Демонстрация 2D линии
      System.out.println("=== 2D Линия ===");
      Point point2D1 = new Point(1, 2);
      Point point2D2 = new Point(4, 6);
      LineGeneric<Point> line2D = new LineGeneric<>(point2D1, point2D2);
      System.out.println("2D Линия: " + line2D);
      System.out.println("Длина 2D линии: " + line2D.getLength());

      // Демонстрация 3D линии (требование задания)
      System.out.println("=== 3D Линия ===");
      Point3D point3D1 = new Point3D(1, 2, 3);
      Point3D point3D2 = new Point3D(4, 6, 9);
      LineGeneric<Point3D> line3D = new LineGeneric<>(point3D1, point3D2);
      System.out.println("3D Линия: " + line3D);
      System.out.println("Длина 3D линии: " + line3D.getLength());

      // Интерактивная часть
      System.out.println("=== Интерактивная часть ===");
      System.out.println("Создайте свою линию:");

      System.out.println("Выберите тип линии:");
      System.out.println("1 - 2D линия");
      System.out.println("2 - 3D линия");
      int typeChoice = InputChecker.getIntInRange("Ваш выбор: ", 1, 2);

      if (typeChoice == 1) {
        System.out.println("Введите координаты начала (x y):");
        double x1 = InputChecker.getDouble("x1: ");
        double y1 = InputChecker.getDouble("y1: ");
        System.out.println("Введите координаты конца (x y):");
        double x2 = InputChecker.getDouble("x2: ");
        double y2 = InputChecker.getDouble("y2: ");

        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        LineGeneric<Point> userLine = new LineGeneric<>(start, end);

        System.out.println("Создана 2D линия: " + userLine);
        System.out.println("Длина линии: " + userLine.getLength());
      } else {
        System.out.println("Введите координаты начала (x y z):");
        double x1 = InputChecker.getDouble("x1: ");
        double y1 = InputChecker.getDouble("y1: ");
        double z1 = InputChecker.getDouble("z1: ");
        System.out.println("Введите координаты конца (x y z):");
        double x2 = InputChecker.getDouble("x2: ");
        double y2 = InputChecker.getDouble("y2: ");
        double z2 = InputChecker.getDouble("z2: ");

        Point3D start = new Point3D(x1, y1, z1);
        Point3D end = new Point3D(x2, y2, z2);
        LineGeneric<Point3D> userLine = new LineGeneric<>(start, end);

        System.out.println("Создана 3D линия: " + userLine);
        System.out.println("Длина линии: " + userLine.getLength());
      }

    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка создания линии: " + e.getMessage());
    }
  }

  // ЗАДАНИЕ 2.1 - Сдвиг линии
  private static void demonstrateLineShift() {
    System.out.println("--- Демонстрация сдвига линии (Задание 2.1) ---");

    try {
      // Демонстрация с обычной линией
      System.out.println("=== Сдвиг обычной линии ===");
      Point start = new Point(5, 2);
      Point end = new Point(10, 8);
      Line line = new Line(start, end);

      System.out.println("Исходная линия: " + line);
      System.out.println("Начальная точка до сдвига: " + line.getStart());

      LineUtils.shiftLineStartX(line);

      System.out.println("Линия после сдвига: " + line);
      System.out.println("Начальная точка после сдвига: " + line.getStart());

      // Демонстрация с обобщенной линией
      System.out.println("=== Сдвиг обобщенной 3D линии ===");
      Point3D start3D = new Point3D(5, 2, 1);
      Point3D end3D = new Point3D(10, 8, 3);
      LineGeneric<Point3D> line3D = new LineGeneric<>(start3D, end3D);

      System.out.println("3D Линия до сдвига: " + line3D);
      LineUtils.shiftLineStartX(line3D);
      System.out.println("3D Линия после сдвига: " + line3D);

      // Демонстрация с обобщенной 2D линией
      System.out.println("=== Сдвиг обобщенной 2D линии ===");
      Point start2D = new Point(5, 2);
      Point end2D = new Point(10, 8);
      LineGeneric<Point> line2D = new LineGeneric<>(start2D, end2D);

      System.out.println("2D Линия до сдвига: " + line2D);
      System.out.println("Начальная точка до сдвига: " + line2D.getStart());
      System.out.println("Координата X до сдвига: " + line2D.getStart().getX());

      // ВЫПОЛНЯЕМ СДВИГ
      LineUtils.shiftLineStartX(line2D);

      System.out.println("2D Линия после сдвига: " + line2D);
      System.out.println("Начальная точка после сдвига: " + line2D.getStart());
      System.out.println("Координата X после сдвига: " + line2D.getStart().getX());
      System.out.println("Изменение координаты X: " + (line2D.getStart().getX() - 5));

      // Интерактивная часть с выбором типа линии
      System.out.println("=== Интерактивная часть ===");
      System.out.println("Создайте линию для сдвига:");

      System.out.println("Выберите тип линии:");
      System.out.println("1 - Обычная 2D линия");
      System.out.println("2 - Обобщённая 2D линия");
      System.out.println("3 - Обобщённая 3D линия");
      int typeChoice = InputChecker.getIntInRange("Ваш выбор: ", 1, 3);

      switch (typeChoice) {
        case 1:
          interactiveShiftRegular2D();
          break;
        case 2:
          interactiveShiftGeneric2D();
          break;
        case 3:
          interactiveShiftGeneric3D();
          break;
      }

    } catch (Exception e) {
      System.out.println("Ошибка при сдвиге линии: " + e.getMessage());
    }
  }

  // Метод для интерактивного сдвига обычной 2D линии
  private static void interactiveShiftRegular2D() {
    System.out.println("=== Создание обычной 2D линии ===");

    System.out.println("Введите координаты начала (x y):");
    double x1 = InputChecker.getDouble("x1: ");
    double y1 = InputChecker.getDouble("y1: ");
    System.out.println("Введите координаты конца (x y):");
    double x2 = InputChecker.getDouble("x2: ");
    double y2 = InputChecker.getDouble("y2: ");

    Point userStart = new Point(x1, y1);
    Point userEnd = new Point(x2, y2);
    Line userLine = new Line(userStart, userEnd);

    System.out.println(">>> Создана обычная 2D линия: " + userLine);
    System.out.println(">>> Начальная точка до сдвига: " + userLine.getStart());
    System.out.println(">>> Координата X до сдвига: " + userLine.getStart().getX());

    // ВЫПОЛНЯЕМ СДВИГ
    LineUtils.shiftLineStartX(userLine);

    System.out.println(">>> Линия после сдвига: " + userLine);
    System.out.println(">>> Начальная точка после сдвига: " + userLine.getStart());
    System.out.println(">>> Координата X после сдвига: " + userLine.getStart().getX());
    System.out.println(">>> Изменение координаты X: " + (userLine.getStart().getX() - x1));
  }

  // Метод для интерактивного сдвига обобщённой 2D линии
  private static void interactiveShiftGeneric2D() {
    System.out.println("=== Создание обобщённой 2D линии ===");

    System.out.println("Введите координаты начала (x y):");
    double x1 = InputChecker.getDouble("x1: ");
    double y1 = InputChecker.getDouble("y1: ");
    System.out.println("Введите координаты конца (x y):");
    double x2 = InputChecker.getDouble("x2: ");
    double y2 = InputChecker.getDouble("y2: ");

    Point userStart = new Point(x1, y1);
    Point userEnd = new Point(x2, y2);
    LineGeneric<Point> userLine = new LineGeneric<>(userStart, userEnd);

    System.out.println(">>> Создана обобщённая 2D линия: " + userLine);
    System.out.println(">>> Начальная точка до сдвига: " + userLine.getStart());
    System.out.println(">>> Координата X до сдвига: " + userLine.getStart().getX());
    System.out.println(">>> Тип точки: " + userLine.getStart().getClass().getSimpleName());

    // ВЫПОЛНЯЕМ СДВИГ
    LineUtils.shiftLineStartX(userLine);

    System.out.println(">>> Линия после сдвига: " + userLine);
    System.out.println(">>> Начальная точка после сдвига: " + userLine.getStart());
    System.out.println(">>> Координата X после сдвига: " + userLine.getStart().getX());
    System.out.println(">>> Изменение координаты X: " + (userLine.getStart().getX() - x1));
  }

  // Метод для интерактивного сдвига обобщённой 3D линии
  private static void interactiveShiftGeneric3D() {
    System.out.println("=== Создание обобщённой 3D линии ===");

    System.out.println("Введите координаты начала (x y z):");
    double x1 = InputChecker.getDouble("x1: ");
    double y1 = InputChecker.getDouble("y1: ");
    double z1 = InputChecker.getDouble("z1: ");
    System.out.println("Введите координаты конца (x y z):");
    double x2 = InputChecker.getDouble("x2: ");
    double y2 = InputChecker.getDouble("y2: ");
    double z2 = InputChecker.getDouble("z2: ");

    Point3D userStart = new Point3D(x1, y1, z1);
    Point3D userEnd = new Point3D(x2, y2, z2);
    LineGeneric<Point3D> userLine = new LineGeneric<>(userStart, userEnd);

    System.out.println(">>> Создана обобщённая 3D линия: " + userLine);
    System.out.println(">>> Начальная точка до сдвига: " + userLine.getStart());
    System.out.println(">>> Координата X до сдвига: " + userLine.getStart().getX());
    System.out.println(">>> Координата Z до сдвига: " + userLine.getStart().getZ());
    System.out.println(">>> Тип точки: " + userLine.getStart().getClass().getSimpleName());

    // ВЫПОЛНЯЕМ СДВИГ
    LineUtils.shiftLineStartX(userLine);

    System.out.println(">>> Линия после сдвига: " + userLine);
    System.out.println(">>> Начальная точка после сдвига: " + userLine.getStart());
    System.out.println(">>> Координата X после сдвига: " + userLine.getStart().getX());
    System.out.println(">>> Координата Z после сдвига: " + userLine.getStart().getZ());
    System.out.println(">>> Изменение координаты X: " + (userLine.getStart().getX() - x1));
    System.out.println(">>> Координата Y и Z не изменились: Y=" + userLine.getStart().getY() + ", Z=" + userLine.getStart().getZ());
  }

  // ЗАДАНИЕ 3.1 - Map
  private static void demonstrateMap() {
    System.out.println("--- Демонстрация Map (Задание 3.1) ---");

    // Демонстрация трех примеров из задания
    System.out.println("=== Примеры из задания ===");

    // Пример 1: Строки в длины строк
    System.out.println("1. Строки -> Длины строк:");
    List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
    List<Integer> lengths = GenericMethods.map(strings, s -> s.length());
    System.out.println("   Входные данные: " + strings);
    System.out.println("   Результат: " + lengths);
    System.out.println("   Преобразование: String -> Integer");

    // Пример 2: Числа в абсолютные значения
    System.out.println("2. Числа -> Абсолютные значения:");
    List<Integer> numbers = Arrays.asList(1, -3, 7);
    List<Integer> absoluteValues = GenericMethods.map(numbers, n -> Math.abs(n));
    System.out.println("   Входные данные: " + numbers);
    System.out.println("   Результат: " + absoluteValues);
    System.out.println("   Преобразование: Integer -> Integer");

    // Пример 3: Массивы в максимальные значения
    System.out.println("3. Массивы -> Максимумы массивов:");
    List<int[]> arrays = Arrays.asList(
        new int[]{1, 5, 3},
        new int[]{-2, 8, 0},
        new int[]{4, 4, 9, 2}
    );
    // Выводим массивы в читаемом формате
    List<String> arrayStrings = new ArrayList<>();
    for (int[] arr : arrays) {
      arrayStrings.add(Arrays.toString(arr));
    }
    System.out.println("   Входные данные: " + arrayStrings);

    List<Integer> maxValues = GenericMethods.map(arrays,
        arr -> Arrays.stream(arr).max().orElse(0));
    System.out.println("   Результат: " + maxValues);
    System.out.println("   Преобразование: int[] -> Integer");

    // Интерактивная часть, соответствующая примерам из задания
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Выберите пример для интерактивного выполнения:");
    System.out.println("1 - Строки -> Длины строк");
    System.out.println("2 - Числа -> Абсолютные значения");
    System.out.println("3 - Массивы -> Максимумы массивов");

    int choice = InputChecker.getIntInRange("Ваш выбор (1-3): ", 1, 3);

    switch (choice) {
      case 1:
        interactiveStringToLength();
        break;
      case 2:
        interactiveNumbersToAbsolute();
        break;
      case 3:
        interactiveArraysToMax();
        break;
    }
  }

  // Метод для интерактивного выполнения примера 1
  private static void interactiveStringToLength() {
    System.out.println(" Пример 1: Строки -> Длины строк");
    System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx):");
    String input = InputChecker.getString();

    // Разделяем строки по запятой и убираем пробелы
    String[] stringArray = input.split(",");
    List<String> strings = new ArrayList<>();
    for (String str : stringArray) {
      strings.add(str.trim());
    }

    System.out.println(">>> Входные данные: " + strings);

    // Применяем map для преобразования строк в их длины
    List<Integer> lengths = GenericMethods.map(strings, s -> s.length());

    System.out.println(">>> Результат преобразования: " + lengths);
    System.out.println(">>> Тип преобразования: String -> Integer");

    // Показываем подробности преобразования
    System.out.println(" Подробности преобразования:");
    for (int i = 0; i < strings.size(); i++) {
      System.out.println("   \"" + strings.get(i) + "\" -> " + lengths.get(i));
    }
  }

  // Метод для интерактивного выполнения примера 2
  private static void interactiveNumbersToAbsolute() {
    System.out.println(" Пример 2: Числа -> Абсолютные значения");
    System.out.println("Введите числа через запятую (например: 1,-3,7):");
    String input = InputChecker.getString();

    // Разделяем числа по запятой и преобразуем в Integer
    String[] numberStrs = input.split(",");
    List<Integer> numbers = new ArrayList<>();
    for (String numStr : numberStrs) {
      try {
        numbers.add(Integer.parseInt(numStr.trim()));
      } catch (NumberFormatException e) {
        System.out.println("  Пропущено нечисловое значение: '" + numStr + "'");
      }
    }

    System.out.println(">>> Входные данные: " + numbers);

    // Применяем map для преобразования чисел в абсолютные значения
    List<Integer> absoluteValues = GenericMethods.map(numbers, n -> Math.abs(n));

    System.out.println(">>> Результат преобразования: " + absoluteValues);
    System.out.println(">>> Тип преобразования: Integer -> Integer");

    // Показываем подробности преобразования
    System.out.println(" Подробности преобразования:");
    for (int i = 0; i < numbers.size(); i++) {
      System.out.println("   " + numbers.get(i) + " -> " + absoluteValues.get(i));
    }
  }

  // Метод для интерактивного выполнения примера 3
  private static void interactiveArraysToMax() {
    System.out.println(" Пример 3: Массивы -> Максимумы массивов");
    System.out.println("Сколько массивов вы хотите ввести?");
    int arrayCount = InputChecker.getIntInRange("Количество массивов: ", 1, 5);

    List<int[]> arrays = new ArrayList<>();

    for (int i = 0; i < arrayCount; i++) {
      System.out.println("Введите числа для массива " + (i + 1) + " через запятую:");
      String input = InputChecker.getString();

      // Разделяем числа по запятой и преобразуем в int[]
      String[] numberStrs = input.split(",");
      int[] array = new int[numberStrs.length];

      for (int j = 0; j < numberStrs.length; j++) {
        try {
          array[j] = Integer.parseInt(numberStrs[j].trim());
        } catch (NumberFormatException e) {
          System.out.println(" Нечисловое значение заменено на 0: '" + numberStrs[j] + "'");
          array[j] = 0;
        }
      }

      arrays.add(array);
    }

    // Выводим входные данные в читаемом формате
    List<String> arrayStrings = new ArrayList<>();
    for (int[] arr : arrays) {
      arrayStrings.add(Arrays.toString(arr));
    }
    System.out.println(">>> Входные данные: " + arrayStrings);

    // Применяем map для нахождения максимальных значений в каждом массиве
    List<Integer> maxValues = GenericMethods.map(arrays,
        arr -> Arrays.stream(arr).max().orElse(0));

    System.out.println(">>> Результат преобразования: " + maxValues);
    System.out.println(">>> Тип преобразования: int[] -> Integer");

    // Показываем подробности преобразования
    System.out.println(" Подробности преобразования:");
    for (int i = 0; i < arrays.size(); i++) {
      int[] arr = arrays.get(i);
      int max = maxValues.get(i);
      System.out.println("   " + Arrays.toString(arr) + " -> " + max);
    }
  }

  // ЗАДАНИЕ 3.2 - Filter
  private static void demonstrateFilter() {
    System.out.println("--- Демонстрация Filter (Задание 3.2) ---");

    // Демонстрация трех примеров из задания
    System.out.println("=== Примеры из задания ===");

    // Пример 1: Строки длиной >= 3
    System.out.println("1. Фильтрация строк с длиной >= 3 символов:");
    List<String> strings1 = Arrays.asList("qwerty", "asdfg", "zx");
    System.out.println("   Исходный список: " + strings1);
    List<String> longStrings = GenericMethods.filter(strings1, s -> s.length() >= 3);
    System.out.println("   Результат фильтрации: " + longStrings);

    // Пример 2: Положительные числа
    System.out.println("2. Фильтрация положительных чисел:");
    List<Integer> numbers2 = Arrays.asList(1, -3, 7);
    System.out.println("   Исходный список: " + numbers2);
    List<Integer> positiveNumbers = GenericMethods.filter(numbers2, n -> n > 0);
    System.out.println("   Результат фильтрации: " + positiveNumbers);

    // Пример 3: Массивы без положительных элементов
    System.out.println("3. Фильтрация массивов без положительных элементов:");
    List<int[]> arrays3 = Arrays.asList(
        new int[]{-1, -5, -3},
        new int[]{-2, 8, 0},
        new int[]{-4, -4, -9}
    );

    // ВЫВОД ИСХОДНЫХ МАССИВОВ НА КОНСОЛЬ
    System.out.println("   Исходные массивы:");
    for (int i = 0; i < arrays3.size(); i++) {
      System.out.println("     Массив " + (i + 1) + ": " + Arrays.toString(arrays3.get(i)));
    }

    List<int[]> nonPositiveArrays = GenericMethods.filter(arrays3,
        arr -> Arrays.stream(arr).allMatch(n -> n <= 0));

    System.out.println("   Результат фильтрации:");
    for (int i = 0; i < nonPositiveArrays.size(); i++) {
      System.out.println(
          "     Массив " + (i + 1) + ": " + Arrays.toString(nonPositiveArrays.get(i)));
    }

    // Интерактивная часть, соответствующая примерам из задания
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Выберите пример для интерактивного выполнения:");
    System.out.println("1 - Фильтрация строк (длина >= 3 символов)");
    System.out.println("2 - Фильтрация положительных чисел");
    System.out.println("3 - Фильтрация массивов (без положительных элементов)");

    int choice = InputChecker.getIntInRange("Ваш выбор (1-3): ", 1, 3);

    switch (choice) {
      case 1:
        interactiveFilterStrings();
        break;
      case 2:
        interactiveFilterNumbers();
        break;
      case 3:
        interactiveFilterArrays();
        break;
    }
  }

  // Метод для интерактивного выполнения примера 1
  private static void interactiveFilterStrings() {
    System.out.println(" Пример 1: Фильтрация строк с длиной >= 3 символов");
    System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx):");
    String input = InputChecker.getString();

    // Разделяем строки по запятой и убираем пробелы
    String[] stringArray = input.split(",");
    List<String> strings = new ArrayList<>();
    for (String str : stringArray) {
      strings.add(str.trim());
    }

    System.out.println(">>> Исходный список: " + strings);

    // Применяем фильтр для строк длиной >= 3
    List<String> filteredStrings = GenericMethods.filter(strings, s -> s.length() >= 3);

    System.out.println(">>> Результат фильтрации: " + filteredStrings);

    // Показываем подробности фильтрации
    System.out.println(" Подробности фильтрации:");
    for (String str : strings) {
      boolean passed = str.length() >= 3;
      String status = passed ? " Сохранена" : " Отфильтрована";
      System.out.println("   \"" + str + "\" (длина: " + str.length() + ") -> " + status);
    }
  }

  // Метод для интерактивного выполнения примера 2
  private static void interactiveFilterNumbers() {
    System.out.println(" Пример 2: Фильтрация положительных чисел");
    System.out.println("Введите числа через запятую (например: 1,-3,7):");
    String input = InputChecker.getString();

    // Разделяем числа по запятой и преобразуем в Integer
    String[] numberStrs = input.split(",");
    List<Integer> numbers = new ArrayList<>();
    for (String numStr : numberStrs) {
      try {
        numbers.add(Integer.parseInt(numStr.trim()));
      } catch (NumberFormatException e) {
        System.out.println("  Пропущено нечисловое значение: '" + numStr + "'");
      }
    }

    System.out.println(">>> Исходный список: " + numbers);

    // Применяем фильтр для положительных чисел
    List<Integer> positiveNumbers = GenericMethods.filter(numbers, n -> n > 0);

    System.out.println(">>> Результат фильтрации: " + positiveNumbers);

    // Показываем подробности фильтрации
    System.out.println(" Подробности фильтрации:");
    for (Integer num : numbers) {
      boolean passed = num > 0;
      String status = passed ? " Сохранено" : " Отфильтровано";
      System.out.println("   " + num + " -> " + status);
    }
  }

  // Метод для интерактивного выполнения примера 3
  private static void interactiveFilterArrays() {
    System.out.println(" Пример 3: Фильтрация массивов без положительных элементов");
    System.out.println("Сколько массивов вы хотите ввести?");
    int arrayCount = InputChecker.getIntInRange("Количество массивов: ", 1, 5);

    List<int[]> arrays = new ArrayList<>();

    for (int i = 0; i < arrayCount; i++) {
      System.out.println("Введите числа для массива " + (i + 1) + " через запятую:");
      String input = InputChecker.getString();

      // Разделяем числа по запятой и преобразуем в int[]
      String[] numberStrs = input.split(",");
      int[] array = new int[numberStrs.length];

      for (int j = 0; j < numberStrs.length; j++) {
        try {
          array[j] = Integer.parseInt(numberStrs[j].trim());
        } catch (NumberFormatException e) {
          System.out.println("  Нечисловое значение заменено на 0: '" + numberStrs[j] + "'");
          array[j] = 0;
        }
      }

      arrays.add(array);
    }

    // ВЫВОД ИСХОДНЫХ МАССИВОВ НА КОНСОЛЬ
    System.out.println(">>> Исходные массивы:");
    for (int i = 0; i < arrays.size(); i++) {
      int[] arr = arrays.get(i);
      System.out.println("   Массив " + (i + 1) + ": " + Arrays.toString(arr));
    }

    // Применяем фильтр для массивов без положительных элементов
    List<int[]> filteredArrays = GenericMethods.filter(arrays,
        arr -> Arrays.stream(arr).allMatch(n -> n <= 0));

    System.out.println(">>> Результат фильтрации:");
    if (filteredArrays.isEmpty()) {
      System.out.println("   Нет массивов без положительных элементов");
    } else {
      for (int i = 0; i < filteredArrays.size(); i++) {
        int[] arr = filteredArrays.get(i);
        System.out.println("   Массив " + (i + 1) + ": " + Arrays.toString(arr));
      }
    }

    // Показываем подробности фильтрации
    System.out.println(" Подробности фильтрации:");
    for (int i = 0; i < arrays.size(); i++) {
      int[] arr = arrays.get(i);
      boolean hasPositive = Arrays.stream(arr).anyMatch(n -> n > 0);
      boolean passed = !hasPositive; // Проходит фильтр если НЕТ положительных
      String status = passed ? " Сохранен" : " Отфильтрован";
      String reason = passed ? "нет положительных элементов" : "есть положительные элементы";
      System.out.println(
          "   Массив " + (i + 1) + ": " + Arrays.toString(arr) + " -> " + status + " (" + reason
              + ")");
    }
  }

  // ЗАДАНИЕ 3.3 - Reduce
  // ЗАДАНИЕ 3.3 - Reduce
  private static void demonstrateReduce() {
    System.out.println("--- Демонстрация Reduce (Задание 3.3) ---");

    // Демонстрация трех примеров из задания
    System.out.println("=== Примеры из задания ===");

    // Пример 1: Конкатенация строк
    System.out.println("1. Конкатенация строк:");
    List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
    System.out.println("   Исходный список: " + strings);
    String concatenated = GenericMethods.reduce(strings, (s1, s2) -> s1 + s2, "");
    System.out.println("   Результат конкатенации: " + concatenated);

    // Пример 2: Сумма чисел
    System.out.println("2. Сумма чисел:");
    List<Integer> numbers = Arrays.asList(1, -3, 7);
    System.out.println("   Исходный список: " + numbers);
    Integer sum = GenericMethods.reduce(numbers, (n1, n2) -> n1 + n2, 0);
    System.out.println("   Результат суммы: " + sum);

    // Пример 3: Общее количество элементов во вложенных списках
    System.out.println("3. Общее количество элементов во вложенных списках:");
    List<List<Integer>> listOfLists = Arrays.asList(
        Arrays.asList(1, 2, 3),
        Arrays.asList(4, 5),
        Arrays.asList(6, 7, 8, 9)
    );
    System.out.println("   Исходный список списков: " + listOfLists);

    // Используем методы из 3.3.1 (map) и 3.3.3 (reduce)
    List<Integer> sizes = GenericMethods.map(listOfLists, List::size);
    System.out.println("   Размеры каждого списка: " + sizes);
    Integer totalSize = GenericMethods.reduce(sizes, (n1, n2) -> n1 + n2, 0);
    System.out.println("   Общее количество элементов: " + totalSize);

    // Демонстрация защиты от пустого списка
    System.out.println("4. Защита от пустого списка:");
    List<String> emptyList = new ArrayList<>();
    System.out.println("   Пустой список: " + emptyList);
    String emptyResult = GenericMethods.reduce(emptyList, (s1, s2) -> s1 + s2, "default");
    System.out.println("   Результат для пустого списка: " + emptyResult);

    // Интерактивная часть - три примера из задания
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Выберите пример для интерактивного выполнения:");
    System.out.println("1 - Конкатенация строк");
    System.out.println("2 - Сумма чисел");
    System.out.println("3 - Общее количество элементов в списках");

    int choice = InputChecker.getIntInRange("Ваш выбор (1-3): ", 1, 3);

    switch (choice) {
      case 1:
        interactiveReduceStrings();
        break;
      case 2:
        interactiveReduceNumbers();
        break;
      case 3:
        interactiveReduceListOfLists();
        break;
    }
  }

  // Метод для интерактивного выполнения примера 1 - Конкатенация строк
  private static void interactiveReduceStrings() {
    System.out.println("--- Конкатенация строк ---");
    System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx):");
    String input = InputChecker.getString();

    // Разделяем строки по запятой и убираем пробелы
    String[] stringArray = input.split(",");
    List<String> strings = new ArrayList<>();
    for (String str : stringArray) {
      strings.add(str.trim());
    }

    System.out.println(">>> Исходный список: " + strings);

    // Применяем reduce для конкатенации строк
    String result = GenericMethods.reduce(strings, (s1, s2) -> s1 + s2, "");

    System.out.println(">>> Результат конкатенации: " + result);

    // Показываем процесс
    System.out.println(">>> Процесс конкатенации:");
    String process = "";
    for (int i = 0; i < strings.size(); i++) {
      if (i == 0) {
        process = "\"" + strings.get(i) + "\"";
      } else {
        process += " + \"" + strings.get(i) + "\"";
      }
      System.out.println("   Шаг " + (i + 1) + ": " + process);
    }
  }

  // Метод для интерактивного выполнения примера 2 - Сумма чисел
  private static void interactiveReduceNumbers() {
    System.out.println("--- Сумма чисел ---");
    System.out.println("Введите числа через запятую (например: 1,-3,7):");
    String input = InputChecker.getString();

    // Разделяем числа по запятой и преобразуем в Integer
    String[] numberStrs = input.split(",");
    List<Integer> numbers = new ArrayList<>();
    for (String numStr : numberStrs) {
      try {
        numbers.add(Integer.parseInt(numStr.trim()));
      } catch (NumberFormatException e) {
        System.out.println("  Пропущено нечисловое значение: '" + numStr + "'");
      }
    }

    System.out.println(">>> Исходный список: " + numbers);

    // Применяем reduce для суммы чисел
    Integer result = GenericMethods.reduce(numbers, (n1, n2) -> n1 + n2, 0);

    System.out.println(">>> Результат суммы: " + result);

    // Показываем процесс
    System.out.println(">>> Процесс суммирования:");
    int process = 0;
    for (int i = 0; i < numbers.size(); i++) {
      if (i == 0) {
        process = numbers.get(i);
        System.out.println("   Шаг " + (i + 1) + ": " + numbers.get(i) + " = " + process);
      } else {
        int prev = process;
        process += numbers.get(i);
        System.out.println(
            "   Шаг " + (i + 1) + ": " + prev + " + " + numbers.get(i) + " = " + process);
      }
    }
  }

  // Метод для интерактивного выполнения примера 3 - Общее количество элементов в списках
  private static void interactiveReduceListOfLists() {
    System.out.println("--- Общее количество элементов в списках ---");
    System.out.println("Сколько списков вы хотите ввести?");
    int listCount = InputChecker.getIntInRange("Количество списков: ", 1, 5);

    List<List<Integer>> listOfLists = new ArrayList<>();

    for (int i = 0; i < listCount; i++) {
      System.out.println("Введите числа для списка " + (i + 1) + " через запятую:");
      String input = InputChecker.getString();

      // Разделяем числа по запятой и преобразуем в List<Integer>
      String[] numberStrs = input.split(",");
      List<Integer> currentList = new ArrayList<>();
      for (String numStr : numberStrs) {
        try {
          currentList.add(Integer.parseInt(numStr.trim()));
        } catch (NumberFormatException e) {
          System.out.println("  Пропущено нечисловое значение: '" + numStr + "'");
        }
      }
      listOfLists.add(currentList);
    }

    System.out.println(">>> Исходный список списков: " + listOfLists);

    // Используем метод map из задания 3.3.1 для получения размеров каждого списка
    List<Integer> sizes = GenericMethods.map(listOfLists, List::size);
    System.out.println(">>> Размеры каждого списка: " + sizes);

    // Используем метод reduce из задания 3.3.3 для получения общего количества
    Integer totalSize = GenericMethods.reduce(sizes, (n1, n2) -> n1 + n2, 0);

    System.out.println(">>> Общее количество элементов: " + totalSize);

    // Показываем процесс
    System.out.println(">>> Процесс вычисления:");
    System.out.println("   1. Map: преобразуем списки в их размеры -> " + sizes);
    System.out.println("   2. Reduce: суммируем размеры -> " + totalSize);

    // Детальный процесс суммирования
    int process = 0;
    for (int i = 0; i < sizes.size(); i++) {
      if (i == 0) {
        process = sizes.get(i);
        System.out.println("      Шаг " + (i + 1) + ": " + sizes.get(i) + " = " + process);
      } else {
        int prev = process;
        process += sizes.get(i);
        System.out.println(
            "      Шаг " + (i + 1) + ": " + prev + " + " + sizes.get(i) + " = " + process);
      }
    }
  }

  // ЗАДАНИЕ 3.4 - Collect
  private static void demonstrateCollect() {
    System.out.println("--- Демонстрация Collect (Задание 3.4) ---");

    // Демонстрация трех примеров из задания
    System.out.println("=== Примеры из задания ===");

    // Пример 1: Разбиение на положительные и отрицательные числа
    System.out.println("1. Разбиение чисел на положительные и отрицательные:");
    List<Integer> numbers = Arrays.asList(1, -3, 7);
    System.out.println("   Исходный список: " + numbers);

    Map<Boolean, List<Integer>> partitioned = GenericMethods.collect(
        numbers,
        () -> {
          Map<Boolean, List<Integer>> map = new HashMap<>();
          map.put(true, new ArrayList<>());  // для положительных
          map.put(false, new ArrayList<>()); // для отрицательных
          return map;
        },
        (number, map) -> {
          if (number > 0) {
            map.get(true).add(number);
          } else {
            map.get(false).add(number);
          }
        }
    );
    System.out.println("   Результат разбиения: " + partitioned);
    System.out.println("   Положительные: " + partitioned.get(true));
    System.out.println("   Отрицательные: " + partitioned.get(false));

    // Пример 2: Группировка строк по длине
    System.out.println("2. Группировка строк по длине:");
    List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
    System.out.println("   Исходный список: " + strings);

    Map<Integer, List<String>> groupedByLength = GenericMethods.collect(
        strings,
        HashMap::new,
        (str, map) -> {
          map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
        }
    );
    System.out.println("   Результат группировки: " + groupedByLength);
    for (Map.Entry<Integer, List<String>> entry : groupedByLength.entrySet()) {
      System.out.println("   Длина " + entry.getKey() + ": " + entry.getValue());
    }

    // Пример 3: Уникальные строки (Set)
    System.out.println("3. Уникальные строки (без дубликатов):");
    List<String> duplicateStrings = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
    System.out.println("   Исходный список: " + duplicateStrings);

    Set<String> uniqueStrings = GenericMethods.collectToSet(duplicateStrings);
    System.out.println("   Результат (уникальные): " + uniqueStrings);

    // Интерактивная часть - три примера из задания
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Выберите пример для интерактивного выполнения:");
    System.out.println("1 - Разбиение чисел на положительные/отрицательные");
    System.out.println("2 - Группировка строк по длине");
    System.out.println("3 - Уникальные строки (без дубликатов)");

    int choice = InputChecker.getIntInRange("Ваш выбор (1-3): ", 1, 3);

    switch (choice) {
      case 1:
        interactiveCollectNumbers();
        break;
      case 2:
        interactiveCollectStringsByLength();
        break;
      case 3:
        interactiveCollectUniqueStrings();
        break;
    }
  }

  // Метод для интерактивного выполнения примера 1 - Разбиение чисел
  private static void interactiveCollectNumbers() {
    System.out.println("--- Разбиение чисел на положительные и отрицательные ---");
    System.out.println("Введите числа через запятую (например: 1,-3,7):");
    String input = InputChecker.getString();

    // Разделяем числа по запятой и преобразуем в Integer
    String[] numberStrs = input.split(",");
    List<Integer> numbers = new ArrayList<>();
    for (String numStr : numberStrs) {
      try {
        numbers.add(Integer.parseInt(numStr.trim()));
      } catch (NumberFormatException e) {
        System.out.println("  Пропущено нечисловое значение: '" + numStr + "'");
      }
    }

    System.out.println(">>> Исходный список: " + numbers);

    // Применяем collect для разбиения чисел
    Map<Boolean, List<Integer>> result = GenericMethods.collect(
        numbers,
        () -> {
          Map<Boolean, List<Integer>> map = new HashMap<>();
          map.put(true, new ArrayList<>());
          map.put(false, new ArrayList<>());
          return map;
        },
        (number, map) -> {
          if (number > 0) {
            map.get(true).add(number);
          } else {
            map.get(false).add(number);
          }
        }
    );

    System.out.println(">>> Результат разбиения:");
    System.out.println("   Положительные числа: " + result.get(true));
    System.out.println("   Отрицательные числа: " + result.get(false));

    // Показываем процесс
    System.out.println(">>> Процесс разбиения:");
    List<Integer> positive = new ArrayList<>();
    List<Integer> negative = new ArrayList<>();

    for (Integer number : numbers) {
      if (number > 0) {
        positive.add(number);
        System.out.println("   " + number + " -> положительные: " + positive);
      } else {
        negative.add(number);
        System.out.println("   " + number + " -> отрицательные: " + negative);
      }
    }
  }

  // Метод для интерактивного выполнения примера 2 - Группировка строк по длине
  private static void interactiveCollectStringsByLength() {
    System.out.println("--- Группировка строк по длине ---");
    System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx,qw):");
    String input = InputChecker.getString();

    // Разделяем строки по запятой и убираем пробелы
    String[] stringArray = input.split(",");
    List<String> strings = new ArrayList<>();
    for (String str : stringArray) {
      strings.add(str.trim());
    }

    System.out.println(">>> Исходный список: " + strings);

    // Применяем collect для группировки по длине
    Map<Integer, List<String>> result = GenericMethods.collect(
        strings,
        HashMap::new,
        (str, map) -> {
          map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
        }
    );

    System.out.println(">>> Результат группировки:");
    for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
      System.out.println("   Длина " + entry.getKey() + ": " + entry.getValue());
    }

    // Показываем процесс
    System.out.println(">>> Процесс группировки:");
    Map<Integer, List<String>> processMap = new HashMap<>();
    for (String str : strings) {
      int length = str.length();
      if (!processMap.containsKey(length)) {
        processMap.put(length, new ArrayList<>());
      }
      processMap.get(length).add(str);
      System.out.println("   \"" + str + "\" (длина " + length + ") -> " + processMap);
    }
  }

  // Метод для интерактивного выполнения примера 3 - Уникальные строки
  private static void interactiveCollectUniqueStrings() {
    System.out.println("--- Уникальные строки (без дубликатов) ---");
    System.out.println("Введите строки через запятую (например: qwerty,asdfg,qwerty,qw):");
    String input = InputChecker.getString();

    // Разделяем строки по запятой и убираем пробелы
    String[] stringArray = input.split(",");
    List<String> strings = new ArrayList<>();
    for (String str : stringArray) {
      strings.add(str.trim());
    }

    System.out.println(">>> Исходный список: " + strings);

    // Применяем collectToSet для получения уникальных строк
    Set<String> result = GenericMethods.collectToSet(strings);

    System.out.println(">>> Результат (уникальные строки): " + result);

    // Показываем процесс
    System.out.println(">>> Процесс удаления дубликатов:");
    Set<String> processSet = new HashSet<>();
    for (String str : strings) {
      boolean isNew = processSet.add(str);
      String status = isNew ? "Добавлено" : "ДУБЛИКАТ - пропущено";
      System.out.println("   \"" + str + "\" -> " + status + " -> Текущий набор: " + processSet);
    }
  }

}
