package com.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expression = scanner.nextLine().replaceAll("\\s+", "");

        try {
            Map<String, Double> variables = new HashMap<>();

            Pattern variablePattern = Pattern.compile("\\b[a-zA-Z]+\\b");
            Matcher matcher = variablePattern.matcher(expression);

            String[] functions = {"sin", "cos", "tan", "sqrt", "log", "exp"};

            while (matcher.find()) {
                String variable = matcher.group();

                boolean isFunction = false;
                for (String func : functions) {
                    if (variable.equals(func)) {
                        isFunction = true;
                        break;
                    }
                }

                if (!isFunction && !variables.containsKey(variable)) {
                    System.out.print("Enter the variable value " + variable + ": ");
                    variables.put(variable, scanner.nextDouble());
                }
            }

            ExpressionEvaluator evaluator = new ExpressionEvaluator();
            double result = evaluator.evaluate(expression, variables);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}