package com.example.demo1;

public class SleepThreadDemo extends Thread {

    public void run() {
        // Thread task: Print numbers with 1-second delay
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Count: " + i);
            try {
                // Sleep for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        // Create two threads
        SleepThreadDemo thread1 = new SleepThreadDemo();
        SleepThreadDemo thread2 = new SleepThreadDemo();

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
