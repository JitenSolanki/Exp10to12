package com.example.demo1;

class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // Print a message 5 times with 1-second delay
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
        }
    }
}

public class RunnableJoinDemo {
    public static void main(String[] args) {
        // Create Runnable object
        MyRunnable task1 = new MyRunnable("Thread-1");
        MyRunnable task2 = new MyRunnable("Thread-2");

        // Wrap in Thread objects
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        // Start first thread
        t1.start();

        try {
            // Wait for t1 to complete before starting t2
            t1.join(); // <-- join() used here
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Start second thread
        t2.start();
    }
}

