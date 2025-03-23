package com.app;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(T item) {
        elements.add(item);
    }

    private void isEmptyStackException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    public T pop() {
        isEmptyStackException();
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        isEmptyStackException();
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}