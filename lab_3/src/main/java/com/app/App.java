package com.app;

import java.util.*;

public class App {
    
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
