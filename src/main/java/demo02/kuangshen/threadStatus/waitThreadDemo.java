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
                this.wait(); // 生产者线程等待消费者消费数据
                System.out.println("生产者继续执行...");
            }
        }

        public void consume() throws InterruptedException {
            Thread.sleep(1000); // 模拟消费者准备时间
            synchronized (this) {
                System.out.println("消费者开始消费数据...");
                Thread.sleep(2000); // 模拟消费数据的时间
                System.out.println("消费者消费数据完毕，唤醒生产者继续生产...");
                this.notify(); // 唤醒生产者线程
            }
        }
    }
}

/*
wait()和notify()方法是Object类中的方法，它们的作用是用于线程间通信和同步。
  是作用在线程操作的对象上，当启动调用wait()时，
  线程会释放该对象上的锁，并进入等待状态，直到其他线程调用相同对象上的notify()或notifyAll()
* */

/*
WAITING 状态，表示线程的等待状态，在这种状态下，线程需要等待某个线程的特定操作才会被唤醒。使得线程进入到 WAITING 状态，在这个状态下，必须要等待特定的方法来唤醒，
比如 Object.notify 方法可以唤醒 Object.wait()方法阻塞的线程.

BLOCKED 状态是指线程在等待监视器锁的时候的阻塞状态。就是在多个线程去竞争 Synchronized 同步锁的时候，没有竞争到锁资源的
线程，会被阻塞等待，这个时候线程状态就是 BLOCKED

区别：
BLOCKED 是锁竞争失败后被被动触发的状态，WAITING 是人为的主动触发的状态
BLCKED 的唤醒时自动触发的，而 WAITING 状态是必须要通过特定的方法来主动唤醒
* */
