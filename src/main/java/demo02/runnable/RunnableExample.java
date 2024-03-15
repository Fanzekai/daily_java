package demo02.runnable;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  22:42
 */

import demo02.runnable.MyRunnable;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/2  10:13
 */
public class RunnableExample {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println("Task 1 is running");
        };
        MyRunnable myRunnable = new MyRunnable();

        new Thread(task1).start();
        new Thread(myRunnable).start();
    }
}
