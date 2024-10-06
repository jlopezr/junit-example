package org.example;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public String compare(int a, int b) {
        if (a > b) {
            return a + " is greater than " + b;
        } else if (a < b) {
            return a + " is less than " + b;
        } else {
            return a + " is equal to " + b;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("5 + 3 = " + calculator.add(5, 3));
        System.out.println("5 - 3 = " + calculator.subtract(5, 3));
        System.out.println("5 * 3 = " + calculator.multiply(5, 3));
        System.out.println("5 / 3 = " + calculator.divide(5, 3));
    }
}