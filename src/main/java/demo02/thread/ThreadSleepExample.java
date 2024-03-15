package demo02.thread;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/2  10:22
 */
public class ThreadSleepExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task: " + i);
                try {
                    Thread.sleep(1000); // 线程休眠1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(task).start();
    }
}

