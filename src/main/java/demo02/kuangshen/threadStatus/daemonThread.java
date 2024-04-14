package demo02.kuangshen.threadStatus;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:47
 */
/**
 * 测试守护线程
 * 上帝守护你
 */
public class daemonThread {



    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        //默认false表示是用户线程,正常的线程都是用户线程...
        thread.setDaemon(true);
        //上帝守护线程启动
        thread.start();
        //你 用户线程启动
        new Thread(you).start();
    }
}

//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}

//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("====goodbye!world====");
    }
}
