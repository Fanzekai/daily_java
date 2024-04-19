package demo02.kuangshen.lockDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/19  19:24
 */
/*
原本对象锁已经被调用了，但是现在被同一线程又调用了，这就是可重入锁。
* */
public class ReentrantlockDemo {


    public static void main(String[] args) {
        Counter counter = new Counter();

        // 创建一个线程，连续调用 increment() 方法
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        });

        // 创建另一个线程，连续调用 decrement() 方法
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.decrement();
            }
        });

        // 启动两个线程
        thread1.start();
        thread2.start();
    }
}
//当一个线程调用 increment() 方法时，它会获取 Counter 对象的内置锁，然后执行 increment() 方法中的代码。
//在 increment() 方法的代码执行过程中，如果又调用了 decrement() 方法，由于 decrement() 方法也是同步方法，
// 它会尝试再次获取 Counter 对象的内置锁。一般来说，一个线程持有锁期间，其他线程都无法获取该锁。
//因为 Java 中的锁是可重入的，即同一个线程在持有锁的情况下可以再次获取同一个锁，所以在 increment() 方法中调用 decrement() 方法时，同一个线程可以顺利地再次获取 Counter 对象的内置锁，而不会被阻塞。
