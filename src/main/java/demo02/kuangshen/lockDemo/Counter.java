package demo02.kuangshen.lockDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/19  19:24
 */
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Incremented: " + count);
        decrement(); // 在持有锁的情况下调用另一个同步方法
    }

    public synchronized void decrement() {
        count--;
        System.out.println("Decremented: " + count);
    }
}
