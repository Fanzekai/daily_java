package demo02.kuangshen.threadJUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  19:57
 */


/*
独占锁（写锁）一次只能被一个线程占有
共享锁（读锁）多个线程可以同时占有
* */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache2 myCache = new MyCache2();
        int num = 6;
        for (int i = 1; i <= num; i++) {
            int finalI = i;
            new Thread(() -> {

                myCache.write(String.valueOf(finalI), String.valueOf(finalI));

            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= num; i++) {
            int finalI = i;
            new Thread(() -> {

                myCache.read(String.valueOf(finalI));

            },String.valueOf(i)).start();
        }
    }
}


/**
 *  方法未加锁，导致写的时候被插队，自定义缓存
 *  多线程的读写会造成数据不可靠的问题
 */
class MyCache1 {
    private volatile Map<String, String> map = new HashMap<>();

    //存，写
    public void write(String key, String value) {
        System.out.println(Thread.currentThread().getName() + "线程开始写入");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "线程写入ok");
    }

    //取，读
    public void read(String key) {
        System.out.println(Thread.currentThread().getName() + "线程开始读取");
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "线程写读取ok");
    }
}

/*
* 可以采用synchronized这种重量锁和轻量锁 lock去保证数据的可靠。
但是这次我们采用更细粒度的锁：ReadWriteLock 读写锁来保证
* */
class MyCache2 {
    private volatile Map<String, String> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void write(String key, String value) {
        lock.writeLock().lock(); // 写锁
        try {
            System.out.println(Thread.currentThread().getName() + "线程开始写入");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "线程写入ok");

        } finally {
            lock.writeLock().unlock(); // 释放写锁
        }
    }

    public void read(String key) {
        lock.readLock().lock(); // 读锁
        try {
            System.out.println(Thread.currentThread().getName() + "线程开始读取");
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "线程写读取ok");
        } finally {
            lock.readLock().unlock(); // 释放读锁
        }
    }
}
