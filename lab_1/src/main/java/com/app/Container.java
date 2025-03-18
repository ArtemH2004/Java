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
            resize();
        }

        elements[size++] = element;
    }

    private void indexOutOfBoundsCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public int get(int index) {
        indexOutOfBoundsCheck(index);

        return elements[index];
    }

    public int remove(int index) {
        indexOutOfBoundsCheck(index);

        int removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        return removedElement;
    }

    public void clear() {
        elements = new int[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
