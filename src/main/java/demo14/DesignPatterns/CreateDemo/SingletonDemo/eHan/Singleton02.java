package demo14.DesignPatterns.CreateDemo.SingletonDemo.eHan;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:00
 */
//双检锁,双重校验锁
public class Singleton02 {
    private volatile static Singleton02 Singleton02;
    private Singleton02 (){}
    public static Singleton02 getSingleton02() {
        if (Singleton02 == null) {
            synchronized (Singleton02.class) {
                if (Singleton02 == null) {
                    Singleton02 = new Singleton02();
                }
            }
        }
        return Singleton02;
    }
}
