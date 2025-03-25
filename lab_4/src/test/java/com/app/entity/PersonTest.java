package com.app.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Тесты для класса Person.
 */
class PersonTest {

    /**
     * Проверка создания сотрудника и корректности геттеров.
     */
    @Test
    void testPersonCreation() {
        Department department = new Department("IT");
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        Person person = new Person(1, "Иванов Иван", "М", department, 100000, birthDate);

        assertNotNull(person);
        assertEquals(1, person.getId());
        assertEquals("Иванов Иван", person.getName());
        assertEquals("М", person.getGender());
        assertEquals(department, person.getDepartment());
        assertEquals(100000, person.getSalary());
        assertEquals(birthDate, person.getBirthDate());
    }

    /**
     * Проверка метода toString().
     */
    @Test
    void testToString() {
        Department department = new Department("HR");
        LocalDate birthDate = LocalDate.of(1985, 10, 22);
        Person person = new Person(2, "Петрова Мария", "Ж", department, 90000, birthDate);

        String expected = "Person{id=2, name='Петрова Мария', gender='Ж', " +
                "department=Department{id='" + department.getId() +
                "', name='HR'}, salary=90000.0, birthDate=1985-10-22}";

        assertEquals(expected, person.toString());
    }
}