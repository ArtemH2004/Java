package com.app.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Тесты для класса {@link Department}.
 */
class DepartmentTest {

    /**
     * Проверка создания отдела и корректности геттеров.
     */
    @Test
    void testDepartmentCreation() {
        String departmentName = "IT";
        Department department = new Department(departmentName);

        assertNotNull(department);
        assertEquals(departmentName, department.getName());
        assertTrue(department.getId() > 0);
    }

    /**
     * Проверка автоинкремента идентификатора отдела.
     */
    @Test
    void testIdAutoIncrement() {
        Department dept1 = new Department("HR");
        Department dept2 = new Department("Finance");

        assertTrue(dept2.getId() > dept1.getId());
    }

    /**
     * Проверка метода toString().
     */
    @Test
    void testToString() {
        Department department = new Department("Marketing");
        String expectedString = "Department{id='" + department.getId() + "', name='Marketing'}";

        assertEquals(expectedString, department.toString());
    }
}