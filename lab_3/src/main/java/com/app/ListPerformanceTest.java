package com.app;

import java.util.*;

/**
 * Класс для тестирования производительности операций со списками.
 * Измеряет время выполнения операций добавления, получения и удаления элементов.
 */
public class ListPerformanceTest {
    
    /**
     * Тестирует производительность операции добавления элементов в список.
     * 
     * @param list Список для тестирования
     * @param operationsCount Количество операций для выполнения
     * @return Время выполнения операций в наносекундах
     */
    public static long testAdd(List<Integer> list, int operationsCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Тестирует производительность операции получения элементов из списка.
     * 
     * @param list Список для тестирования
     * @param operationsCount Количество операций для выполнения
     * @return Время выполнения операций в наносекундах
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка
     */
    public static long testGet(List<Integer> list, int operationsCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Тестирует производительность операции удаления элементов из списка.
     * 
     * @param list Список для тестирования
     * @param operationsCount Количество операций для выполнения
     * @return Время выполнения операций в наносекундах
     * @throws IndexOutOfBoundsException если список пуст
     */
    public static long testRemove(List<Integer> list, int operationsCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
