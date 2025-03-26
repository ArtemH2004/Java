package com.app;

import com.app.core.Injector;
import com.app.example.SomeBean;

/**
 * Главный класс приложения, демонстрирующий работу DI-контейнера.
 */
public class App {
    /**
     * Конструктор по умолчанию.
     * Создает экземпляр класса App.
     */
    public App() {
        // Конструктор по умолчанию
    }

    /**
     * Точка входа в приложение.
     * Создает экземпляр SomeBean с внедренными зависимостями
     * и вызывает его метод foo().
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        SomeBean sb = new Injector("injector-bc.properties").inject(new SomeBean());
        sb.foo();
    }
}
