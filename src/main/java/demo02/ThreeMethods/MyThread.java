package demo02.ThreeMethods;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  21:36
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        //线程执行的业务方法
        System.out.println("子线程执行");
        for (int i = 0;i < 5;i++){
            System.out.println("--- 线程名---："+Thread.currentThread().getName()+"，序号："+i);
        }
    }

    public static void main(String[] args) {
        //主线程
        System.out.println("***主线程执行***");
        System.out.println("***线程名***："+Thread.currentThread().getName());

        //创建一个线程并启动，只能通过主线程创建其他线程
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        //启动线程：start()方法（一旦启动，自动启动子线程，当前线程继续向下执行，不会等子线程）
        thread1.start();

        //启动多线程
        //多线程并发执行：不是正真一样上的并行执行(肉眼感官是并行)，而是通过cpu的调度算法，有序cpu执行极快，所以肉眼看起来是并行的；
        thread2.start();

        //调用run方法，不可以启动线程，就是对象的普通方法调用，等run方法执行结束，主线程才能继续执行
        //thread1.run();
        //thread2.run();

        System.out.println("----主线程执行结束----");

    }
}
