package com.example.demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex11_3 {

    public static void main(String[] args) {
        // Create a map of Indian states and their capitals
        Map<String, String> stateCapitalMap = new HashMap<>();

        stateCapitalMap.put("Maharashtra", "Mumbai");
        stateCapitalMap.put("Gujarat", "Gandhinagar");
        stateCapitalMap.put("Rajasthan", "Jaipur");
        stateCapitalMap.put("Punjab", "Chandigarh");
        stateCapitalMap.put("Uttar Pradesh", "Lucknow");
        stateCapitalMap.put("Madhya Pradesh", "Bhopal");
        stateCapitalMap.put("Tamil Nadu", "Chennai");
        stateCapitalMap.put("West Bengal", "Kolkata");
        stateCapitalMap.put("Karnataka", "Bengaluru");
        stateCapitalMap.put("Bihar", "Patna");

        // Take user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of an Indian state: ");
        String userState = scanner.nextLine().trim();

        // Check and display the capital
        if (stateCapitalMap.containsKey(userState)) {
            System.out.println("The capital of " + userState + " is: " + stateCapitalMap.get(userState));
        } else {
            System.out.println("State not found in the list.");
        }

        scanner.close();
    }
}
