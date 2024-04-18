package demo14.DesignPatterns.CreateDemo.SingletonDemo.Lazy;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  14:56
 */

//懒汉式，线程不安全
public class Singleton01 {
    private static Singleton01 instance;
    private Singleton01(){}

    public static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}
