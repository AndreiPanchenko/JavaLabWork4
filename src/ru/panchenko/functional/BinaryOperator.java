package ru.panchenko.functional;

//Функциональный интерфейс для операции Reduce (Задание 3.3) Объединяет два объекта типа T в один

@FunctionalInterface
public interface BinaryOperator<T> {
  //Применяет оператор к двум аргументам
  T apply(T t1, T t2);
}