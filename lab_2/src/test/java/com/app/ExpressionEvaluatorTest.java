package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Тесты для проверки функциональности класса ExpressionEvaluator.
 */
public class ExpressionEvaluatorTest {
    private ExpressionEvaluator evaluator;
    private Map<String, Double> variables;

    /**
     * Настраивает тестовую среду перед каждым тестом.
     */
    @BeforeEach
    public void setUp() {
        evaluator = new ExpressionEvaluator();
        variables = new HashMap<>();
    }

    /**
     * Тестирует операцию сложения.
     */
    @Test
    public void testAddition() {
        String expression = "3 + 5";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(8.0, result);
    }

    /**
     * Тестирует операцию вычитания.
     */
    @Test
    public void testSubtraction() {
        String expression = "10 - 4";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(6.0, result);
    }

    /**
     * Тестирует операцию умножения.
     */
    @Test
    public void testMultiplication() {
        String expression = "6 * 7";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(42.0, result);
    }

    /**
     * Тестирует операцию деления.
     */
    @Test
    public void testDivision() {
        String expression = "20 / 4";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(5.0, result);
    }

    /**
     * Тестирует операцию возведения в степень.
     */
    @Test
    public void testExponentiation() {
        String expression = "2 ^ 3";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(8.0, result);
    }

    /**
     * Тестирует использование переменной в выражении.
     */
    @Test
    public void testVariable() {
        variables.put("x", 10.0);
        String expression = "x + 5";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(15.0, result);
    }

    /**
     * Тестирует функцию синуса.
     */
    @Test
    public void testFunctionSin() {
        String expression = "sin(0)";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(0.0, result);
    }

    /**
     * Тестирует функцию косинуса.
     */
    @Test
    public void testFunctionCos() {
        String expression = "cos(0)";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(1.0, result);
    }

    /**
     * Тестирует функцию тангенса.
     */
    @Test
    public void testFunctionTan() {
        String expression = "tan(0)";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(0.0, result);
    }

    /**
     * Тестирует функцию логарифма.
     */
    @Test
    public void testFunctionLog() {
        String expression = "log(10)";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(2.302585092994046, result);
    }

    /**
     * Тестирует функцию квадратного корня.
     */
    @Test
    public void testFunctionSqrt() {
        String expression = "sqrt(16)";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(4.0, result);
    }

    /**
     * Тестирует функцию экспоненты.
     */
    @Test
    public void testFunctionExp() {
        String expression = "exp(1)";
        double result = evaluator.evaluate(expression, variables);
        assertEquals(2.718281828459045, result);
    }

    /**
     * Тестирует деление на ноль и ожидает выброса исключения.
     */
    @Test
    public void testDivisionByZero() {
        String expression = "1 / 0";
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            evaluator.evaluate(expression, variables);
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    /**
     * Тестирует выражение с неизвестной переменной и ожидает выброса исключения.
     */
    @Test
    public void testUnknownVariable() {
        String expression = "a + 5";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            evaluator.evaluate(expression, variables);
        });
        assertEquals("Unknown variable or function: a", exception.getMessage());
    }
}
