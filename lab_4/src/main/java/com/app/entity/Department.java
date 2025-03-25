package com.app.entity;

public class Department {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    public Department(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{id='" + id + "', name='" + name + "'}";
    }
}