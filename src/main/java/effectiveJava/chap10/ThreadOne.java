package effectiveJava.chap10;


import java.util.concurrent.atomic.AtomicLong;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/26
 */
public class ThreadOne {
    // 同步访问共享的可变数据
    // 可见性、可变性
    // 当多个线程共享可变数据的时候，每个读或者写数据的线程都必须执行同步


}

class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    private static final AtomicLong nextSerialNumber = new AtomicLong();

    public static long generateSerialNumber() {
        return nextSerialNumber.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested()) {
                    i++;
                }
            }
        });
        backgroundThread.start();
        Thread.sleep(1000);
        requestStop();

        System.out.println(generateSerialNumber());
    }
}
