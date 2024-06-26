package demo02.kuangshen.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:50
 */
public class threadExecutors {

    public static void main(String[] args) {


        //Executors工具类,三大方法底层都调用得是ThreadPoolExecutor
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
         ExecutorService threadPool2 = Executors.newFixedThreadPool(5);//创建一个固定大小得线程池
        ExecutorService threadPool3 = Executors.newCachedThreadPool();//可伸缩，线程数可变



        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
        for (int i = 0; i < 10; i++) {
            //使用了线程池之后,使用线程池来创建线程
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"ok");
            });
        }
        //线程池用完,程序结束,关闭线程池
        try {
            threadPool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
/***
 * public ThreadPoolExecutor(int corePoolSize,//核心线程数量
 *                               int maximumPoolSize,//最大核心线程大小
 *                               long keepAliveTime,//超时时间，没人用就会释放
 *                               TimeUnit unit,//超时单位
 *                               BlockingQueue<Runnable> workQueue,//阻塞队列
 *                               ThreadFactory threadFactory,//线程工厂，创建线程，一般不用动
 *                               RejectedExecutionHandler handler) {//拒绝策略

 * **/


//线程池里面用到了阻塞队列，简单来说就是线程池
//里面的工作线程处于一直运行状态，它会从阻塞队列中去获取待执行的任务，一旦队列
//空了，那这个工作线程就会被阻塞，直到下次有新的任务进来。
//也就是说，工作线程是根据任务的情况实现阻塞和唤醒，从而达到线程复用的目的
