package demo02.kuangshen.threadStatus;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/16  11:37
 */
public class isAliveThreadDemo {


        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000); // 模拟线程执行任务的时间
                    System.out.println("线程执行完毕！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("线程是否处于活动状态：" + thread.isAlive()); // 输出false，因为线程还没有启动
            thread.start();
            System.out.println("线程是否处于活动状态：" + thread.isAlive()); // 输出true，因为线程正在运行

            //主线程等待子线程执行完毕后再继续执行，你需要在主线程中调用 join() 方法等待子线程的结束。
            // 否则，主线程会继续执行下去，而不管子线程的状态如何。
            thread.join();
            System.out.println("线程是否处于活动状态：" + thread.isAlive()); // 输出false，因为线程已经终止
        }
    }

/**
 * 当一个线程处于以下任何一种状态时，isAlive()方法会返回true：
 *
 * 线程已经被创建，但尚未启动；
 * 线程正在运行中；
 * 线程因为调用wait()方法而处于等待状态；
 * 线程因为调用join()方法而等待另一个线程的终止。
 *
 * 当一个线程处于以下状态之一时，isAlive()方法会返回false：
 * 线程已经终止；
 * 线程还没有被创建。
 *
 */
