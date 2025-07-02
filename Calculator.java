/**
 * Made by lagar322
 * <3
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    // Список для хранения истории операций
    private static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Добро пожаловать в калькулятор!");

        while (running) {
            System.out.println("\nВыберите действие: ");
            System.out.println("1. Выполнить вычисление");
            System.out.println("2. Показать историю");
            System.out.println("3. Очистить историю");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performCalculation(scanner);
                    break;
                    case 2:
                        showHistory();
                        break;
                        case 3:
                            clearHistory();
                            break;
                            case 4:
                                running = false;
                                System.out.println("До свидания!");
                                break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    // Метод выполнения вычисления
    private static void performCalculation(Scanner scanner) {
        System.out.println("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.println("Введите операцию (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        System.out.println("Введите второе число: ");
        double num2 = scanner.nextDouble();

        double result = 0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
                case '-':
                    result = num1 - num2;
                    break;
                    case '*':
                        result = num1 * num2;
                        break;
                        case '/':
                            result = num1 / num2;
                            break;
                            case '%':
                                result = num1 % num2;
                                break;
                                default:
                                    System.out.println("Неподдерживаемая операция.");
                                    return;
        }

        String entry = num1 + num2 + "=" + result;
        history.add(entry);

        System.out.println("Результат: " + result);
    }

    // Метод отображения истории
    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("История операций пуста.");
            return;
        }

        System.out.println("История операций:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }

    // Метод для очистки истории
    private static void clearHistory() {
        history.clear();
        System.out.println("История операций очищена.");
    }
}
