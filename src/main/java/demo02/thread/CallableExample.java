package demo02.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/4  16:46
 */


public class CallableExample implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("任务开始执行");
        Thread.sleep(3000); // 使线程睡眠3秒钟
        System.out.println("任务执行完成");
        return 42;
    }

    public static void main(String[] args) {
        System.out.println("主线程开始执行");

         //主线程执行一些操作

        try {
            Thread.sleep(2000); // 主线程睡眠2秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 提交任务并获取Future对象
        Future<Integer> future = executorService.submit(new CallableExample());

        try {
            System.out.println("等待任务执行完成");
            Integer result = future.get();
            System.out.println("任务执行结果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();

        System.out.println("主线程执行完成");
    }
}
