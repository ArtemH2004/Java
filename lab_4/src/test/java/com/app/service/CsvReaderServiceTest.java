package com.app.service;

import com.app.entity.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Тесты для класса {@link CsvReaderService}.
 */
class CsvReaderServiceTest {

    /**
     * Проверка чтения корректного CSV-файла.
     */
    @Test
    void testReadPeopleFromValidCsv() throws Exception {
        CsvReaderService readerService = new CsvReaderService();
        String csvFilePath = "people.csv";
        char separator = ';';
        
        List<Person> people = readerService.readPeopleFromCsv(csvFilePath, separator);
        
        assertNotNull(people);
        assertFalse(people.isEmpty());
        
        Person firstPerson = people.get(0);
        assertEquals(1, firstPerson.getId());
        assertEquals("Иванов Иван", firstPerson.getName());
        assertEquals("IT", firstPerson.getDepartment().getName());
    }

    /**
     * Проверка обработки некорректных данных в CSV.
     */
    @Test
    void testReadPeopleWithInvalidData() {
        CsvReaderService readerService = new CsvReaderService();
        String invalidDataFile = "invalid.csv";
        char separator = ';';
        
        assertThrows(Exception.class, () -> {
            readerService.readPeopleFromCsv(invalidDataFile, separator);
        });
    }
}