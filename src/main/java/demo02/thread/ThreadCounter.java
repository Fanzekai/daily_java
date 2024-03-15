package demo02.thread;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/2  10:20
 */
public class ThreadCounter {
    private static int count = 0;
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Count: " + count++);
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }
}
