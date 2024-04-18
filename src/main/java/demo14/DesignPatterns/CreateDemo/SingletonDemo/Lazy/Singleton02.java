package demo14.DesignPatterns.CreateDemo.SingletonDemo.Lazy;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  14:56
 */
//懒汉式，线程安全
public class Singleton02 {
    private static Singleton02 instance;
    private Singleton02(){}
    public static synchronized Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }
}
