package demo01.interfaces;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  21:05
 */
public interface interfaceTest {
    //常量
    String LED ="LED";
    // 抽象方法
    int getElectricityUse();
    //静态方法
    static boolean isEnergyEfficient(String electtronicType) {
        return electtronicType.equals(LED);
    }
    // 默认方法
    default void printDescription(){
        System.out.println("电子");}

}


//接口中允许定义变量
// 接口中允许定义抽象方法
// 接口中允许定义静态方法(Java 8之后)
//接口中允许定义默认方法(Java8之后)
//接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法
// 在Java 8中，接口新增了默认方法，接口可以有实现方法，而且不需要实现类去实现其方法。
// 接口中的方法会被隐式的指定为public abstract，变量会被隐式的指定为public static final变量
