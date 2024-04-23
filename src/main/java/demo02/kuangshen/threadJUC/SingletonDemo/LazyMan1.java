package demo02.kuangshen.threadJUC.SingletonDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  16:40
 */


// 懒汉式单例
// 道高一尺，魔高一丈！
public class LazyMan1 {
    //私有化构造器
    private LazyMan1() {
        System.out.println(Thread.currentThread().getName()+">>"+"OK");
    }

    private static LazyMan1 lazyMan;

    public static LazyMan1 getInstance() {
        if (lazyMan == null) {
            lazyMan = new LazyMan1();
        }
        return lazyMan;
    }


    //多线程并，会有隐患！
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lazyMan.getInstance();
            }).start();
        }

    }
}
