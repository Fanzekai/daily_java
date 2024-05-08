package demo02.kuangshen.lockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/8  16:30
 */
/*可重入锁*/
public class ReentrantlockDemo03 {

    private final ReentrantLock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock(); // 获取锁
        try {
            System.out.println("进入 outerMethod");
            innerMethod(); // 调用内部方法
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public void innerMethod() {
        lock.lock(); // 再次获取同一把锁
        try {
            System.out.println("进入 innerMethod");
            // 内部方法逻辑
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public static void main(String[] args) {
        ReentrantlockDemo03 example = new ReentrantlockDemo03();
        example.outerMethod(); // 调用外部方法
    }
}
