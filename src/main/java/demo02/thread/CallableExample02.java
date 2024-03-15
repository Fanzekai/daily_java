package demo02.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/4  17:32
 */
public class CallableExample02 implements Callable<Integer> {


    private final int id;

    public CallableExample02(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        // 模拟一个耗时的计算任务
        Thread.sleep(5000); // 休眠5秒
        return id;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            System.out.println("提交任务");

            // 提交多个任务
            Future<Integer> future1 = executorService.submit(new CallableExample02(1));
            Future<Integer> future2 = executorService.submit(new CallableExample02(2));
            Future<Integer> future3 = executorService.submit(new CallableExample02(3));

            // 主线程继续执行其他操作
            System.out.println("主线程继续执行其他操作");

            // 等待任务结果时，可以进行其他操作
            // ...
            // 获取任务结果
            Integer result1 =future1.get();
            Integer result2 =future2.get();
            Integer result3 =future3.get();

            System.out.println("任务1的结果：" + result1);
            System.out.println("任务2的结果：" + result2);
            System.out.println("任务3的结果：" + result3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }



    }
}
