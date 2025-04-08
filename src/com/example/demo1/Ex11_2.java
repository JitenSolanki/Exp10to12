package com.example.demo1;

import java.util.*;

public class Ex11_2 {

    public static void main(String[] args) {
        // Create and initialize first priority queue
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.addAll(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));

        // Create and initialize second priority queue
        PriorityQueue<String> queue2 = new PriorityQueue<>();
        queue2.addAll(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

        // Union
        PriorityQueue<String> union = new PriorityQueue<>(queue1);
        union.addAll(queue2);
        System.out.println("Union: " + new TreeSet<>(union)); // TreeSet to remove duplicates

        // Difference (queue1 - queue2)
        PriorityQueue<String> difference = new PriorityQueue<>(queue1);
        difference.removeAll(queue2);
        System.out.println("Difference (queue1 - queue2): " + difference);

        // Intersection
        PriorityQueue<String> intersection = new PriorityQueue<>(queue1);
        intersection.retainAll(queue2);
        System.out.println("Intersection: " + intersection);
    }
}
