package demo14.DesignPatterns.CreateDemo.SingletonDemo.eHan;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  14:59
 */

//饿汉式
public class Singleton01 {
    private static Singleton01 instance = new Singleton01();
    private Singleton01 (){}
    public static Singleton01 getInstance() {
        return instance;
    }
}
