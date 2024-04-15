package demo02.kuangshen.threadJUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  16:19
 */

/*
* 解决：
 * 1.加synchronized,lock （不推荐，耗费性能）
 * 2.使用原子类的包装类
 * javac -p threadVolatile2.class 字节码文件
* */
public class threadVolatile3 {



        private static volatile AtomicInteger number = new AtomicInteger();

        public static void add(){
//        number++;
            number.incrementAndGet();  //底层是CAS保证的原子性，并发效率高
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

