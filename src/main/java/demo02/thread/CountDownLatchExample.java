package demo02.thread;
import java.util.concurrent.CountDownLatch;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/28  14:48
 */
public class CountDownLatchExample  implements Runnable {
    private String serviceName;
    private CountDownLatch latch;

    public CountDownLatchExample(String serviceName, CountDownLatch latch) {
        this.serviceName = serviceName;
        this.latch = latch;
    }

    @Override
    public void run() {
        // 模拟从远程服务获取数据的耗时操作
        try {
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("Data fetched from " + serviceName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 每个线程执行完毕后，调用 countDown() 方法来减少计数器的值
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        int numServices = 3; // 假设有3个远程服务
        CountDownLatch latch = new CountDownLatch(numServices);

        // 启动多个线程，每个线程分别从一个远程服务获取数据
        for (int i = 1; i <= numServices; i++) {
            Thread thread = new Thread(new CountDownLatchExample("Service " + i, latch));
            thread.start();
        }

        try {
            // 主线程调用 await() 方法等待所有线程完成操作
            latch.await();
            System.out.println("All data fetched. Now proceed with further processing.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 主线程启动，并创建一个 CountDownLatch 实例，初始计数器设置为 3。这个计数器表示需要等待的线程数量。
 *
 * 主线程创建并启动三个子线程 CountDownLatchExample，每个线程负责从一个远程服务获取数据。
 *
 * 每个子线程开始执行，其中的模拟获取数据的操作可能需要一定的时间。在模拟获取数据的过程中，每个线程会调用 countDown() 方法来减少 CountDownLatch 的计数器。
 *
 * 主线程调用 latch.await() 方法，开始等待。由于初始计数器为 3，因此主线程会被阻塞，直到计数器为 0 或等待超时。
 *
 * 当每个子线程完成了数据获取操作后，它们会调用 countDown() 方法，每调用一次，CountDownLatch 的计数器就会减少一次。
 *
 * 当计数器变为 0 时，主线程从 await() 方法中返回，继续执行后续的逻辑。
 *
 * 主线程输出提示信息，表示所有数据都已经获取完毕，然后继续执行后续的处理逻辑。
 * **/
