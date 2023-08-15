package thread;

/**
 * Thread example implementing Runnable interface using anonymous inner class and lambda expressions.
 * getName(), setName(), getPriority(), setPriority() and currentThread() example.
 */


public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Hi Thread");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
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

        t2.setName("Hello Thread");
        System.out.println("t1.getName(): " + t1.getName());
        System.out.println("t2.getName(): " + t2.getName());

        // when a new thread is created it has priority of Thread.NORM_PRIORITY = 5
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println("t1.getPriority(): " + t1.getPriority());
        System.out.println("t2.getPriority(): " + t2.getPriority());

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
