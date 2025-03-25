package com.app.entity;

/**
 * Класс, представляющий подразделение компании.
 * Каждое подразделение имеет уникальный идентификатор и название.
 */
public class Department {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    /**
     * Создает новый экземпляр подразделения.
     *
     * @param name Название подразделения (не может быть null или пустым)
     */
    public Department(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    /**
     * Возвращает уникальный идентификатор подразделения.
     *
     * @return идентификатор подразделения
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название подразделения.
     *
     * @return название подразделения
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает строковое представление подразделения.
     *
     * @return строка в формате "Department{id='X', name='Y'}"
     */
    @Override
    public String toString() {
        return "Department{id='" + id + "', name='" + name + "'}";
    }
}