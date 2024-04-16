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
            while (true) {
                synchronized (storage) {
                    while (storage.size() >= MAX_ITEMS) {
                        System.out.println("生产者线程：WAITING");
                        storage.wait();
                    }
                    int item = (int) (Math.random() * 100);
                    storage.add(item);
                    System.out.println("生产者线程：RUNNABLE");
                    System.out.println("生产了物品：" + item);
                    storage.notifyAll();
                    Thread.sleep(1000);
                }
            }
        }

        private static void consume() throws InterruptedException {
            while (true) {
                synchronized (storage) {
                    while (storage.isEmpty()) {
                        System.out.println("消费者线程：WAITING");
                        storage.wait();
                    }
                    int item = storage.remove(0);
                    System.out.println("消费者线程：RUNNABLE");
                    System.out.println("消费了物品：" + item);
                    storage.notifyAll();
                    Thread.sleep(2000);
                }
            }
        }
    }


