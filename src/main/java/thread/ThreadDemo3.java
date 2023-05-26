package thread;

/**
 * Thread example implementing Runnable interface using anonymous inner class and lambda expressions.
 * join() and isAlive() example.
 */


public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

        System.out.println("This statement will print before t1 and t2 complete");
        System.out.println("t1.isAlive(): " + t1.isAlive());
        System.out.println("t2.isAlive(): " + t2.isAlive());

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // join will wait main thread to be execute the below statements after both thread complete.

        System.out.println("This statement will print after t1 and t2 complete");
        System.out.println("t1.isAlive(): " + t1.isAlive());
        System.out.println("t2.isAlive(): " + t2.isAlive());
    }
}
