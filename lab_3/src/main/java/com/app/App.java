package com.app;

import java.util.*;

/**
 * Главный класс приложения для тестирования производительности ArrayList и LinkedList.
 * Сравнивает время выполнения операций добавления, получения и удаления элементов.
 */
public class App {
    /**
     * Конструктор по умолчанию.
     * Создает экземпляр класса App.
     */
    public App() {
        // Конструктор по умолчанию
    }

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        int operationsCount = 10000;

        List<Integer> arrayList = new ArrayList<>();
        long arrayListAddTime = ListPerformanceTest.testAdd(arrayList, operationsCount);
        long arrayListGetTime = ListPerformanceTest.testGet(arrayList, operationsCount);
        long arrayListRemoveTime = ListPerformanceTest.testRemove(arrayList, operationsCount);

        List<Integer> linkedList = new LinkedList<>();
        long linkedListAddTime = ListPerformanceTest.testAdd(linkedList, operationsCount);
        long linkedListGetTime = ListPerformanceTest.testGet(linkedList, operationsCount);
        long linkedListRemoveTime = ListPerformanceTest.testRemove(linkedList, operationsCount);

        System.out.println("Performance Test Results:");
        System.out.println("| List Type       | Operations Count | Add Time         | Get Time         | Remove Time      |");
        System.out.println("|-----------------|------------------|------------------|------------------|------------------|");

        ResultTable.printTable("ArrayList", operationsCount, arrayListAddTime, arrayListGetTime, arrayListRemoveTime);

        ResultTable.printTable("LinkedList", operationsCount, linkedListAddTime, linkedListGetTime, linkedListRemoveTime);
    }
}
