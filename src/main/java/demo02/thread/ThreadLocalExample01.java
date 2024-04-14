package demo02.thread;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  19:50
 */


/**
 * 创建了两个线程 thread1 和 thread2，分别设置和获取线程局部变量的值。
 * 由于每个线程都有自己独立的线程局部变量副本，因此线程之间互不干扰，各自设置和获取的值互不影响。
 * **/
public class ThreadLocalExample01 {

    // 创建一个 ThreadLocal 对象，用于存储线程局部变量
    private static final ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建两个线程，分别设置和获取线程局部变量
        Thread thread1 = new Thread(() -> {
            // 设置线程局部变量的值为 1
            threadLocalValue.set(1);
            // 获取线程局部变量的值并输出
            System.out.println("Thread 1 - ThreadLocal value: " + threadLocalValue.get());
        });

        Thread thread2 = new Thread(() -> {
            // 设置线程局部变量的值为 2
            threadLocalValue.set(2);
            // 获取线程局部变量的值并输出
            System.out.println("Thread 2 - ThreadLocal value: " + threadLocalValue.get());
        });

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
