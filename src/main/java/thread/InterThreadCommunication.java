package thread;


class Num {
    int num;
    boolean numSet = false;

    public synchronized int getNum() {
        while (!numSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        numSet = false;
        System.out.println("Get num: " + num);
        notify();
        if (num == 19) {
            System.exit(0);
        }
        return num;
    }


    public synchronized void setNum(int num) {
        while (numSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.num = num;
        System.out.println("Set num: " + num);
        numSet = true;
        notify();
    }
}


class Producer implements Runnable {
    Num num;

    public Producer(Num num) {
        this.num = num;
        Thread thread = new Thread(this, "Producer");
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;
        do {
            num.setNum(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (i != 20);
    }
}


class Consumer implements Runnable {
    Num num;

    public Consumer(Num num) {
        this.num = num;
        Thread thread = new Thread(this, "Consumer");
        thread.start();
    }

    @Override
    public void run() {
        int n;
        do {
            n = num.getNum();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (n != 20);
    }
}


public class InterThreadCommunication {
    public static void main(String[] args) {
        Num num = new Num();
        new Producer(num);
        new Consumer(num);
    }
}
