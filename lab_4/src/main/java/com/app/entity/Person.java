package com.app.entity;

import java.time.LocalDate;

/**
 * Класс, представляющий сотрудника компании.
 * Содержит персональные данные и информацию о должности.
 */
public class Person {
    private final int id;
    private final String name;
    private final String gender;
    private final Department department;
    private final double salary;
    private final LocalDate birthDate;

    /**
     * Создает новый экземпляр сотрудника.
     *
     * @param id         Уникальный идентификатор сотрудника
     * @param name       ФИО сотрудника
     * @param gender     Пол сотрудника ("М" или "Ж")
     * @param department Подразделение, в котором работает сотрудник
     * @param salary     Зарплата сотрудника
     * @param birthDate  Дата рождения сотрудника
     */
    public Person(int id, String name, String gender,
            Department department, double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает идентификатор сотрудника.
     *
     * @return идентификатор сотрудника
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает Фамилию и Имя сотрудника.
     *
     * @return Фамилия и Имя сотрудника
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает пол сотрудника.
     *
     * @return пол сотрудника ("М" или "Ж")
     */
    public String getGender() {
        return gender;
    }

    /**
     * Возвращает подразделение сотрудника.
     *
     * @return объект подразделения
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Возвращает зарплату сотрудника.
     *
     * @return зарплата
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Возвращает дату рождения сотрудника.
     *
     * @return дата рождения
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Возвращает строковое представление сотрудника.
     *
     * @return строка с полной информацией о сотруднике
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}