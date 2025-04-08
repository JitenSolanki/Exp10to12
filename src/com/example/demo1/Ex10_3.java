package com.example.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex10_3 {

    // Generic method to remove duplicates from an ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 1, 2, 2, 3, 10, 3, 3, 4, 5, 5));

        System.out.println("ArrayList with duplicate elements: " + list);

        ArrayList<Integer> newList = removeDuplicates(list);

        System.out.println("ArrayList without duplicate elements: " + newList);
    }
}
