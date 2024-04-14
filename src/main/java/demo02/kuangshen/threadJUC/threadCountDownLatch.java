package demo02.kuangshen.threadJUC;

import java.util.concurrent.CountDownLatch;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:38
 */
public class threadCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"go out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //等待计数器归零才会向下执行
        countDownLatch.await();
        countDownLatch.countDown();//-1
    }
}

