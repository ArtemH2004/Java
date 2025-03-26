package com.app.example.implementations;

import com.app.example.interfaces.SomeInterface;

/**
 * Реализация интерфейса SomeInterface, выводящая "A" при вызове doSomething().
 */
public class SomeImpl implements SomeInterface {
    /**
     * Выводит "A" в консоль.
     */
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}
