package com.example.demo1;

public class Ex10_4{

    // Generic binary search method
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list[mid].compareTo(key) == 0) {
                return mid; // Key found
            } else if (list[mid].compareTo(key) < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Key not found
    }

    public static void main(String[] args) {
        // Integer array (must be sorted)
        Integer[] numbers = {1, 3, 5, 7, 9, 11, 13};

        int index = binarySearch(numbers, 9);
        System.out.println("Index of 9: " + index);

        // String array
        String[] words = {"apple", "banana", "cherry", "mango"};

        int wordIndex = binarySearch(words, "cherry");
        System.out.println("Index of 'cherry': " + wordIndex);
    }
}
