package com.example.demo1;

public class Ex10_1 {

    // Recursive method to convert decimal to binary
    public static String dec2Bin(int value) {
        // Base case: if the value is 0 or 1, return it as a string
        if (value == 0) {
            return "0";
        } else if (value == 1) {
            return "1";
        } else {
            // Recursive case:
            // Divide the number by 2 and call dec2Bin on the result,
            // then append the remainder (value % 2) to the binary string.
            return dec2Bin(value / 2) + (value % 2);
        }
    }

    // Test the method
    public static void main(String[] args) {
        int decimal = 19;
        String binary = dec2Bin(decimal);
        System.out.println("Binary of " + decimal + " is: " + binary);
    }
}
