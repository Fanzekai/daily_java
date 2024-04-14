package demo02.kuangshen.threadStatus;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:36
 */
public class stopThreadDemo implements Runnable {
    // 1. 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }
    }

    // 2. 设置一个公开的方法停止线程,转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        stopThreadDemo stop = new stopThreadDemo();
        new Thread(stop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main..." + i);
            if (i == 900) {
                //调用stop()切换标志位,让线程终止
                stop.stop();
                System.out.println("该线程停止了");
            }
        }
    }
}

