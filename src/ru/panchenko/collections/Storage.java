package ru.panchenko.collections;

// ЗАДАНИЕ 1.2 - Обобщенное хранилище

public class Storage<T> {
  private final T value;

  //Создает хранилище с указанным значением

  public Storage(T value) {
    this.value = value;
  }

  // Возвращает хранимое значение

  public T getValue() {
    return value;
  }

  // Возвращает хранимое значение или альтернативное, если значение null

  public T getValueOrDefault(T defaultValue) {
    return value != null ? value : defaultValue;
  }

  @Override
  public String toString() {
    return "Storage{value=" + value + "}";
  }

  // Выводит числовое хранилище с альтернативой 0
  public static void printNumberStorage(Storage<Integer> storage) {
    Integer value = storage.getValueOrDefault(0);
    System.out.println("Значение: " + value);
  }

  // Выводит строковое хранилище с альтернативой "default"

  public static void printStringStorage(Storage<String> storage) {
    String value = storage.getValueOrDefault("default");
    System.out.println("Значение: " + value);
  }

  // Выводит числовое хранилище с альтернативой -1
  public static void printNumberStorageAlt(Storage<Integer> storage) {
    Integer value = storage.getValueOrDefault(-1);
    System.out.println("Значение: " + value);
  }

  // Выводит строковое хранилище с альтернативой "hello world"

  public static void printStringStorageAlt(Storage<String> storage) {
    String value = storage.getValueOrDefault("hello world");
    System.out.println("Значение: " + value);
  }
}