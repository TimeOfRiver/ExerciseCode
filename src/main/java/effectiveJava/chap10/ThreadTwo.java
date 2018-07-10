package effectiveJava.chap10;

import java.util.concurrent.*;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/7/1
 */
public class ThreadTwo {

    // executor和task优先于线程

    // 工作单元：任务（task），分为两种：Runnable及其近亲Callable(与Runnable类似，但是有返回值)
    // 执行机制：executor service
    // 并发工具优先于wait和notify，java的Concurrent包中的高级工具分成三类:Executor Framework、并发集合(Concurrent Collection)、同步器(Synchronizer)

    // 并发集合为标准的集合接口（如List、Queue、Map等）提供了高性能的并发实现，并发集合中不可能排除并发活动；将它锁定没有什么作用，只会使程序的速度变慢
    // 集合接口：依赖状态的修改操作

    // wait循环模式调用wait方法；永远不要在循环之外调用wait方法。循环会在等待之前和之后测试条件。
    //synchronized (obj) {
    //        while(<condition does not hold>)
    //        obj.wait(); // (Releases lock,and reacquires on wakeup)
    //    ...// Perform action appropriate to condition
    //}

    // 线程安全性的文档化：一个类为了可被多个线程安全的使用，必须在文档中清楚地说明它所支持的线程安全性级别
    // 常见的几种线程安全级别：
    // （1）不可变的（immutable）-----这个类的实例是不变的。所以，不需要外部的同步。这样的例子包括String、Long和BigInteger
    // （2）无条件的线程安全（unconditionally thread-safe）-----这个类的实例是可变的，但是这个类有着足够的内部同步，所以，它的实例可以被并发使用，无需任何外部同步。其例子包括Random和ConcurrentHashMap.
    // （3）有条件的线程安全（conditionally thread-safe）-----除了有些方法为进行安全的并发使用而需要外部同步之外，这种线程安全级别与无条件的线程安全相同。这样的例子包括Collections.synchronized包装返回的集合，它们的迭代器要求外部同步
    // （4）非线程安全（not thread-safe）-----这个类的实例是可变的。为了并发地使用它们，客户必须利用自己选择的外部同步包围每个方法调用（或者调用序列）。这样的例子包括通过的集合实现，例如ArrayList和HashMap
    // （5）线程对立的（thread-hostile）-----这个类不能安全地被多个线程并发使用，即使所有的方法调用都被外部同步包围。线程对立的根源通常在于，没有同步地修改静态数据。在java类库中，这种类或者方法非常少。System.runFinalizersOnExit方法是线程对立的，已经被移除了
    // 把锁对象封装在它所同步的对象中,私有锁对象模式只能用无条件的线程安全类上


    // 慎用延迟初始化
    // 使用双重检查，推荐使用，这是延迟初始化一个实例域的方法
    //private volatile FieldType field;
    //FieldType getField() {
    //    FieldType result = field;
    //    if(result == null) { // first check with no lock
    //        synchronized (this){
    //            result = field;
    //            if(result == null) { second check with lock
    //                field = result = computeFieldValue();
    //            }
    //        }
    //    }
    //    return result;
    //}

    // 单重检查模式
    //private volatile FieldType field;
    //FieldType getField() {
    //    FieldType result = field;
    //    if(result == null) {
    //        result = field = computeFieldValue();
    //    }
    //    return result;
    //}


    // 不要依赖于线程调度器：任何依赖于线程调度器来达到正确性或者性能要求的程序，很有可能都是不可移植的

    // 避免使用线程组：线程组已经过时了，尽量避免使用
    // 当线程抛出未被捕获的异常时，ThreadGroup.uncaughtException方法是获得控制权的唯一方式，这项功能很有用，比如可把堆栈轨迹定向到一个特定于应用程序的日志中；Java 1.5发布后，Thread的setUncaughtExceptionHandler方法也提供了同样的功能
    // 总之，线程组提供的很多功能是有缺陷的，如果要设计一个类需要处理线程的逻辑组，可考虑线程池executor

    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a thread");
            }
        });
        executorService.shutdown();
    }

    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null) {
                return s;
            }
        }
        return result;

    }

    public static long time(Executor executor,int concurrency,final Runnable action) throws InterruptedException{
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ready.countDown();
                    try {
                        start.await();
                        action.run();
                    } catch(InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown();
                    }
                }
            });
        }
        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        // 对于间歇式的定时，始终应该优先使用System.nanoTime,而不是System.currentTimeMills,因为nanoTime更加准确，也更加精确，它不受系统的实时时钟的调整所影响
        return System.nanoTime() - startNanos;

    }

}




