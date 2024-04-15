package demo02.runnable;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  11:20
 */
public class threadExample {

    public static void main(String[] args) {

        new stu().start();

    }

}


class stu extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }
}
