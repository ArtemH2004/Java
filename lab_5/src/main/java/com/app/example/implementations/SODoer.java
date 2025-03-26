package com.app.example.implementations;

import com.app.example.interfaces.SomeOtherInterface;

/**
 * Реализация интерфейса SomeOtherInterface, выводящая "C" при вызове
 * doSomeOther().
 */
public class SODoer implements SomeOtherInterface {
    /**
     * Выводит "C" в консоль.
     */
    @Override
    public void doSomeOther() {
        System.out.println("C");
    }
}