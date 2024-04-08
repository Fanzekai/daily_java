package demo02.thread;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/7  9:23
 */
public class WaitNotifyExample {
    private final Object lock = new Object();
    private boolean condition = false;

    public void waitForCondition() throws InterruptedException {
        synchronized (lock) {
            // 等待条件满足
            while (!condition) {
                System.out.println("等待条件满足...");
                lock.wait(); // 释放锁并等待被唤醒
            }
            // 条件满足，执行相应操作
            System.out.println("条件已满足，继续执行...");
        }
    }

    public void notifyCondition() {
        synchronized (lock) {
            // 更改条件并通知等待的线程
            condition = true;
            System.out.println("条件已被设置为满足，唤醒等待的线程...");
            lock.notify(); // 唤醒一个等待的线程
        }
    }

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();

        // 创建等待线程
        Thread waitThread = new Thread(() -> {
            try {
                example.waitForCondition();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 创建唤醒线程
        Thread notifyThread = new Thread(() -> {
            example.notifyCondition();
        });

        // 启动线程
        waitThread.start();
        notifyThread.start();
    }
}
