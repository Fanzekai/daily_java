package demo02.kuangshen.threadJUC;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:39
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //集齐七颗龙珠，召唤神龙
        //召唤龙珠
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功");
        });
        for (int i = 0; i <= 7; i++) {
            final int temp = i;
            //lambda不能直接拿到for循环中的i
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

