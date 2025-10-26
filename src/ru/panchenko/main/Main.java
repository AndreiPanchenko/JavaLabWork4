package ru.panchenko.main;

import ru.panchenko.geometry.*;
import ru.panchenko.collections.ImmutableList;
import ru.panchenko.extended.*;
import java.util.Arrays;

public class Main {

  // Точка входа в программу
  public static void main(String[] args) {
    // Обработка аргументов командной строки для задания 7.3
    if (args.length == 2) {
      handleCommandLineArgs(args);
    }

    // Запуск интерактивного меню
    runInteractiveMenu();
  }

  // Обработка аргументов командной строки
  private static void handleCommandLineArgs(String[] args) {
    try {
      double result = PowerCalculator.calculatePower(args[0], args[1]);
      System.out.println("Результат возведения в степень: " +
          args[0] + " ^ " + args[1] + " = " + result);
    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка при обработке аргументов командной строки: " +  e.getMessage());
    }
    System.out.println(); // Пустая строка для разделения
  }


  // Запуск интерактивного меню
  private static void runInteractiveMenu() {
    while (true) {
      printMenu();
      int choice = InputChecker.getInt("Выберите задание: ");

      // Обработка выбора пользователя
      switch (choice) {
        case 1:
          demonstrateLine();
          break;
        case 2:
          demonstrateSquare();
          break;
        case 3:
          demonstrateImmutableList();
          break;
        case 4:
          demonstratePoint3D();
          break;
        case 5:
          demonstrateExtendedPoints();
          break;
        case 6:
          demonstrateSum();
          break;
        case 7:
          demonstrateLineComparison();
          break;
        case 8:
          demonstrateLineClone();
          break;
        case 0:
          System.out.println("Выход из программы. До свидания!");
          return;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
          break;
      }
      System.out.println(); // Пустая строка для разделения
    }
  }

  // Вывод главного меню

  private static void printMenu() {
    System.out.println("=== ГЛАВНОЕ МЕНЮ ===");
    System.out.println("1. Демонстрация линии (Задание 1 (6))");
    System.out.println("2. Демонстрация квадрата (Задание 1 (12))");
    System.out.println("3. Неизменяемый список (Задание 2 (1))");
    System.out.println("4. Трехмерная точка (Задание 3 (5))");
    System.out.println("5. Расширенные точки (Задание 4 (5))");
    System.out.println("6. Суммирование чисел (Задание 5 (1))");
    System.out.println("7. Сравнение линий (Задание 6 (3))");
    System.out.println("8. Клонирование линии (Задание 8 (5))");
    System.out.println("0. Выход");
  }

  // Демонстрация работы с линией

  private static void demonstrateLine() {
    System.out.println("--- Демонстрация линии (Задание 1) ---");

    // Явный пример для демонстрации требований задания
    System.out.println("=== Пример из задания ===");
    Line exampleLine = new Line(2, 3, 8, 7);
    System.out.println("Создана линия: " + exampleLine);

    // Демонстрация: У Линии можно запросить координаты начала или конца
    System.out.println("1. Запрос координат начала и конца:");
    System.out.println("Координаты начала: " + exampleLine.getStart());
    System.out.println("Координаты конца: " + exampleLine.getEnd());

    // Демонстрация: У Линии можно изменить координаты начала или конца
    System.out.println("2. Изменение координат начала на (0, 0):");
    exampleLine.setStart(new Point(0, 0));
    System.out.println("После изменения начала: " + exampleLine);

    System.out.println("3. Изменение координат конца на (10, 5):");
    exampleLine.setEnd(new Point(10, 5));
    System.out.println("После изменения конца: " + exampleLine);

    // Демонстрация длины линии
    System.out.println("4. Длина линии после изменений: " + exampleLine.getLength());
    System.out.println();

    // Интерактивная часть
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте свою линию:");
    double x1 = InputChecker.getDouble("Начало - X: ");
    double y1 = InputChecker.getDouble("Начало - Y: ");
    double x2 = InputChecker.getDouble("Конец - X: ");
    double y2 = InputChecker.getDouble("Конец - Y: ");

    Line userLine = new Line(x1, y1, x2, y2);
    System.out.println("Создана: " + userLine);
    System.out.println("Длина линии: " + userLine.getLength());

    // Интерактивное меню для работы с линией
    demonstrateLineOperations(userLine);
  }

  // Интерактивные операции с линией

  private static void demonstrateLineOperations(Line line) {
    while (true) {
      System.out.println("=== Операции с линией ===");
      System.out.println("1. Запросить координаты начала");
      System.out.println("2. Запросить координаты конца");
      System.out.println("3. Изменить координаты начала");
      System.out.println("4. Изменить координаты конца");
      System.out.println("5. Показать длину линии");
      System.out.println("6. Показать полную информацию о линии");
      System.out.println("0. Вернуться в главное меню");

      int choice = InputChecker.getInt("Выберите операцию: ");

      switch (choice) {
        case 1:
          Point start = line.getStart();
          System.out.println("Координаты начала линии: " + start);
          break;
        case 2:
          Point end = line.getEnd();
          System.out.println("Координаты конца линии: " + end);
          break;
        case 3:
          System.out.println("Введите новые координаты начала:");
          double newX = InputChecker.getDouble("X: ");
          double newY = InputChecker.getDouble("Y: ");
          Point newStart = new Point(newX, newY);
          line.setStart(newStart);
          System.out.println("Координаты начала обновлены!");
          System.out.println("Текущая линия: " + line);
          System.out.println("Новая длина: " + line.getLength());
          break;
        case 4:
          System.out.println("Введите новые координаты конца:");
          double newX2 = InputChecker.getDouble("X: ");
          double newY2 = InputChecker.getDouble("Y: ");
          Point newEnd = new Point(newX2, newY2);
          line.setEnd(newEnd);
          System.out.println("Координаты конца обновлены!");
          System.out.println("Текущая линия: " + line);
          System.out.println("Новая длина: " + line.getLength());
          break;
        case 5:
          System.out.println("Длина линии: " + line.getLength());
          break;
        case 6:
          System.out.println("Полная информация о линии:");
          System.out.println("Линия: " + line);
          System.out.println("Начало: " + line.getStart());
          System.out.println("Конец: " + line.getEnd());
          System.out.println("Длина: " + line.getLength());
          break;
        case 0:
          System.out.println("Возврат в главное меню...");
          return;
        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
          break;
      }
    }
  }

  // Демонстрация работы с квадратом

  private static void demonstrateSquare() {
    System.out.println("--- Демонстрация квадрата (Задание 1 (12)) ---");

    System.out.println("=== Пример из задания ===");

    Square exampleSquare1 = new Square(5, 3, 23);
    System.out.println("1. Создан через координаты: " + exampleSquare1);


    Point topLeftPoint = new Point(5, 3);
    Square exampleSquare2 = new Square(topLeftPoint, 23);
    System.out.println("2. Создан через точку: " + exampleSquare2);

    Polyline examplePolyline = exampleSquare2.getPolyline();
    System.out.println("3. Ломаная из квадрата: " + examplePolyline);
    System.out.println("4. Длина ломаной: " + examplePolyline.getLength());

    // Изменение последней точки
    System.out.println("5. Изменяем последнюю точку ломаной на {15, 25}");
    java.util.List<Point> examplePoints = examplePolyline.getPoints();
    if (!examplePoints.isEmpty()) {
      Point lastPoint = examplePoints.get(examplePoints.size() - 1);
      lastPoint.setX(15);
      lastPoint.setY(25);
    }

    System.out.println("6. Новая длина ломаной: " + examplePolyline.getLength());
    System.out.println();

    // Интерактивная часть
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Выберите способ создания квадрата:");
    System.out.println("1 - Создать через координаты");
    System.out.println("2 - Создать через объект точки");

    int choice = InputChecker.getIntInRange("Ваш выбор: ", 1, 2);

    Square userSquare;

    if (choice == 1) {
      System.out.println("Создание квадрата через координаты:");
      double x = InputChecker.getDouble("Координата X левого верхнего угла: ");
      double y = InputChecker.getDouble("Координата Y левого верхнего угла: ");
      double side = InputChecker.getPositiveDouble("Длина стороны: ");

      userSquare = new Square(x, y, side);
    } else {
      // Создание через точку
      System.out.println("Создание квадрата через точку:");
      double x = InputChecker.getDouble("Координата X левого верхнего угла: ");
      double y = InputChecker.getDouble("Координата Y левого верхнего угла: ");
      double side = InputChecker.getPositiveDouble("Длина стороны: ");

      Point userTopLeft = new Point(x, y);
      userSquare = new Square(userTopLeft, side);
    }

    System.out.println("Создан: " + userSquare);
    Polyline userPolyline = userSquare.getPolyline();
    System.out.println("Ломаная: " + userPolyline);
    System.out.println("Длина ломаной: " + userPolyline.getLength());

    // Дополнительная демонстрация изменения ломаной
    System.out.println("Хотите изменить последнюю точку ломаной? (да/нет)");
    String answer = InputChecker.getString();
    if (answer.equalsIgnoreCase("да")) {
      double newX = InputChecker.getDouble("Новая координата X: ");
      double newY = InputChecker.getDouble("Новая координата Y: ");

      java.util.List<Point> userPoints = userPolyline.getPoints();
      if (!userPoints.isEmpty()) {
        Point lastUserPoint = userPoints.get(userPoints.size() - 1);
        lastUserPoint.setX(newX);
        lastUserPoint.setY(newY);
        System.out.println("Новая длина ломаной: " + userPolyline.getLength());
      }
    }
  }

  // Демонстрация работы неизменяемого списка
  private static void demonstrateImmutableList() {
    System.out.println("--- Демонстрация неизменяемого списка (Задание 2 (1)) ---");

    System.out.println("=== Пример из задания ===");
    ImmutableList exampleList = new ImmutableList(10, 20, 30, 40, 50);
    System.out.println("Исходный список: " + exampleList);

    // Демонстрация неизменяемости
    ImmutableList modifiedList = exampleList.set(1, 99);
    System.out.println("После замены элемента [1]=99: " + modifiedList);
    System.out.println("Исходный список не изменился: " + exampleList);

    // Демонстрация конструктора копирования
    ImmutableList copiedList = new ImmutableList(exampleList);
    System.out.println("Копия списка: " + copiedList);

    // Демонстрация методов
    System.out.println("Элемент по индексу 2: " + exampleList.get(2));
    System.out.println("Размер списка: " + exampleList.size());
    System.out.println("Список пустой? " + exampleList.isEmpty());

    // Демонстрация toArray()
    int[] array = exampleList.toArray();
    System.out.println("Массив из toArray(): " + Arrays.toString(array));
    System.out.println();

    // Интерактивная часть
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте свой список (введите числа через пробел):");
    String input = InputChecker.getString();
    String[] numbers = input.split(" ");
    int[] userValues = new int[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      try {
        userValues[i] = Integer.parseInt(numbers[i]);
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: '" + numbers[i] + "' не является целым числом. Будет заменено на 0.");
        userValues[i] = 0;
      }
    }

    ImmutableList userList = new ImmutableList(userValues);
    System.out.println("Создан список: " + userList);

    // Интерактивная работа со списком
    while (true) {
      System.out.println("=== Операции с вашим списком ===");
      System.out.println("1. Получить элемент по позиции");
      System.out.println("2. Заменить элемент по позиции (создать новый список)");
      System.out.println("3. Проверить пустоту списка");
      System.out.println("4. Узнать размер списка");
      System.out.println("5. Получить массив значений");
      System.out.println("6. Создать копию списка");
      System.out.println("7. Показать текущий список");
      System.out.println("0. Вернуться в главное меню");

      int operation = InputChecker.getIntInRange("Выберите операцию: ", 0, 7);

      switch (operation) {
        case 1:
          if (userList.isEmpty()) {
            System.out.println("Список пуст!");
          } else {
            int index = InputChecker.getIntInRange("Введите позицию (0-" + (userList.size() - 1) + "): ",
                0, userList.size() - 1);
            try {
              int value = userList.get(index);
              System.out.println("Элемент в позиции " + index + ": " + value);
            } catch (IndexOutOfBoundsException e) {
              System.out.println("Ошибка: " + e.getMessage());
            }
          }
          break;

        case 2:
          if (userList.isEmpty()) {
            System.out.println("Список пуст!");
          } else {
            int index = InputChecker.getIntInRange("Введите позицию для замены (0-" + (userList.size() - 1) + "): ",
                0, userList.size() - 1);
            int newValue = InputChecker.getInt("Введите новое значение: ");
            try {
              ImmutableList newList = userList.set(index, newValue);
              System.out.println("Новый список создан: " + newList);
              System.out.println("Исходный список: " + userList + " (не изменился)");
              System.out.println("Хотите продолжить работу с новым списком? (да/нет)");
              String answer = InputChecker.getString();
              if (answer.equalsIgnoreCase("да")) {
                userList = newList;
                System.out.println("Теперь работаем с новым списком: " + userList);
              }
            } catch (IndexOutOfBoundsException e) {
              System.out.println("Ошибка: " + e.getMessage());
            }
          }
          break;

        case 3:
          System.out.println("Список пуст? " + userList.isEmpty());
          break;

        case 4:
          System.out.println("Размер списка: " + userList.size());
          break;

        case 5:
          int[] arrayCopy = userList.toArray();
          System.out.println("Массив значений: " + Arrays.toString(arrayCopy));
          break;

        case 6:
          ImmutableList listCopy = new ImmutableList(userList);
          System.out.println("Копия списка создана: " + listCopy);
          System.out.println("Хотите продолжить работу с копией? (да/нет)");
          String copyAnswer = InputChecker.getString();
          if (copyAnswer.equalsIgnoreCase("да")) {
            userList = listCopy;
            System.out.println("Теперь работаем с копией списка: " + userList);
          }
          break;

        case 7:
          System.out.println("Текущий список: " + userList);
          System.out.println("Строковое представление: " + userList.toString());
          System.out.println("Размер: " + userList.size());
          System.out.println("Пуст? " + userList.isEmpty());
          break;

        case 0:
          System.out.println("Возврат в главное меню...");
          return;

        default:
          System.out.println("Неверный выбор! Попробуйте снова.");
          break;
      }
    }
  }
  // Демонстрация трехмерной точки
  private static void demonstratePoint3D() {
    System.out.println("--- Демонстрация трехмерной точки (Задание 3 (5)) ---");

    System.out.println("=== Пример из задания ===");
    Point3D example3D = new Point3D(1, 2, 3);
    System.out.println("Трехмерная точка: " + example3D);

    // Демонстрация наследования
    Point basePoint = example3D;
    System.out.println("Как обычная точка (только X, Y): " + basePoint);

    // Изменение координаты Z
    example3D.setZ(10);
    System.out.println("После изменения Z на 10: " + example3D);
    System.out.println();

    // Интерактивная часть
    System.out.println("=== Интерактивная часть ===");
    double x = InputChecker.getDouble("Введите координату X: ");
    double y = InputChecker.getDouble("Введите координату Y: ");
    double z = InputChecker.getDouble("Введите координату Z: ");

    Point3D userPoint3D = new Point3D(x, y, z);
    System.out.println("Создана: " + userPoint3D);

    // Демонстрация работы с координатой Z
    double newZ = InputChecker.getDouble("Введите новое значение Z: ");
    userPoint3D.setZ(newZ);
    System.out.println("После изменения Z: " + userPoint3D);
  }

  // Демонстрация расширенных точек
  private static void demonstrateExtendedPoints() {
    System.out.println("\n--- Демонстрация расширенных точек (Задание 4) ---");

    // Явный пример для демонстрации
    System.out.println("=== Пример из задания ===");
    ColoredPoint coloredExample = new ColoredPoint(3, 5, "красный");
    TimedPoint timedExample = new TimedPoint(4, 2, "12:30");
    ColoredPoint complexExample = new ColoredPoint(7, 7, "желтый");

    System.out.println("Пример 1 - " + coloredExample);
    System.out.println("Пример 2 - " + timedExample);
    System.out.println("Пример 3 - " + complexExample);

    // Демонстрация полиморфизма
    AbstractPoint[] examplePoints = {coloredExample, timedExample, complexExample};
    System.out.println("\nМассив абстрактных точек (полиморфизм):");
    for (AbstractPoint point : examplePoints) {
      System.out.println("  - " + point);
    }
    System.out.println();

    // Интерактивная часть
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте цветную точку:");
    double x1 = InputChecker.getDouble("Координата X: ");
    double y1 = InputChecker.getDouble("Координата Y: ");
    String color = InputChecker.getNonEmptyString("Цвет: ");
    ColoredPoint userColored = new ColoredPoint(x1, y1, color);

    System.out.println("Создайте точку со временем:");
    double x2 = InputChecker.getDouble("Координата X: ");
    double y2 = InputChecker.getDouble("Координата Y: ");
    String time = InputChecker.getNonEmptyString("Время: ");
    TimedPoint userTimed = new TimedPoint(x2, y2, time);

    System.out.println("Результат:");
    System.out.println("Цветная точка: " + userColored);
    System.out.println("Точка со временем: " + userTimed);
  }

  //Демонстрация суммирования чисел

  private static void demonstrateSum() {
    System.out.println("--- Демонстрация суммирования чисел (Задание 5 (1)) ---");

    // Вычисления по условию задания
    double result1 = SumCalculator.sum(2, 3.0/5, 2.3);
    double result2 = SumCalculator.sum(3.6, 49.0/12, 3, 3.0/2);
    double result3 = SumCalculator.sum(1.0/3, 1);

    System.out.println("2 + 3/5 + 2.3 = " + result1);
    System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);
    System.out.println("1/3 + 1 = " + result3);

    // Демонстрация с пользовательским вводом
    System.out.println("Демонстрация с пользовательским вводом:");
    double num1 = InputChecker.getDouble("Введите первое число: ");
    double num2 = InputChecker.getDouble("Введите второе число: ");
    double num3 = InputChecker.getDouble("Введите третье число: ");

    double customSum = SumCalculator.sum(num1, num2, num3);
    System.out.println("Сумма: " + customSum);
  }

  //Демонстрация сравнения линий
  private static void demonstrateLineComparison() {
    System.out.println("--- Демонстрация сравнения линий (Задание 6 (3)) ---");

    // Явный пример для демонстрации
    System.out.println("=== Пример из задания ===");
    Line lineA = new Line(0, 0, 5, 5);
    Line lineB = new Line(0, 0, 5, 5); // Такая же как lineA
    Line lineC = new Line(1, 1, 10, 10); // Другая линия
    Line lineD = new Line(5, 5, 0, 0); // Обратная линия (не равна)

    System.out.println("Линия A: " + lineA);
    System.out.println("Линия B: " + lineB);
    System.out.println("Линия C: " + lineC);
    System.out.println("Линия D: " + lineD);

    System.out.println("A.equals(B): " + lineA.equals(lineB) + " (ожидается true)");
    System.out.println("A.equals(C): " + lineA.equals(lineC) + " (ожидается false)");
    System.out.println("A.equals(D): " + lineA.equals(lineD) + " (ожидается false)");
    System.out.println("A == B: " + (lineA == lineB) + " (ожидается false - разные объекты)");
    System.out.println();

    // Интерактивная часть
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте две линии для сравнения:");

    System.out.println("Первая линия:");
    double x1 = InputChecker.getDouble("x1: ");
    double y1 = InputChecker.getDouble("y1: ");
    double x2 = InputChecker.getDouble("x2: ");
    double y2 = InputChecker.getDouble("y2: ");
    Line userLine1 = new Line(x1, y1, x2, y2);

    System.out.println("Вторая линия:");
    double x3 = InputChecker.getDouble("x1: ");
    double y3 = InputChecker.getDouble("y1: ");
    double x4 = InputChecker.getDouble("x2: ");
    double y4 = InputChecker.getDouble("y2: ");
    Line userLine2 = new Line(x3, y3, x4, y4);

    System.out.println("Линия 1: " + userLine1);
    System.out.println("Линия 2: " + userLine2);
    System.out.println("Линии равны? " + userLine1.equals(userLine2));
  }

  // Демонстрация клонирования линии

  private static void demonstrateLineClone() {
    System.out.println("--- Демонстрация клонирования линии (Задание 8 (5)) ---");

    // Явный пример для демонстрации
    System.out.println("=== Пример из задания ===");
    Line originalExample = new Line(2, 2, 8, 8);
    Line clonedExample = originalExample.clone();

    System.out.println("Оригинал: " + originalExample);
    System.out.println("Клон: " + clonedExample);
    System.out.println("Оригинал.equals(Клон): " + originalExample.equals(clonedExample));
    System.out.println("Оригинал == Клон: " + (originalExample == clonedExample));

    // Демонстрация независимости
    System.out.println("Изменяем начальную точку клона на (10, 10):");
    clonedExample.setStart(new Point(10, 10));

    System.out.println("После изменения:");
    System.out.println("Оригинал: " + originalExample + " (не изменился)");
    System.out.println("Клон: " + clonedExample + " (изменился)");
    System.out.println("Теперь линии равны? " + originalExample.equals(clonedExample));
    System.out.println();

    // Интерактивная часть
    System.out.println("=== Интерактивная часть ===");
    System.out.println("Создайте линию для клонирования:");
    double x1 = InputChecker.getDouble("x1: ");
    double y1 = InputChecker.getDouble("y1: ");
    double x2 = InputChecker.getDouble("x2: ");
    double y2 = InputChecker.getDouble("y2: ");

    Line original = new Line(x1, y1, x2, y2);
    Line cloned = original.clone();

    System.out.println("Оригинал: " + original);
    System.out.println("Клон: " + cloned);
    System.out.println("Оригинал и клон равны? " + original.equals(cloned));
    System.out.println("Это один и тот же объект? " + (original == cloned));

    // Демонстрация изменений
    System.out.println("Хотите изменить клон? (да/нет)");
    String answer = InputChecker.getString();
    if (answer.equalsIgnoreCase("да")) {
      double newX = InputChecker.getDouble("Новая координата X начала: ");
      double newY = InputChecker.getDouble("Новая координата Y начала: ");
      cloned.setStart(new Point(newX, newY));

      System.out.println("После изменения клона:");
      System.out.println("Оригинал: " + original);
      System.out.println("Клон: " + cloned);
      System.out.println("Теперь линии равны? " + original.equals(cloned));
    }
  }
}