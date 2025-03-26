package com.app;

import org.junit.jupiter.api.Test;

import com.app.core.Injector;
import com.app.example.SomeBean;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit тесты
 */
public class AppTest {
    /**
     * Тестирует поведение конструктора Injector при передаче null в качестве
     * параметра.
     * Ожидается, что будет выброшено исключение, так как имя файла конфигурации
     * не может быть null.
     */
    @Test
    public void testNullParamConstructor() {
        assertThrows(Exception.class, () -> {
            new Injector(null);
        });
    }

    /**
     * Тестирует поведение метода inject при передаче null в качестве объекта для
     * внедрения зависимостей.
     * Ожидается, что будет выброшено исключение, так как нельзя внедрять
     * зависимости в null объект.
     */
    @Test
    public void testNullObject() {
        Injector injector = new Injector("injector-ac.properties");

        assertThrows(Exception.class, () -> {
            injector.inject(null);
        });
    }

    /**
     * Тестирует работу Injector с основной конфигурацией (injector-ac.properties).
     * Проверяет, что внедрение зависимостей и вызов метода foo() выполняются без
     * исключений.
     * Также проверяет, что основной метод приложения App.main() работает корректно.
     */
    @Test
    public void testFirstFileProperties() {
        Injector injector = new Injector("injector-ac.properties");
        injector.inject(new SomeBean()).foo();

        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }

    /**
     * Тестирует работу Injector с альтернативной конфигурацией
     * (injector-bc.properties).
     * Проверяет, что внедрение зависимостей и вызов метода foo() выполняются без
     * исключений.
     * Также проверяет, что основной метод приложения App.main() работает корректно.
     */
    @Test
    public void testSecondFileProperties() {
        Injector injector = new Injector("injector-bc.properties");
        injector.inject(new SomeBean()).foo();

        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }

    /**
     * Дополнительный тест для проверки работы Injector с альтернативной
     * конфигурацией.
     * Проверяет непосредственно вызов метода foo() на объекте SomeBean после
     * внедрения зависимостей.
     * Ожидается, что метод выполнится без исключений.
     */
    @Test
    public void testOtherInjectorProperties() {
        Injector injector = new Injector("injector-bc.properties");
        SomeBean sb = injector.inject(new SomeBean());

        assertDoesNotThrow(() -> {
            sb.foo();
        });
    }
}
