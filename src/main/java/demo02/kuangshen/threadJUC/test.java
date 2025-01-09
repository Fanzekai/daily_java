package demo02.kuangshen.threadJUC;

import java.util.concurrent.*;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:29
 */
public class test {



    public static void main(String[] args) {
        // 创建一个ThreadPoolExecutor线程池执行器
        // 核心线程数为2
        // 最大线程数为5
        // 线程保持活动的时间为1秒
        // 时间单位为SECONDS
        // 任务队列为LinkedBlockingDeque，容量为3
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(
                2, // 核心线程数
                5,  // 最大线程数
                1,  // 线程保持活动的时间
                TimeUnit.SECONDS, // 时间单位
                new LinkedBlockingDeque<>(3) // 任务队列
        );
        // 获取cpu的核数
        // 输出当前系统可用的处理器数量，这对于决定线程池的大小有一定的参考价值
        // 如果是cpu密集型任务，线程池大小通常设置为处理器数量
        // 如果是io密集型任务，线程池大小可以设置为处理器数量的2倍左右
        System.out.println(Runtime.getRuntime().availableProcessors());
    }



    }
