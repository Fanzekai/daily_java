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
