package demo02.ScheduledTasks;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/8  11:16
 */
public class TimerTaskDemo {

    public static void main(String[] args) {

        // 示例代码：
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        timer.schedule(task, delay);



    }
}
