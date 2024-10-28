package model;

public class CalculatorModel {
    private double result;

    public double getResult() {
        return result;
    }

    public void add(double number1, double number2) {
        result = number1 + number2;
    }

    public void subtract(double number1, double number2) {
        result = number1 - number2;
    }

    public void multiply(double number1, double number2) {
        result = number1 * number2;
    }

    public void divide(double number1, double number2) {
        if (number2 != 0) {
            result = number1 / number2;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }
}
