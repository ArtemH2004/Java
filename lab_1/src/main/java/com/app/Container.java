package com.app;

public class Container {
    private int[] elements;
    private int size;

    public Container() {
        this.elements = new int[10];
        this.size = 0;
    }

    public void add(int element) {
        if (size == elements.length) {
            int[] newArray = new int[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }

        elements[size++] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return elements[index];
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        int removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        return removedElement;
    }

    public int size() {
        return size;
    }
}
