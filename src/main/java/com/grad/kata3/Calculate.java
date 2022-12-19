package com.grad.kata3;

public class Calculate {


    public static void main(String[] args) {

        calculateBinaryDigits(1000);
        calculateBinaryDigits(1000000);
        calculateBinaryDigits(1000000000);

    }

    private static void calculateBinaryDigits(long number) {
        StringBuilder stringBuilder = new StringBuilder();
        long num = number;
        while (num > 0) {
            num = num / 2;
            if (num % 2 == 0) {
                stringBuilder.append("0");
            } else {
                stringBuilder.append("1");
            }
        }
        System.out.println("Original number: " + number +
                "\nDigits we need: " + stringBuilder.length());

    }

}
