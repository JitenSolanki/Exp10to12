package com.example.demo1;

import java.util.Scanner;

public class Ex10_2 {

    // Recursive method to convert decimal to binary
    public static String dec2Bin(int value) {
        if (value == 0) {
            return "0";
        } else if (value == 1) {
            return "1";
        } else {
            return dec2Bin(value / 2) + (value % 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        // Convert and display binary equivalent
        String binary = dec2Bin(decimal);
        System.out.println("Binary equivalent: " + binary);

        scanner.close();
    }
}
