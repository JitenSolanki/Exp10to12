public class ThreadSumDemo {

    static Integer sum = 0; // shared variable
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Without Synchronization ===");
        runWithoutSync();

        // Reset sum
        sum = 0;

        System.out.println("\n=== With Synchronization ===");
        runWithSync();
    }

    public static void runWithoutSync() throws InterruptedException {
        Thread[] threads = new Thread[1000]; // increase threads for visible difference

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1); // force delay to show race condition
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum = sum + 1;
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final sum (without sync): " + sum);
    }

    public static void runWithSync() throws InterruptedException {
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    sum = sum + 1;
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Final sum (with sync): " + sum);
    }
}
