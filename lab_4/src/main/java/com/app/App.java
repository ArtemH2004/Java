package com.app;

import com.app.entity.Person;
import com.app.service.CsvReaderService;

import java.io.IOException;
import java.util.List;

/**
 * Основной класс приложения для обработки данных о сотрудниках.
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
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        String csvFilePath = "people.csv";
        char separator = ';';

        com.app.service.CsvReaderService readerService = new CsvReaderService();

        try {
            List<Person> people = readerService.readPeopleFromCsv(csvFilePath, separator);
            System.out.println("Successfully read " + people.size() + " people:");
            people.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}