package demo01.DateDemo;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/22  14:58
 */


public class UnsafeSimpleDateFormatDemo01 {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
            for (int i = 0; i < 3; i++) {
                // 在多线程环境下，共享同一个SimpleDateFormat对象可能导致线程不安全
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
