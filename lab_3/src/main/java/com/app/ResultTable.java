package com.app;

public class ResultTable {
    public static void printTable(String listType, int operationsCount, long addTime, long getTime, long removeTime) {
        System.out.printf("| %-15s | %-16d | %-16d | %-16d | %-16d |\n",
                listType, operationsCount, addTime, getTime, removeTime);
    }
}
