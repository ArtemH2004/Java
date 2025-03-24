package com.app;

import java.util.Map;

public class ExpressionEvaluator {
    private static final String OPERATORS = "+-*/^";
    private static final String FUNCTIONS = "sin|cos|tan|sqrt|log|exp";

    public double evaluate(String expression, Map<String, Double> variables) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i++));
                }
                i--;
                numbers.push(Double.parseDouble(numBuilder.toString()));
            }

            else if (Character.isLetter(c)) {
                StringBuilder nameBuilder = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    nameBuilder.append(expression.charAt(i++));
                }
                i--; 
                String name = nameBuilder.toString();
                if (name.matches(FUNCTIONS)) {
                    i++;
                    StringBuilder argBuilder = new StringBuilder();
                    int bracketCount = 1; 
                    while (i < expression.length() && bracketCount > 0) {
                        char ch = expression.charAt(i++);
                        if (ch == '(') bracketCount++;
                        if (ch == ')') bracketCount--;
                        if (bracketCount > 0) argBuilder.append(ch);
                    }
                    double arg = evaluate(argBuilder.toString(), variables);
                    numbers.push(applyFunction(name, arg)); 
                } else if (variables.containsKey(name)) {
                    numbers.push(variables.get(name)); 
                } else {
                    throw new IllegalArgumentException("Unknown variable or function: " + name);
                }
            }

            else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private boolean isOperator(char c) {
        return OPERATORS.indexOf(c) != -1;
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private double applyOperation(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private double applyFunction(String name, double arg) {
        switch (name) {
            case "sin":
                return Math.sin(arg);
            case "cos":
                return Math.cos(arg);
            case "tan":
                return Math.tan(arg);
            case "sqrt":
                return Math.sqrt(arg);
            case "log":
                return Math.log(arg);
            case "exp":
                return Math.exp(arg);
            default:
                throw new IllegalArgumentException("Unknown function: " + name);
        }
    }
}