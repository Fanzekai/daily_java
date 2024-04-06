package demo02.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/5  18:31
 */
public class test {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);


        for (int i = 0; i < 6; i++) {

            int finalI = i;
            executorService.execute(() -> {

                try {
                    System.out.println(finalI);
                    Thread.sleep(3000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }




        countDownLatch.await();

        executorService.shutdown();

    }

}
