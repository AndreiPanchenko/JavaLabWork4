package ru.panchenko.functional;

//Функциональный интерфейс для операции Map (Задание 3.1) Преобразует объект типа T в объект типа R

@FunctionalInterface
public interface Function<T, R> {
  //Применяет функцию к аргументу

  R apply(T t);
}