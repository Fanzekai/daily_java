package demo02.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/9  17:05
 */
public class test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        System.out.println("主线程开始执行");


        CountDownLatch countDownLatch = new CountDownLatch(3);


        try {
            Thread.sleep(2000); // 主线程睡眠2秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ExecutorService executorService = Executors.newWorkStealingPool(5);

        ArrayList<Future> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            int finalI = i;

            Future<Integer> submit = executorService.submit(() -> {

                System.out.println("任务开始执行"+ finalI);
                Thread.sleep(3000); // 使线程睡眠3秒钟
                System.out.println("任务执行完成"+finalI);
                return finalI;

            });
            list.add(submit);
            //countDownLatch.countDown();
        }



        System.out.println("等待任务执行完成");
        for (Future future : list) {
            future.get().toString();
        }

        countDownLatch.await();

        // 关闭线程池
        executorService.shutdown();

        System.out.println("主线程执行完成");
    }
}
