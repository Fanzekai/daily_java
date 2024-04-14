package demo02.kuangshen.threadStatus;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:42
 */
/**
 * 测试join
 * 插队
 */
public class joinThreadDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("线程vip" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        joinThreadDemo joinThread = new joinThreadDemo();
        Thread thread = new Thread(joinThread);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join();//插队
            }
            System.out.println("main" + i);
        }
    }
}
