package com.app;

/**
 * Класс-контейнер для хранения произвольного количества целых чисел.
 * Реализован на основе массива с автоматическим увеличением емкости при
 * необходимости.
 */
public class Container {
    private int[] elements; // Массив для хранения элементов
    private int size; // Текущее количество элементов в контейнере
    private static final int INITIAL_CAPACITY = 10; // Начальная емкость контейнера

    /**
     * Конструктор по умолчанию. Создает контейнер с начальной емкостью.
     */
    public Container() {
        this.elements = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Добавляет элемент в контейнер.
     * Если емкость контейнера недостаточна, она автоматически увеличивается.
     *
     * @param element элемент для добавления
     */
    public void add(int element) {
        if (size == elements.length) {
            resize();
        }

        elements[size++] = element;
    }

    /**
     * Проверяет, что индекс находится в допустимых пределах.
     * Если индекс выходит за пределы, выбрасывает исключение
     * IndexOutOfBoundsException.
     *
     * @param index индекс для проверки
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    private void indexOutOfBoundsCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public int get(int index) {
        indexOutOfBoundsCheck(index);

        return elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу и возвращает его.
     * Все последующие элементы сдвигаются на одну позицию влево.
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    public int remove(int index) {
        indexOutOfBoundsCheck(index);

        int removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        return removedElement;
    }

    /**
     * Очищает контейнер, удаляя все элементы и сбрасывая размер до 0.
     */
    public void clear() {
        elements = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     *
     * @return количество элементов
     */
    public int size() {
        return size;
    }

    /**
     * Увеличивает емкость контейнера в 2 раза.
     * Используется, когда текущая емкость недостаточна для добавления нового
     * элемента.
     */
    private void resize() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}