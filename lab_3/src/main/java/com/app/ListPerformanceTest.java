package com.app;

import java.util.*;

public class ListPerformanceTest {
    
    public static long testAdd(List<Integer> list, int operationsCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long testGet(List<Integer> list, int operationsCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long testRemove(List<Integer> list, int operationsCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationsCount; i++) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
