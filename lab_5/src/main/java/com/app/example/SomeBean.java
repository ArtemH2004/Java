package com.app.example;

import com.app.annotation.AutoInjectable;
import com.app.example.interfaces.SomeInterface;
import com.app.example.interfaces.SomeOtherInterface;

/**
 * Класс, демонстрирующий внедрение зависимостей.
 * Содержит поля для внедрения реализаций интерфейсов.
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Вызывает методы внедренных зависимостей.
     * Выводит результат их работы в консоль.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}