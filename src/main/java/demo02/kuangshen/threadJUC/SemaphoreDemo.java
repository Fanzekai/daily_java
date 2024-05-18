package demo02.kuangshen.threadJUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  19:37
 */
//累加计算器
public class SemaphoreDemo {

    public static void main(String[] args) {

        // 线程数量：停车位! 用来限流！
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                //acquire() 得到
                //release() 释放
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位！");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位！");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();

        }
    }
}
