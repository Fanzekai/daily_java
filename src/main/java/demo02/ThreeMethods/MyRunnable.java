package demo02.ThreeMethods;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  21:35
 */
public class MyRunnable implements Runnable{

    private int num = 5;

    @Override
    public void run() {
        //线程执行的业务方法
        System.out.println("子线程执行");
        for (int i = 0;i < 5 ;i++){
            if(num>0){
                System.out.println("--- 线程名---："+Thread.currentThread().getName()+"，序号："+num--);
            }
        }
    }

    public static void main(String[] args) {
        //主线程
        System.out.println("***主线程执行***");
        System.out.println("***线程名***："+Thread.currentThread().getName());

        //创建一个子线程，并启动
        MyRunnable runnable1 = new MyRunnable();

        //实现Runnable接口方式创建的线程,不能自己启动，只能通过Thread类，将Runnable作为参数传入Thread类的构造方法中，
        // 构造线程对象，才可以启动
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        //创建多线程 (如果传入的Runnable参数一样，可以共享资源)
        Thread thread2 = new Thread(runnable1);
        thread2.start();

        System.out.println("----主线程执行结束----");

    }

}
