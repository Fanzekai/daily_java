package demo02.kuangshen.threadStatus;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/16  11:24
 */

/*
* interrupt()方法只是设置了中断状态，并不能直接终止线程的执行。线程需要自行检查中断状态并作出相应的响应*/

public class interruptThreadDemo {

    //日志
    private static final Logger log = LoggerFactory.getLogger(interruptThreadDemo.class);

    public static void main(String[] args) {


        Thread taskThread = new Thread(new Task());
        taskThread.start();

        // 让主线程睡眠一段时间，然后中断任务线程
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断任务线程
        taskThread.interrupt();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                // 模拟一个长时间运行的任务，任务会在每次迭代时检查中断状态
                for (int i = 0; i < 10; i++) {
                    boolean interrupted = Thread.currentThread().isInterrupted();
                    log.info("中断状态：" + interrupted);
                    if (interrupted) {
                        System.out.println("任务被中断，退出执行。");
                        return;
                    }
                    System.out.println("任务正在执行，迭代次数：" + i);
                    Thread.sleep(1000); // 模拟任务执行时间
                }
            } catch (InterruptedException e) {
                // 当线程在sleep时被中断，会抛出InterruptedException
                System.out.println("任务被中断，退出执行。");
            }
        }
    }
}
