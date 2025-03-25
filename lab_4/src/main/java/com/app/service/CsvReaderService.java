package com.app.service;

import com.app.entity.Person;
import com.app.entity.Department;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Сервис для чтения данных о сотрудниках из CSV-файла.
 */
public class CsvReaderService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Читает данные о сотрудниках из CSV-файла.
     *
     * @param csvFilePath путь к CSV-файлу в ресурсах
     * @param separator   разделитель полей в CSV-файле
     * @return список сотрудников
     * @throws IOException  если произошла ошибка ввода-вывода
     * @throws CsvException если произошла ошибка парсинга CSV
     */
    public List<Person> readPeopleFromCsv(String csvFilePath, char separator)
            throws IOException, CsvException {

        List<Person> people = new ArrayList<>();
        Map<String, Department> departments = new HashMap<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                CSVReader reader = in == null ? null
                        : new CSVReaderBuilder(inputStreamReader)
                                .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
                                .build()) {

            if (reader == null) {
                throw new FileNotFoundException("File not found: " + csvFilePath);
            }

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length < 6)
                    continue;

                Person person = parsePerson(nextLine, departments);
                people.add(person);
            }
        }

        return people;
    }

    /**
     * Преобразует массив строк из CSV в объект Person.
     *
     * @param data        массив строк с данными о сотруднике
     * @param departments словарь подразделений для избежания дублирования
     * @return объект Person
     */
    private Person parsePerson(String[] data, Map<String, Department> departments) {
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String gender = data[2];
        String departmentName = data[3];
        double salary = Double.parseDouble(data[4]);
        LocalDate birthDate = LocalDate.parse(data[5], DATE_FORMATTER);

        Department department = departments.computeIfAbsent(
                departmentName, Department::new);

        return new Person(id, name, gender, department, salary, birthDate);
    }
}