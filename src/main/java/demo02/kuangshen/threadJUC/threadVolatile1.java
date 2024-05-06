package demo02.kuangshen.threadJUC;

import java.util.concurrent.TimeUnit;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  15:31
 */
public class threadVolatile1 {

        // 如果不加volatile 程序会死循环
        // 加了volatile是可以保证可见性的
        private   static Integer number = 0;

        public static void main(String[] args) {
            //main线程
            //子线程1
            new Thread(()->{
                while (number==0){
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //子线程2
            new Thread(()->{
                while (number==0){
                    System.out.println(Thread.currentThread().getName());

                }

            }).start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number=1;//volatile会把工作内存的变量刷新到子线程1工作内存中
            System.out.println(number);
        }
    }



/**
 * JMM
 * volatile是java虚拟机提供的轻量级的同步机制
 * 1.保证可见性
 * 2.不保证原子性
 * 3.由于内存屏障,禁止指令重排
 * 什么是JMM
 * JMM:java的内存模型,不存在的东西,概念,约定
 * 关于JMM的一些同步的约定:
 * 1.线程解锁前,必须把共享变量立刻刷回主存
 * 2.线程枷锁前,必须读取主存中的最新值到工作的内存中
 * 3.加锁和解锁是同一把锁
 * 线程:工作内存 ,主内存
 * **/
