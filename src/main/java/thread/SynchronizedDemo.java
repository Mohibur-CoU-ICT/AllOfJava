package thread;

class Counter {
    int count;

    /**
     * Only one thread will access this method at a time.
     * That means this method is now thread safe.
     */
    synchronized void increment() {
        count++;
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.count);
    }
}
