package demo01.Abstractclasses;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  20:20
 */

public abstract class Animal {

        private String name;

    public String getName(){
        return name;
    }

        public Animal(String name){
            this.name = name;
    }

    public void sleep(){
        System.out.println(name + "正在睡觉");
    }

    public abstract void eat();
}

/**

 抽象类的特点有以下几点：
 抽象类不能被实例化，只能被继承。
 抽象类可以包含抽象方法和非抽象方法。
 抽象方法只有声明，没有实现。
 抽象方法必须被子类实现。
 抽象类可以被用来定义一些通用的方法和属性，让子类继承并实现它们。
 一个类只能继承一个抽象类。

 **/
