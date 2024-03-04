package me.athishh.calculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter precision:");
        int precision = scanner.nextInt();
        scanner.nextLine();

        Calculator calculator = new Calculator(precision);

        // looping cuz I don't wanna restart the program every time for every calculation
        while (true) {
            System.out.println("Enter operation (add, subtract, multiply, divide, exponent, exit):");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter numbers (separated by space):");
            String[] numbersStr = scanner.nextLine().split(" ");
            BigDecimal[] numbers = new BigDecimal[numbersStr.length];
            for (int i = 0; i < numbersStr.length; i++) {
                numbers[i] = new BigDecimal(numbersStr[i]);
            }

            BigDecimal result;
            switch (operation.toLowerCase()) {
                case "+" : case "sum": case "add": case "addition":
                    result = calculator.add(numbers);
                    break;

                case "-": case "sub": case "minus": case "subtract":
                    result = calculator.subtract(numbers);
                    break;

                case "*": case "multiply": case "times": case "product": case "x": case "into":
                    result = calculator.multiply(numbers);
                    break;

                case "divide": case "/": case "div": case "by":
                    result = calculator.divide(numbers);
                    break;

                case "exponent": case "^": case "power": case "pow": case "exp": case "raised": case "to the power of": case "to the power":
                    if (numbers.length != 2) {
                        System.out.println("Exponent operation only supports 2 numbers.");
                        continue;
                    }
                    result = calculator.exponent(numbers[0], numbers[1].intValue());
                    break;

                default:
                    System.out.println("Invalid operation.");
                    continue;
            }

            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}