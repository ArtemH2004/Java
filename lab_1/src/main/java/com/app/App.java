package com.app;

import java.util.Scanner;

/**
 * Основной класс для взаимодействия с пользователем.
 * Позволяет добавлять, удалять, получать элементы контейнера, а также очищать
 * его.
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
     * Точка входа в программу.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Container container = new Container();
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int action, number, index;

        while (flag) {
            System.out.println(
                    "\n1) add element;\n2) get element by index;\n3) get all container elements;\n4) delete element by index;\n5) get container size;\n6) clear container;\n0) exit");
            System.out.print("\nEnter action: ");
            action = in.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Enter number: ");
                    number = in.nextInt();
                    container.add(number);
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    index = in.nextInt();
                    int element = container.get(index);
                    System.out.println("Element: " + element);
                    break;
                case 3:
                    System.out.println("Container elements:");
                    for (int i = 0; i < container.size(); i++) {
                        System.out.println(container.get(i));
                    }
                    break;
                case 4:
                    System.out.print("Enter index: ");
                    index = in.nextInt();
                    container.remove(index);
                    System.out.println("Element successfully removed");
                    break;
                case 5:
                    System.out.println("Container size: " + container.size());
                    break;
                case 6:
                    container.clear();
                    System.out.println("Container successfully cleared");
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Something went wrong");
            }
        }

        in.close();
    }
}