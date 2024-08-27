package model;

public class Calculate {
    public int takeNumber(String number) {
        String intNumber = "";
        int count = 0;
        boolean decimal = true;
        while (decimal) {
            if (number.charAt(count) != ',') {
                intNumber += number.charAt(count);
                count++;
            } else {
                decimal = false;
            }
        }
        return Integer.parseInt(intNumber);
    }

    public double takeDecimalNumber(String number) {
        int index = number.indexOf(',');
        if (index == -1) {
            return 0.0;
        }

        String doubleNumber = "0.";
        index++;
        while (index < number.length()) {
            doubleNumber += number.charAt(index);
            index++;
        }

        return Double.parseDouble(doubleNumber);
    }

    public String convertIntegerPartToBase(int number, int base) {
        StringBuilder result = new StringBuilder();
        if (number == 0) {
            result.append("0");
        }

        while (number > 0) {
            int remainder = number % base;
            result.insert(0, remainder);
            number = number / base;
        }

        return result.toString();
    }

    public String convertDecimalPartToBase(double decimalPart, int base) {
        StringBuilder result = new StringBuilder();
        int maxIterations = 10;
        int count = 0;

        while (decimalPart > 0 || count < maxIterations) {
            decimalPart *= base;
            int digit = (int) decimalPart;
            result.append(digit);
            decimalPart -= digit;
            count++;
        }

        return result.toString();
    }
}
