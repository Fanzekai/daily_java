package demo01.Abstractclasses;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  20:23
 */
public class Dog extends Animal{

    public Dog(String name ){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
}


/**抽象类的特点有以下几点：
        ● 抽象类不能被实例化，只能被继承。
        ● 抽象类可以包含抽象方法和非抽象方法。
        ● 抽象方法只有声明，没有实现。
        ● 抽象方法必须被子类实现。
        ● 抽象类可以被用来定义一些通用的方法和属性，让子类继承并实现它们。
 **/
