package thinkinjava.chap14;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/7/10
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private int threadNumber;
    private static int threadCount = 0;

    public SimpleThread() {
        threadNumber = ++threadCount;
        System.out.println("Making " + threadNumber);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread:" + threadNumber + " , countDown:" + countDown);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread().start();
        }
        System.out.println("All Threads Started");
    }

}

class Daemon extends Thread {
    private static final int SIZE = 10;
    private Thread[] t = new Thread[SIZE];

    public Daemon() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            t[i] = new DaemonSpawn(i);
        }
        for (int j = 0; j < SIZE; j++) {
            System.out.println(t[j].isDaemon());
        }
        while (true) {
            yield();
        }
    }
}

class DaemonSpawn extends Thread {
    public DaemonSpawn(int i) {
        System.out.println("DaemonSpawn" + i + " started");
        start();
    }

    @Override
    public void run() {
        while (true) {
            yield();
        }
    }
}