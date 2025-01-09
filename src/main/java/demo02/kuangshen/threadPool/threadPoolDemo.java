package demo02.kuangshen.threadPool;

import java.util.concurrent.*;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:54
 */
public class threadPoolDemo {

    public static void main(String[] args) {

        // 自定义线程池，用于执行工作
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, // 核心线程数
                5, // 最大线程数
                3, // 线程保持活动的时间
                TimeUnit.SECONDS, // 时间单位
                new LinkedBlockingQueue<>(3), // 任务队列
                Executors.defaultThreadFactory(), // 线程工厂
                // 队列满了时的拒绝策略
                // new ThreadPoolExecutor.AbortPolicy() // 队列满了时，拒绝新任务并抛出异常
                new ThreadPoolExecutor.DiscardPolicy() // 队列满了时，丢弃新任务，不抛出异常
                // new ThreadPoolExecutor.CallerRunsPolicy() // 队列满了时，由调用线程处理该任务
                // new ThreadPoolExecutor.DiscardOldestPolicy() // 队列满了时，丢弃队列中最老的任务，尝试重新提交被拒绝的任务
        );

        // 最大承载量：队列大小 + 最大线程数
        for (int i = 1; i <= 11; i++) {
            // 使用线程池来创建并执行任务
            threadPoolExecutor.execute(() -> {
                // 打印当前执行任务的线程名称
                System.out.println(Thread.currentThread().getName() + " ok");
            });
        }

        // 线程池使用完毕，关闭线程池以释放资源
        try {
            threadPoolExecutor.shutdown(); // 发起关闭线程池的请求
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常堆栈信息
        } finally {
            // 清理资源（如果有的话）
        }
    }


}
