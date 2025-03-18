package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Тесты для класса Container.
 */
public class ContainerTest {

    private Container container;

    /**
     * Инициализация контейнера перед каждым тестом.
     */
    @BeforeEach
    public void setUp() {
        container = new Container();
    }

    /**
     * Тест метода add().
     * Проверяет, что элементы добавляются корректно и размер контейнера увеличивается.
     */
    @Test
    public void testAdd() {
        container.add(10);
        container.add(20);
        assertEquals(2, container.size(), "Container size should be 2");
        assertEquals(10, container.get(0), "First element should be 10");
        assertEquals(20, container.get(1), "Second element should be 20");
    }

    /**
     * Тест метода get().
     * Проверяет, что метод корректно возвращает элемент по индексу.
     */
    @Test
    public void testGet() {
        container.add(10);
        container.add(20);
        assertEquals(10, container.get(0), "First element should be 10");
        assertEquals(20, container.get(1), "Second element should be 20");
    }

    /**
     * Тест метода get() с некорректным индексом.
     * Проверяет, что метод выбрасывает исключение IndexOutOfBoundsException.
     */
    @Test
    public void testGetWithInvalidIndex() {
        container.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1), "Should be IndexOutOfBoundsException");
    }

    /**
     * Тест метода remove().
     * Проверяет, что элемент удаляется корректно и размер контейнера уменьшается.
     */
    @Test
    public void testRemove() {
        container.add(10);
        container.add(20);
        container.add(30);
        int removedElement = container.remove(1);
        assertEquals(20, removedElement, "Removed element should be 20");
        assertEquals(2, container.size(), "Containder size should be 2");
        assertEquals(10, container.get(0), "First element should be 10");
        assertEquals(30, container.get(1), "Second element should be 30");
    }

    /**
     * Тест метода remove() с некорректным индексом.
     * Проверяет, что метод выбрасывает исключение IndexOutOfBoundsException.
     */
    @Test
    public void testRemoveWithInvalidIndex() {
        container.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1), "Should be IndexOutOfBoundsException");
    }

    /**
     * Тест метода clear().
     * Проверяет, что контейнер очищается корректно.
     */
    @Test
    public void testClear() {
        container.add(10);
        container.add(20);
        container.clear();
        assertEquals(0, container.size(), "Container size should be 0");
    }

    /**
     * Тест метода size().
     * Проверяет, что метод корректно возвращает размер контейнера.
     */
    @Test
    public void testSize() {
        container.add(10);
        container.add(20);
        assertEquals(2, container.size(), "Container size should be 2");
    }

    /**
     * Тест увеличения емкости контейнера.
     * Проверяет, что контейнер корректно увеличивает емкость при добавлении большого количества элементов.
     */
    @Test
    public void testResize() {
        for (int i = 0; i < 20; i++) {
            container.add(i);
        }
        assertEquals(20, container.size(), "Container size should be 20");
        assertEquals(19, container.get(19), "Last element should be 19");
    }
}