package demo02.kuangshen.threadStatus;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/16  11:32
 */
public class waitThreadDemo {


    public static void main(String[] args) {
        Data data = new Data();

        // 启动生产者线程
        Thread producerThread = new Thread(() -> {
            try {
                data.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producerThread.start();

        // 启动消费者线程
        Thread consumerThread = new Thread(() -> {
            try {
                data.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumerThread.start();
    }

// 当线程在 synchronized 代码块内调用wait()方法时，它会释放锁，并进入等待状态，
// 直到其他线程调用相同对象上的notify()或notifyAll()方法唤醒它。
    static class Data {
        public void produce() throws InterruptedException {
            synchronized (this) {
                System.out.println("生产者开始生产数据...");
                Thread.sleep(2000); // 模拟生产数据的时间
                System.out.println("生产者生产数据完毕，等待消费者消费...");
                wait(); // 生产者线程等待消费者消费数据
                System.out.println("生产者继续执行...");
            }
        }

        public void consume() throws InterruptedException {
            Thread.sleep(1000); // 模拟消费者准备时间
            synchronized (this) {
                System.out.println("消费者开始消费数据...");
                Thread.sleep(2000); // 模拟消费数据的时间
                System.out.println("消费者消费数据完毕，唤醒生产者继续生产...");
                notify(); // 唤醒生产者线程
            }
        }
    }
}
