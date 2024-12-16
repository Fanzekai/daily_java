package demo01.DateDemo;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/22  15:04
 */
@Slf4j
public class SafeSimpleDateFormatExample02 {

    private static final ThreadLocal<SimpleDateFormat> threadLocalSdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    /**
     * 主方法，用于演示如何创建和启动线程。
     *
     * 此方法创建了两个线程，每个线程都运行一个 DatePrinter 实例。
     * DatePrinter 是一个实现了 Runnable 接口的类，其 run 方法包含要在线程中执行的代码。
     *
     * 通过调用 thread1.start() 和 thread2.start()，两个线程将并发执行，
     * 每个线程都会独立地打印当前日期和时间。
     *
     * @param args 命令行参数（本方法不使用）
     */
    public static void main(String[] args) {
        // 创建两个线程，并启动
        Thread thread1 = new Thread(new DatePrinter());
        Thread thread2 = new Thread(new DatePrinter());
        thread1.start();
        thread2.start();
    }

    static class DatePrinter implements Runnable {
        @Override
        public void run() {
            // 返回当前线程的线程局部变量的值--SimpleDateFormat实例
            SimpleDateFormat sdf = threadLocalSdf.get();
            for (int i = 0; i < 3; i++) {
                try {
                    // 睡眠一段随机时间，模拟并发场景
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 使用SimpleDateFormat格式化当前日期，并打印输出
                String formattedDate = sdf.format(new Date());
                System.out.println(Thread.currentThread().getName() + ": " + formattedDate);
            }
        }
    }
}
/*
* ThreadLocal实例通常用于在每个线程中存储其自己的数据，这些数据对其他线程不可见，因此可以避免线程安全问题。
* */
