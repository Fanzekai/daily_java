package demo02.kuangshen.threadStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/16  12:06
 */
public class liveThreadDemo {


        private static final int MAX_ITEMS = 5;
        private static final List<Integer> storage = new ArrayList<>();

        public static void main(String[] args) {
            Thread producer = new Thread(() -> {
                try {
                    System.out.println("生产者线程：NEW");
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread consumer = new Thread(() -> {
                try {
                    System.out.println("消费者线程：NEW");
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });



            producer.start();
            consumer.start();
        }

    private static void produce() throws InterruptedException {
        // 无限循环，模拟生产者不断生产的过程
        while (true) {
            // 同步代码块，确保线程安全
            synchronized (storage) {
                // 当存储空间已满时，生产者线程等待
                while (storage.size() >= MAX_ITEMS) {
                    System.out.println("生产者线程：WAITING");
                    storage.wait(); // 等待通知
                }
                // 生产一个随机物品
                int item = (int) (Math.random() * 100);
                // 将物品添加到存储空间中
                storage.add(item);
                System.out.println("生产者线程：RUNNABLE");
                System.out.println("生产了物品：" + item);
                // 通知其他等待的线程（可能是消费者线程）
                storage.notifyAll();
                // 模拟生产物品的时间间隔
                Thread.sleep(1000);
            }
        }
    }


    private static void consume() throws InterruptedException {
        // 无限循环，模拟消费者线程持续消费
        while (true) {
            // 同步代码块，确保线程安全
            synchronized (storage) {
                // 当存储为空时，消费者线程等待
                while (storage.isEmpty()) {
                    System.out.println("消费者线程：等待中...");
                    storage.wait(); // 释放锁并进入等待状态
                }
                // 从存储中移除第一个元素
                int item = storage.remove(0);
                System.out.println("消费者线程：运行中...");
                // 输出消费了哪个物品
                System.out.println("消费了物品：" + item);
                // 唤醒所有等待该锁的线程
                storage.notifyAll();
                // 模拟消费过程耗时
                Thread.sleep(5000);
            }
        }
    }

    }


