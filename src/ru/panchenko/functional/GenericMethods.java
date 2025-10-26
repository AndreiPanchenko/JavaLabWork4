package ru.panchenko.functional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

// ЗАДАНИЯ 3.1-3.4 - Обобщенные методы

public class GenericMethods {

  // ЗАДАНИЕ 3.1 - Map (Функция)
  public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
    List<R> result = new ArrayList<>();
    for (T item : list) {
      result.add(function.apply(item));
    }
    return result;
  }

  // ЗАДАНИЕ 3.2 - Filter (Фильтр)
  public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
    List<T> result = new ArrayList<>();
    for (T item : list) {
      if (predicate.test(item)) {
        result.add(item);
      }
    }
    return result;
  }

  // ЗАДАНИЕ 3.3 - Reduce (Сокращение)
  public static <T> T reduce(List<T> list, BinaryOperator<T> operator, T identity) {
    // Гарантированно не возвращает null (требование задания)
    if (list == null || list.isEmpty()) {
      return identity;
    }

    T result = identity;
    for (T item : list) {
      result = operator.apply(result, item);
    }
    return result;
  }

  // ЗАДАНИЕ 3.4 - Collect (Коллекционирование) -
  public static <T, R> R collect(List<T> list,
      Supplier<R> supplier,
      BiConsumer<T, R> accumulator) {
    R result = supplier.get();
    for (T item : list) {
      accumulator.accept(item, result);
    }
    return result;
  }

  // Дополнительный метод collect для работы с Set
  public static <T> Set<T> collectToSet(List<T> list) {
    return new HashSet<>(list);
  }
}