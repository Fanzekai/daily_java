package demo02.kuangshen.threadJUC;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  21:43
 */
/*
* Synchronized 和 其他的BlockingQueue 不一样 它不存储元素；
put了一个元素，就必须从里面先take出来，否则不能再put进去值！
并且SynchronousQueue 的take是使用了lock锁保证线程安全的
* */
public class SynchronousQueueDemo {


    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();
        // 网queue中添加元素
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() +">>"+ "put 01");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() +">>"+ "put 02");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() +">>"+ "put 03");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 取出元素
        new Thread(()-> {
            try {
                System.out.println(Thread.currentThread().getName() + ">>"+"take" + synchronousQueue.take());
                System.out.println(Thread.currentThread().getName() + ">>"+"take" + synchronousQueue.take());
                System.out.println(Thread.currentThread().getName() + ">>"+"take" + synchronousQueue.take());
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
