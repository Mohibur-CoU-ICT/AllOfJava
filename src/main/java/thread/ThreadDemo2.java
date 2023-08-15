package thread;

/**
 * Thread example implementing Runnable interface.
 */

class Student implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Student");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Teacher implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Teacher");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable runnable1 = new Student();
        Runnable runnable2 = new Teacher();
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
