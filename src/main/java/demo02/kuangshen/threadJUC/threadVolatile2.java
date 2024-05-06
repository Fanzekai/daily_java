package demo02.kuangshen.threadJUC;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  15:55
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 不保证原子性
 * number <=2w
 *不保证原子性
 * 原子性：不可分割；线程A在执行任务的时候，不能被打扰的，也不能被分割的，要么同时成功，要么同时失败。
 *
 */
public class threadVolatile2 {

        private static volatile int number = 0;

        public  static void add(){
            number++;
            //++ 不是一个原子性操作，是两个~3个操作
            //
        }
        public static void main(String[] args) {
            //理论上number  === 20000

            for (int i = 1; i <= 20; i++) {
                new Thread(()->{
                    for (int j = 1; j <= 1000 ; j++) {
                        add();
                    }
                }).start();
            }

            while (Thread.activeCount()>2){
                //main  gc
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+",num="+number);
        }
    }


