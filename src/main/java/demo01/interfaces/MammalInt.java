package demo01.interfaces;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  20:57
 */
public class MammalInt implements Animal,people{


    @Override
    public void eat() {
        System.out.println("Mammal eats");
    }

    @Override
    public void travel() {
        System.out.println("Mammal travels");
    }

    public int noofLegs(){
        return 0;
    }


    @Override
    public void play() {

    }

    @Override
    public void sleep() {

    }
}

/**
 * 一个类可以同时实现多个接口。
 * 一个类只能继承(extends)一个类，但是能实现(implements)多个接口。
 * 一个接口只能继承一个接口，不能实现接口
 * 一个接口能继承另一个接口，这和类之间的继承比较相似
 * 接口是隐式抽象的，所以声明时没有必要使用abstract关键字；
 * 接口的每个方法都是隐式抽象的，所以同样不需要使用abstract关键字；
 * 接口中的方法都是隐式public的
 * 接口中可以含有变量，但是接口中的变量会被隐式的指定为public static final变量（并且只能是 public，用 private 修饰会报编译错误）。
 * **/

