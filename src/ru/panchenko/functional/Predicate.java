package ru.panchenko.functional;

//Функциональный интерфейс для операции Filter (Задание 3.2)Проверяет условие для объекта типа T
@FunctionalInterface
public interface Predicate<T> {
  // Проверяет условие для аргумента

  boolean test(T t);
}