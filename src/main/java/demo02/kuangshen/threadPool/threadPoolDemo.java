package demo02.kuangshen.threadPool;

import java.util.concurrent.*;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:54
 */
public class threadPoolDemo {

    public static void main(String[] args) {


        //自定义线程池，工作
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()//银行满了还有人进来，不处理这个人，抛出异常
//                new ThreadPoolExecutor.DiscardPolicy()//队列满了不会抛出异常，丢掉任务
//                new ThreadPoolExecutor.CallerRunsPolicy()//哪里来的去哪里
                new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试去和最早得竞争，也不会抛出异常
        );
        //最大承载：队列+max值
        for (int i = 0; i < 8; i++) {
            //使用了线程池之后,使用线程池来创建线程
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"ok");
            });
        }
        //线程池用完,程序结束,关闭线程池
        try {
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
