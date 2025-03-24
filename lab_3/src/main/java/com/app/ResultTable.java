package com.app;

/**
 * Класс для форматированного вывода результатов тестирования в виде таблицы.
 */
public class ResultTable {
    
    /**
     * Выводит строку с результатами тестирования в табличном формате.
     * 
     * @param listType Тип списка (ArrayList или LinkedList)
     * @param operationsCount Количество выполненных операций
     * @param addTime Время выполнения операций добавления (в наносекундах)
     * @param getTime Время выполнения операций получения (в наносекундах)
     * @param removeTime Время выполнения операций удаления (в наносекундах)
     */
    public static void printTable(String listType, int operationsCount, long addTime, long getTime, long removeTime) {
        System.out.printf("| %-15s | %-16d | %-16d | %-16d | %-16d |\n",
                listType, operationsCount, addTime, getTime, removeTime);
    }
}
