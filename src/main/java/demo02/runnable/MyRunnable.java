package demo02.runnable;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/2  10:29
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程名：" + Thread.currentThread().getName());
    }
}
