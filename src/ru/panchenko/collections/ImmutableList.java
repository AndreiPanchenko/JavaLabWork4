package ru.panchenko.collections;

import java.util.Arrays;

// Класс неизменяемого списка целых чисел

public class ImmutableList {
  private final int[] values;

  // Конструктор с перечнем чисел

  public ImmutableList(int... values) {
    if (values == null) {
      throw new IllegalArgumentException("Массив не может быть null");
    }
    for (int i = 0; i < values.length; i++) {
      if (values[i] != (int) values[i]) {
        throw new IllegalArgumentException("Элемент с индексом " + i + " не является целым числом: " + values[i]);
      }
    }
    this.values = Arrays.copyOf(values, values.length);
  }

  // Конструктор копирования

  public ImmutableList(ImmutableList other) {
    if (other == null) {
      throw new IllegalArgumentException("Другой список не может быть null");
    }
    this.values = Arrays.copyOf(other.values, other.values.length);
  }

  // Получение значения по индексу

  public int get(int index) {
    if (index < 0 || index >= values.length) {
      throw new IndexOutOfBoundsException(
          "Индекс " + index + " вне границ [0, " + (values.length - 1) + "]"
      );
    }
    return values[index];
  }

  // Замена значения по индексу (возвращает новый объект)

  public ImmutableList set(int index, int value) {
    if (index < 0 || index >= values.length) {
      throw new IndexOutOfBoundsException(
          "Индекс " + index + " вне границ [0, " + (values.length - 1) + "]"
      );
    }
    if (value != (int) value) {
      throw new IllegalArgumentException("Новое значение не является целым числом: " + value);
    }
    int[] newValues = Arrays.copyOf(values, values.length);
    newValues[index] = value;
    return new ImmutableList(newValues);
  }


  public boolean isEmpty() {
    return values.length == 0;
  }

  // Получение размера списка

  public int size() {
    return values.length;
  }

  // Получение копии массива значений

  public int[] toArray() {
    return Arrays.copyOf(values, values.length);
  }



  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}