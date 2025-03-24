package com.app;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Реализация стека на основе ArrayList.
 *
 * @param <T> Тип элементов стека.
 */
public class Stack<T> {
    private ArrayList<T> elements;

    /**
     * Создает новый пустой стек.
     */
    public Stack() {
        elements = new ArrayList<>();
    }

    /**
     * Добавляет элемент на вершину стека.
     *
     * @param item Элемент для добавления.
     */
    public void push(T item) {
        elements.add(item);
    }

    /**
     * Проверяет, пуст ли стек, и выбрасывает исключение, если это так.
     *
     * @throws EmptyStackException Если стек пуст.
     */
    private void isEmptyStackException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    /**
     * Удаляет и возвращает элемент с вершины стека.
     *
     * @return Элемент с вершины стека.
     * @throws EmptyStackException Если стек пуст.
     */
    public T pop() {
        isEmptyStackException();
        return elements.remove(elements.size() - 1);
    }

    /**
     * Возвращает элемент с вершины стека без его удаления.
     *
     * @return Элемент с вершины стека.
     * @throws EmptyStackException Если стек пуст.
     */
    public T peek() {
        isEmptyStackException();
        return elements.get(elements.size() - 1);
    }

    /**
     * Проверяет, пуст ли стек.
     *
     * @return true, если стек пуст, иначе false.
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}