package demo02.kuangshen.lockDemo;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/4  17:34
 */
public class ReentrantlockDemo02 {



    public static void main(String[] args) {
        // 创建公平锁
        Lock fairLock = new ReentrantLock(true); // true 表示创建公平锁

        // 创建 5 个线程，分别获取锁
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(() -> {
                fairLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired fair lock");
                    // 在这里进行临界区操作
                    Thread.sleep(1000); // 模拟临界区操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    fairLock.unlock();
                }
            });
            thread.start();
        }
    }



}
