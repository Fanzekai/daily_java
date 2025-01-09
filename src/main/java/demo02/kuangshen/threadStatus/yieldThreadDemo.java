package demo02.kuangshen.threadStatus;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:41
 */
/**
 * 测试礼让线程
 * 礼让不一定成功,看cpu心情
 */
public class yieldThreadDemo {



    public static void main(String[] args) {
        MyYeild myYeild = new MyYeild();
        new Thread(myYeild, "b").start();
        new Thread(myYeild, "a").start();

    }
}

class MyYeild implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();//礼让，使其他线程有机会执行
        System.out.println(Thread.currentThread().getName() + "线程已做出执行让步");
        // 继续执行其他任务...
    }

}
