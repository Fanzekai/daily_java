package demo02.kuangshen.threadJUC.SingletonDemo;

import java.lang.reflect.Constructor;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  16:56
 */
public class LazyMan3 {



    //私有化构造器
    private LazyMan3() {
        System.out.println(Thread.currentThread().getName() + "OK");
    }

    private volatile static LazyMan3 lazyMan;

    // 双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan3 getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan3.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan3();// 不是一个原子性操作
                }
            }
        }
        return lazyMan;
    }

    //多线程并发
    public static void main(String[] args) throws Exception {
        LazyMan3 instance = LazyMan3.getInstance();
        Constructor<LazyMan3> declaredConstructor = LazyMan3.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//无视私有构造器
        LazyMan3 instance2 = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(instance2);

    }
}
